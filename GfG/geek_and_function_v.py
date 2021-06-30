test = int(input())

for _ in range(test):
    n, k = list(map(int, input().split()))
    # print(oprtn(n, k))
    while k > 0:
        mod = n % 10
        if mod == n:
            n = 0
            break
        elif mod == 0:
            n = n
            break
        else: n = n ^ mod
        k -= 1
    print(n)