# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DEPENDS:append = " automake-native autoconf-native util-macros-native font-util-native xtrans-native libxshmfence rockchip-librga"

inherit local-git

SRCREV = "${FIREFLY_SDK_VERSION}"
SRC_URI:append = " git://gitlab.com/firefly-linux/external/xserver.git;protocol=https;nobranch=1;branch=${FIREFLY_SDK_BRANCH};"
SRC_URI:remove = "https://www.x.org/releases//individual/xserver/xorg-server-${PV}.tar.bz2"
S = "${WORKDIR}/git"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://20-modesetting.conf"

xserver_autogen() {
    NOCONFIGURE="yes" ${S}/autogen.sh
}
EXTRACONFFUNCS += "xserver_autogen"

do_install:append() {
    install -d ${D}${datadir}/X11/xorg.conf.d
    install -m 0755 ${WORKDIR}/20-modesetting.conf \
        ${D}${datadir}/X11/xorg.conf.d/20-modesetting.conf
}
