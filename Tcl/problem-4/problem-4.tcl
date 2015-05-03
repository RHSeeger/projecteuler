#!/bin/sh
# This line continues for Tcl, but is a single line for 'sh' \
    exec tclsh "$0" ${1+"$@"}


set max_palindrome 0
for {set i 100} {$i <= 999} {incr i} {
    for {set j $i} {$j < 999} {incr j} {
        set product [expr { $i * $j }]
        if { $product < $max_palindrome } { continue }
        if { $product ne [string reverse $product] } { continue }
        set max_palindrome $product
    }
}
puts $max_palindrome
