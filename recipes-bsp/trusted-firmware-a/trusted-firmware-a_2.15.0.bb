require recipes-bsp/trusted-firmware-a/trusted-firmware-a.inc

# TF-A v2.15.0
SRC_URI = "git://git.trustedfirmware.org/TF-A/trusted-firmware-a.git;protocol=https;name=tfa;branch=master"
SRCREV = "da738d5eae93af342fdc4995dd3c05acb4c9d757"
SRCBRANCH = "master"

LIC_FILES_CHKSUM += "file://docs/license.rst;md5=6ed7bace7b0bc63021c6eba7b524039e"
