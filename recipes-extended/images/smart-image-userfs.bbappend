IMAGE_POSTPROCESS_COMMAND:append = " link_userfs_image;"
link_userfs_image() {
	ln -sf "${IMAGE_LINK_NAME}.ext4" \
		"${IMGDEPLOYDIR}/userfs.img"
}
