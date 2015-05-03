#!/bin/sh
# This line continues for Tcl, but is a single line for 'sh' \
        exec tclsh "$0" ${1+"$@"}

set sum 0
for {set i 0} {$i < 1000} {incr i} {
    if { $i % 3 == 0 || $i % 5 == 0 } {
        incr sum $i
    }
}
puts $sum
