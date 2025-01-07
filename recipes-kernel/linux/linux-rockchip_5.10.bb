# Copyright (C) 2021, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require linux-rockchip.inc

inherit local-git

SRCREV = "caf7a6d27363d2ffdda618946afc12a25392aa49"
SRC_URI = " \
	git://${YUNMI_GITLAB_URL}/board/kernel.git;protocol=${YUNMI_GITLAB_PROTOCOL};nobranch=1;branch=main; \
	file://${THISDIR}/files/cgroups.cfg \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_VERSION_SANITY_SKIP = "1"
LINUX_VERSION ?= "5.10"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

SRC_URI:append = " ${@bb.utils.contains('IMAGE_FSTYPES', 'ext4', \
		   'file://${THISDIR}/files/ext4.cfg', \
		   '', \
		   d)}"

#do_patch:append() {
#	sed -i 's/-I\($(BCMDHD_ROOT)\)/-I$(srctree)\/\1/g' \
#		${S}/drivers/net/wireless/rockchip_wlan/rkwifi/bcmdhd/Makefile
#}
