t = int(input())

for _ in range(t):
    D, d, P, Q = map(int, input().split())
    sm = (D - d) // d
    rem = (D - d) % d
    extra = Q* rem * (sm + 1)

    seq_sum = sm * (1 + sm)//2

    cost = D * P + Q * d * seq_sum + extra

    print(cost)