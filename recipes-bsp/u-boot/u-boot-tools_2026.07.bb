require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot-tools.inc

LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

SRC_URI += "file://0001-tools-mkeficapsule-Detect-GnuTLS-PKCS-11-support.patch"

DEPENDS += "swig-native gnutls-native"
