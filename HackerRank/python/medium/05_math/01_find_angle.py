# https://www.hackerrank.com/challenges/find-angle/problem

import math

ab = int(input())
bc = int(input())

tan = ab/bc

print(f'{round(math.degrees(math.atan(tan)))}'+u'\xb0')