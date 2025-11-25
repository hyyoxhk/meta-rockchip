# Copyright (C) 2024, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require linux-rockchip.inc

inherit local-git

SRCREV = "f8d85f31218732dd2903e6290dade05724ff6548"
SRC_URI = " \
	git://${YUNMY_GITLAB_URL}/board/kernel.git;protocol=${YUNMY_GITLAB_PROTOCOL};nobranch=1;branch=main; \
	file://${THISDIR}/files/cgroups.cfg \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_VERSION_SANITY_SKIP = "1"
LINUX_VERSION ?= "6.1"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

SRC_URI:append = " ${@bb.utils.contains('IMAGE_FSTYPES', 'ext4', \
		   'file://${THISDIR}/files/ext4.cfg', \
		   '', \
		   d)}"

MODULE_TARBALL_DEPLOY = "0"
