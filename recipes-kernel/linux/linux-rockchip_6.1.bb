# Copyright (C) 2024, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require linux-rockchip.inc

inherit local-git

SRCREV = "11b10b86b0f0d3df2c25c4f68e6d0212f9e1613f"
SRC_URI = " \
	git://${YUNMY_GITLAB_URL}/board/kernel.git;protocol=${YUNMY_GITLAB_PROTOCOL};nobranch=1;branch=bt3576-evm-v1.0; \
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
