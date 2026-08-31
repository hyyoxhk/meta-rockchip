require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

require u-boot-rockchip.inc

UBOOT_ENV  = "boot"
UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV_SRC_SUFFIX = "cmd"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

SRC_URI += " \
    file://0001-pylibfdt-Replace-removed-SWIG-Python-2-compatibility.patch \
    file://0001-Add-support-for-OpenSSL-Provider-API.patch \
	file://fw_env.config \
	file://boot.cmd \
"

DEPENDS += "bc-native dtc-native gnutls-native python3-pyelftools-native"
