require imx-gpu-viv-v6.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=72c0f70181bb6e83eee6aab8de12a9f3"

SRC_URI[md5sum] = "733b087fdbd6567d96b9e57a768802a5"
SRC_URI[sha256sum] = "ebd7303b61fb1277b5644539888e369e9f2f4ee697e64317b1f69488be1e45c0"

do_install_append() {
    if [ "${USE_WL}" = "yes" -o "${USE_X11}" = "yes" ]; then
        mv ${D}${libdir}/libGL-${backend}.so ${D}${libdir}/libGL.so.1.2.0
    fi
}

COMPATIBLE_MACHINE = "(mx8)"
