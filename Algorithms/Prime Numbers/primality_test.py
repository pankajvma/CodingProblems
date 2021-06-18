def is_prime(number):
    if number == 1: return False 
    for i in range(2, round(number ** .5) + 1):
        if number % i == 0:
            return False
    return True



print('Prime') if is_prime(int(input())) else print('Not Prime')