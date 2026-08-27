UBOOT_EXTLINUX = "1"

# Define extlinux labels
UBOOT_EXTLINUX_LABELS = " \
    rk3566-tspi \
"
UBOOT_EXTLINUX_DEFAULT_LABEL = "rk3566-tspi"

# Define extlinux timeout
UBOOT_EXTLINUX_TIMEOUT = "20"

UBOOT_EXTLINUX_MENU_DESCRIPTION:rk3566-tspi = "rk3566-tspi"
UBOOT_EXTLINUX_KERNEL_IMAGE:rk3566-tspi = "/${KERNEL_IMAGETYPE}"
UBOOT_EXTLINUX_FDT:rk3566-tspi = "/rk3566-tspi.dtb"
UBOOT_EXTLINUX_INITRD:rk3566-tspi = "/initrd.img"

# Define additional kernel arguments
UBOOT_EXTLINUX_ROOT:rk3566-tspi = "LABEL=${LABEL} root=${rootparm}"
UBOOT_EXTLINUX_KERNEL_ARGS:rk3566-tspi = "quiet rootwait earlycon=${earlycon}"
