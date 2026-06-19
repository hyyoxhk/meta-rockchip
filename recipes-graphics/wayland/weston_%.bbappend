# Copyright (C) 2024, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DEPENDS:append = " rockchip-librga"

SRCREV = "d8f3454fcfd8cfbbe6f486789ed6c9ad1dfb0813"
SRC_URI:append = " git://github.com/JeffyCN/weston;protocol=https;branch=11.0"

SRC_URI:remove = "https://gitlab.freedesktop.org/wayland/weston/-/releases/${PV}/downloads/${BPN}-${PV}.tar.xz2"
S = "${WORKDIR}/git"
