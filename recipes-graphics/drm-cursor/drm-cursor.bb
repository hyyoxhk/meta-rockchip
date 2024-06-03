# Copyright (C) 2021, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "A hook of drm cursor APIs to fake cursor plane"
SECTION = "libs"

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=d749e86a105281d7a44c2328acebc4b0"

inherit local-git

DEPENDS = "libdrm virtual/libgles2 virtual/libgbm"

SRC_URI = " \
	git://gitlab.com/firefly-linux/external/drm-cursor.git;protocol=https;nobranch=1;branch=${FIREFLY_SDK_BRANCH}; \
"
SRCREV = "${FIREFLY_SDK_VERSION}"
S = "${WORKDIR}/git"

inherit meson pkgconfig
