inherit rockchip-image

IMAGE_POSTPROCESS_COMMAND:append = " link_rootfs_image;"
link_rootfs_image() {
	ln -sf "${IMAGE_LINK_NAME}.${RK_ROOTFS_TYPE}" \
		"${IMGDEPLOYDIR}/rootfs.img"
}
