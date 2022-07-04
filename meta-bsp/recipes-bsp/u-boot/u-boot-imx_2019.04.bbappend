FILES_${PN} += "/etc/*" 

SRC_URI += " file://0001-enable-env_redunand-bootcount-limit1.patch \
	     file://0002-default-env.patch  \
	     file://0003-init-env-uboot.patch "

SWU_HW_REV ?= " 1.0" 

do_install_append_mx8mm () {

    echo "/dev/mmcblk1 0x400000 0x2000" > ${D}${sysconfdir}/fw_env.config
    echo "/dev/mmcblk1 0x402000 0x2000" >> ${D}${sysconfdir}/fw_env.config
    echo "${MACHINE} ${SWU_HW_REV}" > ${D}${sysconfdir}/hwrevision

}

do_deploy_append () {

     install -D -m 644  ${D}${sysconfdir}/fw_env.config  ${DEPLOYDIR}
     install -D -m 644  ${D}${sysconfdir}/hwrevision  ${DEPLOYDIR}

}
