#!/bin/sh
# This line continues for Tcl, but is a single line for 'sh' \
    exec tclsh "$0" ${1+"$@"}


#
# We find the smallest divisor of the current number
# If we can't find any divisor, then the current number is the the
#    largest divisor and prime
# If we can find one, we call ourselves with (current number / smallest divisor)
#    since that is the largest divisor of the current number. It's 
#    largest prime divisor will also be the original number's largest
#    prime divisor
#
proc get_max_divisor {number} {
    set max_divisor [expr {sqrt($number)}]
    for {set i 2} {$i <= $max_divisor} {incr i} {
        if { $number % $i == 0 } {
            return [get_max_divisor [expr { $number / $i }]]
        }
    }
    return $number
}

puts [get_max_divisor 600851475143]
