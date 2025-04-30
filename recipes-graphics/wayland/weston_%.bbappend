# Copyright (C) 2024, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " rockchip-librga"

SRCREV = "c6fc11584a908b4faa9d7046744f44666da5d4a8"
SRC_URI:append = " git://github.com/JeffyCN/weston;protocol=https;nobranch=1;branch=11.0"
SRC_URI:append = " file://0001-HACK-gl-renderer-Fallback-to-GBM-when-surfaceless-pl.patch"
SRC_URI:remove = "https://gitlab.freedesktop.org/wayland/weston/-/releases/${PV}/downloads/${BPN}-${PV}.tar.xz2"
S = "${WORKDIR}/git"
