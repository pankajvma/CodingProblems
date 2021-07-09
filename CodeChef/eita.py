for _ in range(int(input())):
    d, x, y, z = list(map(int, input().split()))

    work1 = x * 7
    work2 = y * d + z * (7 - d)

    print(work1) if work1 > work2 else print(work2)