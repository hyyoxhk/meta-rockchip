echo "Boot over ${devtype}${devnum}!"

test -n "${BOOT_ORDER}" || env set BOOT_ORDER "A B"
test -n "${BOOT_A_LEFT}" || env set BOOT_A_LEFT 0x3
test -n "${BOOT_B_LEFT}" || env set BOOT_B_LEFT 0x3

if test x${kernelpartA} = x; then env set kernelpartA 3; fi
if test x${kernelpartB} = x; then env set kernelpartB 5; fi
if test x${fit_blkcnt}  = x; then env set fit_blkcnt 0x10000; fi

env set rootparm
env set slot

echo "BOOT_ORDER: ${BOOT_ORDER}"
for BOOTSLOT in "${BOOT_ORDER}"; do
	if test "x${rootparm}" != "x"; then
		# stop checking after selecting a slot
		true
	elif test "x${BOOTSLOT}" = "xA"; then
		if test ${BOOT_A_LEFT} -gt 0; then
			echo "Using slot A"
			setexpr BOOT_A_LEFT ${BOOT_A_LEFT} - 1
			env set rootparm "PARTLABEL=rootfsA"
			env set SLOT "A"
			env set bootdev "${devtype} ${devnum} ${kernelpartA}"
			echo "bootdev: ${bootdev}"
		fi
	elif test "x${BOOTSLOT}" = "xB"; then
		if test ${BOOT_B_LEFT} -gt 0; then
			echo "Using slot B"
			setexpr BOOT_B_LEFT ${BOOT_B_LEFT} - 1
			env set rootparm "PARTLABEL=rootfsB"
			env set SLOT "B"
			env set bootdev "${devtype} ${devnum} ${kernelpartB}"
			echo "bootdev: ${bootdev}"
		fi
	fi
done

if test -n "${rootparm}"; then
	env set bootargs "${bootargsbase} root=${rootparm} quiet rootwait slot=${SLOT}"
	env save
else
	echo "No valid slot found. Resetting tries to 3"
	env set BOOT_A_LEFT 3
	env set BOOT_B_LEFT 3
	env save
	reset
fi

part start ${bootdev} fit_lba
mmc read ${kernel_addr_c} ${fit_lba} ${fit_blkcnt}
bootm ${kernel_addr_c}
