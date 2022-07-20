def solution(sizes):
    big_max = 0
    small_max = 0
    for size in sizes:
        big = size[0]
        small = size[1]
        if big < small:
            big, small = small, big
        big_max = big if big_max < big else big_max
        small_max = small if small_max < small else small_max
    return big_max * small_max