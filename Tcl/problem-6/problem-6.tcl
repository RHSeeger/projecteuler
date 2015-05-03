#!/bin/sh
# This line continues for Tcl, but is a single line for 'sh' \
    exec tclsh "$0" ${1+"$@"}


#
# Square of the sum of [1,n] =
#    (n * (n + 1) / 2) ^ 2 =
#    n * (n + 1) * n * (n + 1) / 4
# 
# Sum of the squares of [1,n] =
#    n * (n + 1) * (2n + 1) / 6
#
# Square of sum - sum of squares =
#    n * (n + 1) * n * (n + 1)      n * (n + 1) * (2n + 1)
#    -------------------------  -   ----------------------   =
#                4                             6
#
#    3 * n * (n + 1) * n * (n + 1)  -  2 * n * (n + 1) * (2n + 1)
#    ------------------------------------------------------------   =
#                              12                        
#
#    n * (n + 1) * ( 3 * n * (n + 1)  -  2 * (2n + 1) )
#    --------------------------------------------------   =
#                         12                        
#    
set n 100
puts [expr { $n * ($n + 1) * ( 3 * $n * ($n + 1) - 2 * (2 * $n + 1) ) / 12 }]
