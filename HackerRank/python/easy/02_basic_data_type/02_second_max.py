# https://www.hackerrank.com/challenges/find-second-maximum-number-in-a-list/problem

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    
arr.sort()

first = arr[-1]

for i in arr[-2::-1]:
    if i!= first:
        print(i)
        break