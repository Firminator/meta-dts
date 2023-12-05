DESCRIPTION = "sbctl - a simple tool"
HOMEPAGE = "https://github.com/foxboron/sbctl.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=90982035f2d0342d5bf8ac9dfceefa7a"

SRC_URI = "git://github.com/foxboron/sbctl.git;protocol=https"
SRCREV = "748bc59d24a4d14087d8d92431606c5fb57afeb0"

S = "${WORKDIR}/git"

do_compile() {
    echo "Entering do_compile"
    echo "PWD is $PWD"
    echo "B is ${B}"
    echo "D is ${D}"

    #echo DEBUG PATH BEFORE: $PATH
    #export PATH=$PATH:/usr/bin
    #export PATH=$PATH:/usr/local
    #export PATH=$PATH:/usr/local/go/bin
    #echo DEBUG PATH AFTER: $PATH
    #oe_runmake
    #sudo make

    wget https://github.com/Foxboron/sbctl/releases/download/0.12/sbctl-0.12-linux-amd64.tar.gz
    tar -zxvf sbctl-0.12-linux-amd64.tar.gz
    install -d ${B}

    #cp -f sbctl/sbctl ${B}

    #rm -rf sbctl
    #rm sbctl-0.12-linux-amd64.tar.gz
}

do_install() {
    echo "entering install, D is ${D}"
    echo "bindir is ${bindir}"
    echo "B is ${B}"
    echo "PWD is $PWD"
    install -d ${D}${bindir}
    install -m 0755 ${B}/sbctl/sbctl ${D}${bindir}/
}

inherit pkgconfig

FILES:${PN} += "${libdir}/sbctl"
FILES:${PN}-dev += "${includedir}/sbctl"
