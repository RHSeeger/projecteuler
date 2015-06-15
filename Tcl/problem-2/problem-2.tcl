#!/bin/sh
# This line continues for Tcl, but is a single line for 'sh' \
    exec tclsh "$0" ${1+"$@"}

set sum 0
set current 1
set last 1
while { $current < 4000000 } {
    if { $current % 2 == 0 } {
        incr sum $current
    }
    set new [expr {$current + $last}]
    set last $current
    set current $new
}
puts $sum
