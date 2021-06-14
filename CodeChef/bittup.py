t = int(input())

for _ in range(t):
    N, M = map(int, input().split())
    total_allowed_ways = pow(2, N, 10**9 + 7) - 1

    ans = pow(total_allowed_ways, M, 10**9 + 7)
    print(ans)