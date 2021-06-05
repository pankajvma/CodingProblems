t = int(input())

for _ in range(t):
    xa, xb,Xa, Xb = map(int, input().split())
    print(int(Xa/xa + Xb/xb))