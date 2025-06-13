#   n=3
#    *
#   ***
#  *****
#  *****
#   ***
#    *
def pattern1(n):
    for i in range(n):
        spaces=n-i
        stars=2*i+1
        print((spaces*' ')+(stars*'*'))
    for i in range(n):
        spaces=i+1
        stars=2*n-2*i-1
        print((spaces*' ')+(stars*'*'))

# for N=5
# 1
# 01
# 101
# 0101
# 10101
def pattern2(n):
    b=1
    for i in range(n):
        binary=1 if b==1 else 0
        for j in range(i+1):
            print(binary, end="")
            binary=0 if binary == 1 else 1
        print()
        b=0 if b == 1 else 1

# n=6
# 1          1
# 12        21
# 12       321
# 1234    4321
# 12345  54321
# 123456654321
def pattern3(n):
    for i in range(1, n+1):
        #print first set of numbers
        spaces=2*(n-i)
        for j in range(1, i+1):
            print(j, end='')
        # print spaces
        print(spaces*' ',end='')
        # print second set of numbers
        for j in range(i):
            print(i-j, end='')
        print()

# n=5
# 1
# 2  3
# 4  5  6
# 7  8  9  10
# 11  12  13  14  15
def pattern4(n):
    counter = 1
    for i in range(1,n+1):
        for j in range(1,1+i):
            print(counter, end=' ')
            counter+=1
        print()

# n=5
#      A     
#     ABA    
#    ABCBA   
#   ABCDCBA  
#  ABCDEDCBA 

def pattern5(n):
    for i in range(1,n+1):
        letter=64 #ASCII for A is 65
        space=n-i
        #print spaces
        print(' '*space, end='')
        #print letters -> first set
        for j in range(i):
            print(chr(letter+j+1), end='')
            
        #print letter -> second set
        for j in range(1,i):
            print(chr(letter+i-j), end='')
        print()

# n=3
# ******
# **  **
# *    *
# *    *
# **  **
# ******
def pattern6(n):
    for i in range(n):
        stars=n-i
        spaces=2*i
        print(stars*'*'+spaces*' '+stars*'*')
    for i in range(n):
        stars=i+1
        spaces=2*(n-i-1)
        print(stars*'*'+spaces*' '+stars*'*')

# n=3
# *    *
# **  **
# ******
# **  **
# *    *
def pattern7(n):
    for i in range(n):
        stars=i+1
        spaces= 2*(n-i-1)
        print(stars*'*'+spaces*' '+stars*'*')
    for i in range(1,n):
        stars=n-i
        spaces=2*i
        print(stars*'*'+spaces*' '+stars*'*')

# n=6
# ******
# *    *
# *    *
# *    *
# *    *
# ******
def pattern8(n):
    for i in range(1,n+1):
        if(i==n or i==1):
            print('*'*n)
        else:
            print('*'+' '*(n-2)+'*')

# n=4
# 4 4 4 4 4 4 4
# 4 3 3 3 3 3 4
# 4 3 2 2 2 3 4
# 4 3 2 1 2 3 4
# 4 3 2 2 2 3 4
# 4 3 3 3 3 3 4
# 4 4 4 4 4 4 4
def pattern9(n):
    for i in range(1, 2*n):
        for j in range(1, 2*n):
            num = max(n-min(i,j)+1, max(i,j)-n+1)
            print(num, end=' ')
        print()

pattern9(7)