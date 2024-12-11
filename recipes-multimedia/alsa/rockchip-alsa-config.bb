# Copyright (C) 2020, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Rockchip ALSA config files"
SECTION = "multimedia"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://NOTICE;md5=9645f39e9db895a4aa6e02cb57294595"

inherit local-git

SRC_URI = " \
	git://${YUNMI_GITLAB_URL}/board/external/alsa-config.git;protocol=${YUNMI_GITLAB_PROTOCOL};branch=master; \
"
SRCREV = "68364f275f0fa2762e2aea24cb4bf40c167775d6"
S = "${WORKDIR}/git"

inherit meson

FILES:${PN} = "*"
