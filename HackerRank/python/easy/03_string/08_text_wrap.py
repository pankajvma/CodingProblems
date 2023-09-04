# https://www.hackerrank.com/challenges/text-wrap/problem

import textwrap

def wrap(string, max_width):
    wrapped_str = ''
    seed = 0
    while seed < len(string):
        wrapped_str += string[seed:seed+max_width]+'\n'
        seed += max_width
    return wrapped_str

if __name__ == '__main__':
    string, max_width = input(), int(input())
    result = wrap(string, max_width)
    print(result)