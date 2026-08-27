inherit rockchip-image

IMAGE_POSTPROCESS_COMMAND:append = " link_rootfs_image;"
link_rootfs_image() {
	ln -sf "${IMAGE_LINK_NAME}.${RK_ROOTFS_TYPE}" \
		"${IMGDEPLOYDIR}/rootfs.img"
}

ROOTFS_POSTPROCESS_COMMAND:append = " do_post_rootfs;"
do_post_rootfs() {
	# Rockchip BSP rkwifibt drivers would use custom firmware directories
	for dir in vendor system;do
		firmware_dir=${IMAGE_ROOTFS}/${dir}/etc/
		mkdir -p ${firmware_dir}
		ln -rsf ${IMAGE_ROOTFS}/${nonarch_base_libdir}/firmware \
			${firmware_dir}
	done
}
