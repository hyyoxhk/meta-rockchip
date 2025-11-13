export RK_ROOTDEV_UUID ?= "614e0000-0000-4b53-8000-1d28000054a9"
export RK_PARTITION_GROW ?= "1"

IMAGE_FSTYPES:remove = "iso live"
export RK_ROOTFS_TYPE ?= "ext4"

WKS_FILE ?= "generic-gptdisk.wks.in"

IMAGE_FSTYPES:append = " ${RK_ROOTFS_TYPE} wic"

do_gen_rkupdateimg() {
	build_updateimg="${WORKDIR}/build-updateimg"
	if [ -e "$build_updateimg" ]; then
		# Ensure we don't have any junk leftover from a previously interrupted
		# do_image_wic execution
		rm -rf "$build_updateimg"
	fi

	if [ ! -f "${DEPLOY_DIR_IMAGE}/loader.bin" ];then
		echo "Skip packing Rockchip update image."
		return
	fi

	mkdir -p ${build_updateimg}

	# Generating parameter
	touch ${build_updateimg}/parameter

	echo "# IMAGE_NAME: $(readlink ${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.wic)" > "${build_updateimg}/parameter"
	echo "FIRMWARE_VER: 1.0" >> "${build_updateimg}/parameter"
	echo "TYPE: GPT" >> "${build_updateimg}/parameter"
	echo -n "CMDLINE: mtdparts=rk29xxnand:" >> "${build_updateimg}/parameter"

	part_i=0
	sgdisk -p ${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.wic | grep -E "^ +[0-9]" | while read line;do
		part_i=$(expr $part_i + 1)
		NAME=$(echo ${line} | cut -f 7 -d ' ')
		START=$(echo ${line} | cut -f 2 -d ' ')
		END=$(echo ${line} | cut -f 3 -d ' ')
		printf "0x%08x@0x%08x(%s)," "${SIZE}" "${START}" "${NAME}" >> "${build_updateimg}/parameter"
		cp "${WORKDIR}/build-wic/"*.direct.p${part_i} "${build_updateimg}/${NAME}.img"
	done

	echo >> "${build_updateimg}/parameter"

	if [ "$RK_PARTITION_GROW" = "1" ];then
		sed -i "s/[^,]*\(@[^,]*\)),$/-\1:grow)/" "${build_updateimg}/parameter"
	fi

	echo "uuid: rootfs=${RK_ROOTDEV_UUID}" >> "${build_updateimg}/parameter"

	# Generating package-file
	touch ${build_updateimg}/package-file

	echo "# IMAGE_NAME: $(readlink ${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.wic)" > "${build_updateimg}/package-file"
	echo "package-file package-file" >> "${build_updateimg}/package-file"
	echo "bootloader loader.bin" >> "${build_updateimg}/package-file"
	echo "parameter parameter" >> "${build_updateimg}/package-file"
	grep -o "([^)^:]*" ${build_updateimg}/parameter | tr -d "(" | while read NAME;do
		case "${NAME}" in
			uboot-env) IMAGE="uboot.env" ;;
			*) IMAGE="${NAME}.img" ;;
		esac

		[ ! -r "${build_updateimg}/${IMAGE}" ] || echo "$NAME $IMAGE" >> "${build_updateimg}/package-file"
	done

	cp ${DEPLOY_DIR_IMAGE}/loader.bin ${build_updateimg}/loader.bin

	PSEUDO_DISABLED=1
	afptool -pack ${build_updateimg} ${build_updateimg}/update.raw.img
	rkImageMaker -RK$(hexdump -s 21 -n 4 -e '4/1 "%c"' ${build_updateimg}/loader.bin | rev) \
		${build_updateimg}/loader.bin ${build_updateimg}/update.raw.img "${IMGDEPLOYDIR}/${IMAGE_NAME}.update.img" \
		-os_type:androidos

	rm -rf ${build_updateimg}/update.raw.img

	ln -sf "${IMAGE_NAME}.update.img" ${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.update.img
	ln -sf "${IMAGE_LINK_NAME}.update.img" ${IMGDEPLOYDIR}/update.img

	cp ${build_updateimg}/package-file ${IMGDEPLOYDIR}/${IMAGE_NAME}.package-file
	ln -sf "${IMAGE_NAME}.package-file" ${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.package-file
	ln -sf "${IMAGE_LINK_NAME}.package-file" ${IMGDEPLOYDIR}/package-file

	cp ${build_updateimg}/parameter ${IMGDEPLOYDIR}/${IMAGE_NAME}.parameter
	ln -sf "${IMAGE_NAME}.parameter" ${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.parameter
	ln -sf "${IMAGE_LINK_NAME}.parameter" ${IMGDEPLOYDIR}/parameter
}
do_gen_rkupdateimg[cleandirs] = "${WORKDIR}/build-updateimg"
do_gen_rkupdateimg[depends] += "rk-binary-native:do_populate_sysroot"
do_gen_rkupdateimg[deptask] += "do_image_wic"

addtask do_gen_rkupdateimg after do_image_wic before do_image_complete
