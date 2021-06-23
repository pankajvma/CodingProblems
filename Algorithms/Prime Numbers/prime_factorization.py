def prime_factors(number):
    for i in range(2, round(number ** .5) + 1):
        count = 0
        if number % i == 0:
            while number % i == 0:
                count += 1
                number /= i
            print(f'{i} ^ {count}')
    if number > 1:
        print(f'{int(number)} ^ 1')

prime_factors(int(input()))