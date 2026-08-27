SUMMARY = "SWUpdate image for smart-image-standard"
DESCRIPTION = "Build a SWU compound update image containing the root filesystem and Rockchip fitImage with initrd."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit swupdate

SRC_URI = " \
    file://emmcsetup.lua \
    file://sw-description \
"

SWUPDATE_ROOTFS_IMAGE ?= "${DM_VERITY_IMAGE}"
SWUPDATE_ROOTFS_FSTYPE ?= ".${DM_VERITY_IMAGE_TYPE}.verity"
SWUPDATE_ROOTFS_FILENAME ?= "${SWUPDATE_ROOTFS_IMAGE}-${MACHINE}${SWUPDATE_ROOTFS_FSTYPE}"

SWUPDATE_INITRD_IMAGE ?= "${INITRAMFS_IMAGE}"
SWUPDATE_KERNEL_IMAGE ?= "fitImage-${SWUPDATE_INITRD_IMAGE}-${MACHINE}-${MACHINE}"

# Build the image and kernel deploy artifacts before assembling the SWU.
IMAGE_DEPENDS = " \
    ${SWUPDATE_ROOTFS_IMAGE} \
    ${SWUPDATE_INITRD_IMAGE} \
    linux-rockchip \
"

# The SWU task consumes the initrd-enabled fitImage from DEPLOY_DIR_IMAGE.
do_swuimage[depends] += " \
    ${SWUPDATE_INITRD_IMAGE}:do_image_complete \
    linux-rockchip:do_deploy \
"

# Files that will be copied from DEPLOY_DIR_IMAGE into the .swu archive.
SWUPDATE_IMAGES = " \
    ${SWUPDATE_KERNEL_IMAGE} \
    ${SWUPDATE_ROOTFS_IMAGE} \
"

# Keep SWUpdate varflags aligned with the configurable artifact names above.
python __anonymous() {
    rootfs_image = d.getVar("SWUPDATE_ROOTFS_IMAGE")
    rootfs_fstype = d.getVar("SWUPDATE_ROOTFS_FSTYPE")
    kernel_image = d.getVar("SWUPDATE_KERNEL_IMAGE")

    if rootfs_image and rootfs_fstype:
        d.setVarFlag("SWUPDATE_IMAGES_FSTYPES", rootfs_image, rootfs_fstype)
    if kernel_image:
        # linux-rockchip deploys this stable initrd fitImage symlink without an extra MACHINE suffix.
        d.setVarFlag("SWUPDATE_IMAGES_NOAPPEND_MACHINE", kernel_image, "1")
}

do_swuimage[vardeps] += "SWUPDATE_ROOTFS_IMAGE SWUPDATE_ROOTFS_FSTYPE SWUPDATE_ROOTFS_FILENAME SWUPDATE_INITRD_IMAGE SWUPDATE_KERNEL_IMAGE"
