#!/usr/bin/env bash
####################################################################
#
# This script launches Areca's external decompression tool
#
####################################################################

PROGRAM_DIR=`dirname "$0"`
"${PROGRAM_DIR}"/areca_run.sh com.application.areca.external.CmdLineDeZip "$1" "$2" "$3" "$4" "$5" "$6" "$7" "$8" "$9" "${10}" "${11}" "${12}"