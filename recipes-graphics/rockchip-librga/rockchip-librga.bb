# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Rockchip RGA 2D graphics acceleration library"
SECTION = "libs"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "libdrm"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit local-git

SRC_URI = " \
	git://gitlab.com/firefly-linux/external/linux-rga.git;protocol=https;nobranch=1;branch=${FIREFLY_SDK_BRANCH}; \
"
SRCREV = "${FIREFLY_SDK_VERSION}"
S = "${WORKDIR}/git"

inherit meson pkgconfig

EXTRA_OEMESON = "-Dlibdrm=true"
