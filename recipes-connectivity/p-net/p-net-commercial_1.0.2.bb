SUMMARY = "P-Net Profinet communication stack"
LICENSE = "LicenseRef-Proprietary"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;beginline=1;endline=14;md5=aa7e6f963fad674b02c35dc8e9aa5519"
SECTION = "libs"
PROVIDES = "p-net"

SRC_URI = "file://p-net-sources-1.0.2.zip"
S = "${WORKDIR}/p-net"

FILES:${PN}-dev += " \
    ${prefix}/cmake/*.cmake \
"

FILES:${PN} += " \
    ${prefix}/share/profinet \
"

# We need network access to get Osal
EXTRA_OECMAKE += "-DFETCHCONTENT_FULLY_DISCONNECTED=OFF"
do_configure[network] =  "1"

# Disable the tests since build fail
# when cross compiling due to test discovery
# using GOOGLE_TEST_INDIVIDUAL
EXTRA_OECMAKE += "-DBUILD_TESTING=OFF"

inherit pkgconfig cmake
