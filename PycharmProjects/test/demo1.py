
from sympy import *
n = Symbol('n')
s = ((n+3)/(n+2))**n
print (limit(s, n, oo))