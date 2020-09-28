require gstreamer1.0_1.16.2.bb

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# Use i.MX fork of GST for customizations
GST1.0_SRC ?= "gitsm://source.codeaurora.org/external/imx/gstreamer.git;protocol=https"
SRCBRANCH = "imx-1.16.x"
SRCREV = "8514bc61ccab208a65e387eab9347276a8e770e7" 

SRC_URI = " \
    ${GST1.0_SRC};branch=${SRCBRANCH} \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://gtk-doc-tweaks.patch \
    file://0001-gst-gstpluginloader.c-when-env-var-is-set-do-not-fal.patch \
    file://add-a-target-to-compile-tests.patch \
    file://run-ptest \
    file://0001-gst-glib-gen.mak-Adapt-to-backwards-incompatible-cha.patch;patchdir=common \
"

S = "${WORKDIR}/git"

# This remove "--exclude=autopoint" option from autoreconf argument to avoid
# configure.ac:30: error: required file './ABOUT-NLS' not found
EXTRA_AUTORECONF = ""

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"