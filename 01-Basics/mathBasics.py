import math;

#Count digits
## using brute force O(logn)
def countDigits(num):
    counter = 0
    while (num>9):
        counter+=1
        num = num/10

    return counter+1

##optimized solution O(1)
def counDigitsOp(num): 
    return (int)(math.log10(num)+1)

    