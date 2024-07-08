FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://brcmpp.service"

inherit systemd

do_install:append () {
    install -d ${D}${systemd_system_unitdir}
    install -m 644 ${WORKDIR}/brcmpp.service ${D}${systemd_system_unitdir}/brcmpp.service
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "brcmpp.service"
SYSTEMD_AUTO_ENABLE = "enable"
