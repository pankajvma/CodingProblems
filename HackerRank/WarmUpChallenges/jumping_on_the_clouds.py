#https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

import math
import os
import random
import re
import sys

#
# Complete the 'jumpingOnClouds' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY c as parameter.
#

def jumpingOnClouds(c):
    # Write your code here
    max_index = len(c)-1
    pointer = 0
    steps = 0
    while pointer < max_index:
        if pointer +2 <= max_index:
            if c[pointer+2] == 0:
                pointer += 2
            else: pointer += 1
        else: pointer += 1
        steps += 1
    return steps


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(c)

    print(result)

    # fptr.write(str(result) + '\n')

    # fptr.close()
