from sympy import *
x=Symbol('x')

expr=x+1
expr=expr+x
a=(x+1)**2
b=x**2+2*x+1
# print(limit('sin(x)/x',x,0))
print(simplify(a-b))
print(a.equals(b))
print(expr.subs(x,2))
print(x)