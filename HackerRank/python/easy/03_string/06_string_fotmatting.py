# https://www.hackerrank.com/challenges/python-string-formatting/problem

def print_formatted(number):
    max_num_len = len(bin(number).replace("0b", ""))
    max_pad = max_num_len+1
    for i in range(1, number+1):
        line = ''

        deci = str(i)
        octa = oct(i).replace("0o", "")
        hexa = hex(i).replace("0x", "").upper()
        bina = bin(i).replace("0b", "")

        line += ' '*(max_pad-len(deci)-1)+deci
        line += ' '*(max_pad-len(octa))+octa
        line += ' '*(max_pad-len(hexa))+hexa
        line += ' '*(max_pad-len(bina))+bina

        print(line)
        
        
    
if __name__ == '__main__':
    n = int(input())
    print_formatted(n)