# https://www.hackerrank.com/challenges/python-lists/problem

bucket = []

if __name__ == '__main__':
    N = int(input())

for _ in range(N):
    command = list(map(str, input().split()))
    if command[0] == 'print':
        print(bucket)
    else:
        string = 'bucket.'
        string += command[0] + '(' + ','.join(command[1:]) +')'
        eval(string)
