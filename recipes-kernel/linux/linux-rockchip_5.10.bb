# Copyright (C) 2021, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require linux-rockchip.inc

inherit local-git

SRCREV = "93f1dde055919b078f8954c3dd0d8d00e07e4811"

SRC_URI = " \
	git://gitlab.com/hyyoxhk/linux-rk.git;protocol=https;nobranch=1;branch=main; \
	file://${THISDIR}/files/cgroups.cfg \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_VERSION_SANITY_SKIP = "1"
LINUX_VERSION ?= "5.10"

SRC_URI:append = " ${@bb.utils.contains('IMAGE_FSTYPES', 'ext4', \
		   'file://${THISDIR}/files/ext4.cfg', \
		   '', \
		   d)}"
