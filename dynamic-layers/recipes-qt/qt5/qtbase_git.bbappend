# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

PATCHPATH = "${CURDIR}/${BPN}"
inherit auto-patch

PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"

DEPENDS += " rockchip-librga"
#QT_CONFIG_FLAGS += " QMAKE_CXXFLAGS+=-DQT_USE_RGA"
#QT_CONFIG_FLAGS += " QMAKE_LFLAGS+=-lrga"
#OE_QMAKE_LDFLAGS += "-lrga"
QT_CONFIG_FLAGS += " QMAKE_CXXFLAGS+=-DQT_FB_DRM_RGB32"

PACKAGECONFIG:append = " gbm kms eglfs linuxfb"
