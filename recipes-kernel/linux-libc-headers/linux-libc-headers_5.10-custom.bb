# Copyright (C) 2021, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

inherit auto-patch

inherit local-git

SRCREV = "c9885c773dd0219ca08545ad11d564e807ce3623"
SRC_URI = " \
	git://${YUNMY_GITLAB_URL}/board/kernel.git;protocol=${YUNMY_GITLAB_PROTOCOL};nobranch=1;branch=master; \
"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
