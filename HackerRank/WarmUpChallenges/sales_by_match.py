#https://www.hackerrank.com/challenges/sock-merchant/problem

def sockMerchant(n, ar):
    ar_sum = 0
    for i in range(101):
        ar_sum += ar.count(i)//2
        if ar_sum == n//2:
            return ar_sum
    return ar_sum
    # Write your code 