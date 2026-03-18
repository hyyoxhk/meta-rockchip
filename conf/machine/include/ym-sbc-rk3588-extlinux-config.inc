UBOOT_EXTLINUX = "1"

# Define extlinux labels
UBOOT_EXTLINUX_LABELS = " \
    ym-sbc-rk3588 \
"
UBOOT_EXTLINUX_DEFAULT_LABEL = "ym-sbc-rk3588"

# Define extlinux timeout
UBOOT_EXTLINUX_TIMEOUT = "20"

UBOOT_EXTLINUX_MENU_DESCRIPTION:ym-sbc-rk3588 = "ym-sbc-rk3588"
UBOOT_EXTLINUX_KERNEL_IMAGE:ym-sbc-rk3588 = "/boot.img"

# Define additional kernel arguments
UBOOT_EXTLINUX_ROOT:ym-sbc-rk3588 = "LABEL=${LABEL} root=${bootroot}"
UBOOT_EXTLINUX_KERNEL_ARGS:ym-sbc-rk3588 = "quiet rootwait rw"
