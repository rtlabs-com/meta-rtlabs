SUMMARY = "P-Net Profinet communication stack"
HOMEPAGE = "https://github.com/rtlabs-com/p-net"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://include/pnet_api.h;beginline=1;endline=14;md5=9613aac56556c534a901f25038170285"
SECTION = "libs"
PROVIDES = "p-net"

COMPATIBLE_HOST = "(x86_64|aarch64).*-linux"

_SRC_CHECKSUM:x86-64 = "58f3e1e0a645bf3ca83232f2ec1d605d3fea7fbe114fe530ab2dc98ae3c950c5"
_SRC_CHECKSUM:aarch64 = "e1f928b5ec66e80c5b2a589fc42d8a1a371c70d5ebc0d53f63a5cec2a6860ad8"
_SRC_SUFFIX:x86-64 = "-Linux-x86_64"
_SRC_SUFFIX:aarch64 = "-Linux-aarch64"

SRC_URI = "https://github.com/rtlabs-com/p-net/releases/download/public%2Fv${PV}/p-net-${PV}${_SRC_SUFFIX}.zip"
SRC_URI[sha256sum] = "${_SRC_CHECKSUM}"
S = "${WORKDIR}/p-net-${PV}${_SRC_SUFFIX}"

INSANE_SKIP:${PN} = "ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

FILES:${PN}-dev += " \
    ${prefix}/cmake/*.cmake \
"

FILES:${PN} += " \
    ${prefix}/share/profinet \
"

SYSROOT_DIRS += "${prefix}/cmake"

do_install () {
        install -d ${D}${libdir}
        install -m 0755 ${S}/lib/* ${D}${libdir}

        install -d ${D}${includedir}
        install -m 0755 ${S}/include/*.h ${D}${includedir}

        install -d ${D}${includedir}/sys
        install -m 0755 ${S}/include/sys/*.h ${D}${includedir}/sys

        install -d ${D}${bindir}
        install -m 0755 ${S}/bin/* ${D}${bindir}

        install -d ${D}${prefix}/cmake
        install -m 0755 ${S}/cmake/*.cmake ${D}${prefix}/cmake

        install -d ${D}${prefix}/share/profinet
        install -m 0755 ${S}/share/profinet/* ${D}${prefix}/share/profinet
}
