# Copyright (C) 2020, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Rockchip ALSA config files"
SECTION = "multimedia"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://NOTICE;md5=9645f39e9db895a4aa6e02cb57294595"

inherit local-git

SRC_URI = " \
	git://gitlab.com/firefly-linux/external/alsa-config.git;protocol=https;nobranch=1;branch=${FIREFLY_SDK_BRANCH}; \
"
SRCREV = "${FIREFLY_SDK_VERSION}"
S = "${WORKDIR}/git"

inherit meson

FILES:${PN} = "*"
