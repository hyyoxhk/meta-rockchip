# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)

include recipes-multimedia/gstreamer/gst-plugins-package.inc
include recipes-multimedia/gstreamer/gstreamer1.0-plugins-packaging.inc

DESCRIPTION = "GStreamer 1.0 plugins for Rockchip platforms"

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"
DEPENDS:append = " gstreamer1.0-plugins-base"

inherit local-git

SRCREV = "${YUNMY_SDK_VERSION}"
SRC_URI = "git://${YUNMY_GITLAB_URL}/board/external/gstreamer-rockchip.git;protocol=${YUNMY_GITLAB_PROTOCOL};branch=${YUNMY_SDK_BRANCH}"

S = "${WORKDIR}/git"

PATCHPATH = "${THISDIR}/files"
inherit auto-patch

inherit meson pkgconfig

PACKAGECONFIG ??= "mpp ${@bb.utils.filter('DISTRO_FEATURES', 'x11', d)} rga"

PACKAGECONFIG[mpp] = "-Drockchipmpp=enabled,-Drockchipmpp=disabled,rockchip-mpp"
PACKAGECONFIG[x11] = "-Drkximage=enabled,-Drkximage=disabled,libx11 libdrm"
PACKAGECONFIG[rga] = "-Drga=enabled,-Drga=disabled,rockchip-librga"
