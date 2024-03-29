#https://www.hackerrank.com/challenges/counting-valleys/problem

def countingValleys(steps, path):
    # Write your code here
    level = 0
    valleys = 0
    for i in path:
        if i == "D":
            level -= 1
        else:
            level += 1
            if level == 0:
                valleys += 1
    return valleys