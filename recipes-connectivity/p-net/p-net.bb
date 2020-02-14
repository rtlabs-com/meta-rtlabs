SUMMARY = "p-net Profinet communication stack"
HOMEPAGE = "https://github.com/rtlabs-com/p-net"
LICENSE = "GPLv3 | commercial"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=4b23c301952201d50182a03961874938"
SECTION = "console/network"

SRC_URI = "git://github.com/rtlabs-com/p-net.git"
SRCREV = "eb5547020a34674a15e7df1f5bc1b85e8345f8e8"

DEPENDS = "cmake-zeus-native"
DEPENDS_remove = "cmake-native"

S = "${WORKDIR}/git"

inherit cmake

# TODO How to handle -DCMAKE_MAKE_PROGRAM better?
EXTRA_OECMAKE = "-DCMAKE_MAKE_PROGRAM=/usr/bin/make -DBUILD_TESTING=OFF -DBUILD_SHARED_LIBS=ON -DUSE_SCHED_FIFO=ON"
OECMAKE_RPATH = ""

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

PACKAGE_BEFORE_PN = "${PN}-demo"
RDEPENDS_${PN}-demo = "${PN}"
FILES_${PN} = "/usr/lib/libpro*"
FILES_${PN}-demo = "${bindir}/pn_dev"

do_install_append() {
    rm -rf ${D}/usr/cmake/
}
