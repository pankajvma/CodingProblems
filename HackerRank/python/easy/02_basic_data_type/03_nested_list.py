# https://www.hackerrank.com/challenges/nested-list/problem

data = []
if __name__ == '__main__':
    for _ in range(int(input())):
        name = input()
        score = float(input())
        data.append([name, score])
        
        
def sort_mod(e):
    return e[1]    

data.sort(key=sort_mod)

smallest = data[0][1]

second_small = 0

for i in data:
    if i[1] != smallest:
        second_small = i[1]
        break
        
name_list = [i[0] for i in data if i[1] == second_small]

name_list.sort()

for name in name_list:
    print(name)
