BL31:rockchip:aarch64 = "${DEPLOY_DIR_IMAGE}/bl31.elf"
EXTRA_OEMAKE:append:rockchip:aarch64 = " BL31=/home/hey/workspace/rkbin/bin/rk35/rk3568_bl31_v1.44.elf"

TFA_DEPENDS ??= ""
TFA_DEPENDS:rockchip:aarch64 = " trusted-firmware-a:do_deploy"
do_compile[depends] .= "${TFA_DEPENDS}"

# No open-source TPL (yet)
ROCKCHIP_TPL = "${DEPLOY_DIR_IMAGE}/ddr-${SOC_FAMILY}.bin"
# SOC_FAMILY for RK3588S is rk3588s but it should use the binaries from rk3588
ROCKCHIP_TPL:rk3588s = "${DEPLOY_DIR_IMAGE}/ddr-rk3588.bin"
EXTRA_OEMAKE:append = " ROCKCHIP_TPL=${ROCKCHIP_TPL}"

INIT_FIRMWARE_DEPENDS ??= ""
INIT_FIRMWARE_DEPENDS = " rockchip-rkbin-ddr:do_deploy"
do_compile[depends] .= "${INIT_FIRMWARE_DEPENDS}"
