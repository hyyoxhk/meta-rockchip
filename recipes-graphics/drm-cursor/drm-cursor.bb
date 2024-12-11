# Copyright (C) 2021, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "A hook of drm cursor APIs to fake cursor plane"
SECTION = "libs"

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=d749e86a105281d7a44c2328acebc4b0"

inherit local-git

DEPENDS = "libdrm virtual/libgles2 virtual/libgbm"

SRC_URI = " \
	git://${YUNMI_GITLAB_URL}/board/external/drm-cursor.git;protocol=${YUNMI_GITLAB_PROTOCOL};branch=master \
"
SRCREV = "23cebd5dd33a3073f296533954d4c211481891ab"
S = "${WORKDIR}/git"

inherit meson pkgconfig
