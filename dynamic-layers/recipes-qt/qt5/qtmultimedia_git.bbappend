# SPDX-License-Identifier: MIT
#
# Copyright (C) 2023 He Yong <hyyoxhk@163.com>
#

PATCHPATH = "${CURDIR}/${BPN}"

PACKAGECONFIG:append = " examples"

inherit auto-patch
