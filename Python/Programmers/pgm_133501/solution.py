def solution(distance, scope, times):
    for s in scope:
        s.sort()
    zip_list = list(zip(scope, times))
    zip_list.sort(key = lambda x:x[0][0])
    
    for guard in range(len(zip_list)):
        mod = zip_list[guard][1][0] + zip_list[guard][1][1]
        work = zip_list[guard][1][0]
        for time in range(zip_list[guard][0][0]-1, zip_list[guard][0][1]):
            remainder = time % mod
            if remainder - work < 0:
                return time + 1
    return distance
