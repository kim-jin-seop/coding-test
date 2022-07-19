def solution(n):
    if n == 1 :
        return 1
    elif n == 2 :
        return 2

    front = 1
    back = 2
    for i in range(n-2):
        temp = front
        front = back
        back = (temp + back) % 1000000007
    return back

solution(60000)