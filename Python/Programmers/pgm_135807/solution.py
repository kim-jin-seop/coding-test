import math

def solution(arrayA, arrayB):
    gcd_A = array_gcd(arrayA)
    gcd_B = array_gcd(arrayB)
    find_A = find(gcd_A, arrayB)
    find_B = find(gcd_B, arrayA)
    return find_A if find_A > find_B else find_B
    
def array_gcd(array):
    result = array[0]
    for a in array:
        result = math.gcd(result, a)
    return result

def find(gcd_value, array):
    result = 0
    for mod in range(1,gcd_value):
        find = True
        if gcd_value % mod != 0:
            continue
        for a in array:
            if a % (gcd_value / mod) == 0:
                find = False
                break
        if find:
            result = gcd_value / mod
            break
    return result
