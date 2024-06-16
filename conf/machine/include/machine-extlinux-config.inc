UBOOT_EXTLINUX = "1"

# Define extlinux labels
UBOOT_EXTLINUX_LABELS = "rk3566-tspi"
# Define extlinux timeout
UBOOT_EXTLINUX_TIMEOUT = "20"
# Define additional kernel arguments
UBOOT_EXTLINUX_KERNEL_ARGS = "quiet rootwait rw earlycon=uart8250,mmio32,0xfe660000"

UBOOT_EXTLINUX_ROOT = "LABEL=${LABEL} root=${bootroot}"
UBOOT_EXTLINUX_KERNEL_IMAGE:rk3566-tspi = "/Image"
UBOOT_EXTLINUX_FDT:rk3566-tspi = "/rk3566-tspi.dtb"
UBOOT_EXTLINUX_INITRD = "/initrd.img"
