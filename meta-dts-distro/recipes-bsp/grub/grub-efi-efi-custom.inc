FILESEXTRAPATHS:prepend := "${THISDIR}/grub-efi-custom:"

RDEPENDS:${PN}:remove = " virtual-grub-bootconf"

do_install:append () {
	rm -rf ${D}${EFI_PREFIX}/EFI
}

FILES:${PN}:remove = "${EFI_FILES_PATH}/${GRUB_IMAGE}"

do_deploy:append () {
	install -d ${DEPLOY_DIR_IMAGE}/bootfiles
	cp -r ${D}/boot/* ${DEPLOY_DIR_IMAGE}/bootfiles/
}
