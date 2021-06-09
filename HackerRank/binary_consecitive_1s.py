#!/bin/python3

import math
import os
import random
import re
import sys

if __name__ == '__main__':
    n = int(input().strip())

    s = ''

while n >= 1:
    s += str(n%2)
    n //= 2

con_one = 0
counter = 0
for i in s:

    if i == '1':
        counter += 1
        
        if counter > con_one:
            con_one = counter

    else:
        counter = 0
            
print(con_one)
