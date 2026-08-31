# Copyright (c) 2020, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require conf/machine/include/rockchip-arm64-common.inc

SOC_FAMILY := "rk3568"

PREFERRED_VERSION_linux-rockchip := "5.10%"
LINUXLIBCVERSION := "5.10-custom%"
OLDEST_KERNEL := "5.10"

MALI_GPU := "bifrost-g52"
MALI_VERSION := "g2p0"

RK_ISP_VERSION := "2.1"

TFA_PLATFORM = "rk3568"
TFA_BUILD_TARGET = "bl31"
RK_CONSOLE_BAUD ?= "1500000"

UBOOT_SUFFIX ?= "itb"
UBOOT_ENTRYPOINT ?= "0x06000000"

FIREFLY_SDK_BRANCH = "rk3588/firefly"
FIREFLY_SDK_VERSION = "rk3588/linux_release_v1.1.1e"
