UBOOT_EXTLINUX = "1"

# Define extlinux labels
UBOOT_EXTLINUX_LABELS = " \
    bt3576-evm \
"
UBOOT_EXTLINUX_DEFAULT_LABEL = "bt3576-evm"

# Define extlinux timeout
UBOOT_EXTLINUX_TIMEOUT = "20"

UBOOT_EXTLINUX_MENU_DESCRIPTION:bt3576-evm = "bt3576-evm"
UBOOT_EXTLINUX_KERNEL_IMAGE:bt3576-evm = "/boot.img"
# UBOOT_EXTLINUX_FDT:bt3576-evm = "/bt3576-evm-b.dtb"
# UBOOT_EXTLINUX_INITRD:bt3576-evm = "/initrd.img"

# Define additional kernel arguments
UBOOT_EXTLINUX_ROOT:bt3576-evm = "LABEL=${LABEL} root=${bootroot}"
UBOOT_EXTLINUX_KERNEL_ARGS:bt3576-evm = "quiet rootwait rw"
