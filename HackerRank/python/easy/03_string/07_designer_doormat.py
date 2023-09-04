# https://www.hackerrank.com/challenges/designer-door-mat/problem

def get_pattern(line, length):
    filler = '.|.'*(line*2+1)
    hyp_cnt = (length - (line*2 + 1)*3)//2
    hyp = '-'*hyp_cnt
    print(hyp+filler+hyp)

def print_mat(width):
    center =(width//2)
    length = width * 3
    
    for i in range(0, center):
        get_pattern(i, length)
    
    cntr_hyp_cnt = (length - 7)//2
    cntr_hyp = '-'*cntr_hyp_cnt
    print(cntr_hyp+'WELCOME'+cntr_hyp)
    
    for i in range(center-1, -1, -1):
        get_pattern(i, length)

n, m = tuple(input().split(' '))
print_mat(int(n))
