#!/bin/sh
# This line continues for Tcl, but is a single line for 'sh' \
    exec tclsh "$0" ${1+"$@"}

#
# Gets the remainder after dividing <number> by every number in
# <list> that it is evenly divisible by
#
proc get_remainder {list number} {
    foreach elem $list {
        if { $number % $elem == 0 } {
            set number [expr {$number / $elem}]
        }
    }
    return $number
}

set divisors {}
for {set i 2} {$i <= 20} {incr i} {
    lappend divisors [get_remainder $divisors $i]
}

puts [expr [join $divisors *]]

