SUMMARY = "P-Net Profinet communication stack - Samples"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;beginline=1;endline=14;md5=aa7e6f963fad674b02c35dc8e9aa5519"
SECTION = "console/network"

DEPENDS = "p-net-eval"

SRC_URI = "https://github.com/rtlabs-com/p-net/releases/download/public%2Fv${PV}/p-net-${PV}-samples.zip"
SRC_URI[sha256sum] = "8ce40738fa67bf04deb4f27938e6a70599526765ea6d8cf1a26b73395073d658"

S = "${WORKDIR}/p-net-${PV}-samples"

inherit pkgconfig cmake
