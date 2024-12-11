UBOOT_EXTLINUX = "1"

# Define extlinux labels
UBOOT_EXTLINUX_LABELS = "ym-sbc-rk3588"
# Define extlinux timeout
UBOOT_EXTLINUX_TIMEOUT = "20"
# Define additional kernel arguments
UBOOT_EXTLINUX_KERNEL_ARGS = "quiet rootwait rw earlycon=uart8250,mmio32,0xfeb50000"

UBOOT_EXTLINUX_ROOT = "LABEL=${LABEL} root=${bootroot}"
UBOOT_EXTLINUX_KERNEL_IMAGE:ym-sbc-rk3588 = "/Image"
UBOOT_EXTLINUX_FDT:ym-sbc-rk3588 = "/ym-sbc-rk3588.dtb"
UBOOT_EXTLINUX_INITRD = "/initrd.img"
