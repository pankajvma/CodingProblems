# https://www.hackerrank.com/challenges/list-comprehensions/problem

if __name__ == '__main__':
    x = int(input())
    y = int(input())
    z = int(input())
    n = int(input())
    

all_permute = [[i, j, k] for i in range(x+1) for j in range(y+1) for k  in range(z+1)]

print([i for i in all_permute if i[0]+i[1]+i[2] != n])

#or

# print([i for i in [[i, j, k] for i in range(x+1) for j in range(y+1) for k  in range(z+1)] if i[0]+i[1]+i[2] != n])
