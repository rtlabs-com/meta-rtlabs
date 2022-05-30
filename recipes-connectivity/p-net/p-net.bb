SUMMARY = "p-net Profinet communication stack"
HOMEPAGE = "https://github.com/rtlabs-com/p-net"
LICENSE = "GPLv3 | commercial"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=207cc6189ccb6e2be4f164397fc210ae"
SECTION = "console/network"

SRC_URI = "git://github.com/rtlabs-com/p-net.git"
SRCREV = "089df76f38df13e4b8b58e12e5d1be6d3b9aa792"

# Enable these lines if using Yocto older than version 2.7
#DEPENDS = "cmake-zeus-native"
#DEPENDS_remove = "cmake-native"

S = "${WORKDIR}/git"

inherit cmake

# TODO How to handle -DCMAKE_MAKE_PROGRAM better?
EXTRA_OECMAKE = "-DCMAKE_MAKE_PROGRAM=/usr/bin/make -DBUILD_TESTING=OFF -DBUILD_SHARED_LIBS=ON -DUSE_SCHED_FIFO=ON"
OECMAKE_RPATH = ""
OECMAKE_GENERATOR = "Unix Makefiles"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
FILES_${PN} = "/usr/lib/libpro*"

PACKAGE_BEFORE_PN = "${PN}-demo"
RDEPENDS_${PN}-demo = "${PN}"
FILES_${PN}-demo = "${bindir}/pn_dev"
FILES_${PN}-demo += "${bindir}/set_network_parameters"
FILES_${PN}-demo += "${bindir}/set_profinet_leds"
FILES_${PN}-demo += "${bindir}/set_profinet_leds.raspberrypi"

do_configure_prepend() {
    cd ${WORKDIR}/git
    git submodule update --init --recursive
}

do_install_append() {
    install -d ${D}${bindir}
    cp "${WORKDIR}/build/set_network_parameters" ${D}${bindir}
    cp "${WORKDIR}/build/set_profinet_leds" ${D}${bindir}
    cp "${WORKDIR}/build/set_profinet_leds.raspberrypi" ${D}${bindir}

    rm -rf ${D}/usr/cmake/
}
