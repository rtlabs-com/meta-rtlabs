meta-rtlabs Yocto layer
=======================
This Yocto layer contains a recipe to build p-net.

The p-net stack is an open-source Profinet IO-device stack developed by
rt-labs. It is dual licensed GPLv3 and commercial. If you need a commercial
license, please contact sales@rt-labs.com

* p-net: [https://github.com/rtlabs-com/p-net](https://github.com/rtlabs-com/p-net)
* rt-labs: [https://rt-labs.com](https://rt-labs.com)


Versions
========
This layer is tested with Yocto version 2.4 ("rocko"), but should work with
other Yocto versions.

For the p-net version, you might need to adjust the SRCREV value in the
p-net.bb recipe. Look for the most recent stable release/tag
at https://github.com/rtlabs-com/p-net

Note that p-net requires cmake version 3.13 or later.

If used with Yocto Project 2.7 ("warrior") or later the native cmake is
recent enough. Nowever this layer contains a recipe for updated cmake-native
so it also can be used with older Yocto releases. In the future when we only
support Yocto 2.7 or later, that recipe will be removed.


Dependencies
============
This layer depends on:

  URI: git://git.openembedded.org/bitbake
  branch: master

  URI: git://git.openembedded.org/openembedded-core
  layers: meta
  branch: master


Adding the rtlabs layer to your build
=====================================
In order to use this layer, you need to make the build system aware of
it.

Assuming the rtlabs layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the rtlabs layer to bblayers.conf, along with any
other layers needed. e.g.:

  BBLAYERS ?= " \
    /path/to/yocto/meta \
    /path/to/yocto/meta-poky \
    /path/to/yocto/meta-yocto-bsp \
    /path/to/yocto/meta-rtlabs \
    "

In order to use the recipes, add this to your image:

* *p-net* Adds libprofinet
* *p-net-demo* Adds libprofinet and the sample app
