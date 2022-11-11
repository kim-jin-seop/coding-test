def solution(n, wires):
    min_value = 100
    for wire in wires:
        tree = make_tree(n,wires, wire[0],wire[1])
        min_value = abs(tree-(n-tree)) if abs(tree-(n-tree)) < min_value else min_value
    return min_value

def make_tree(n,wires, start,cut):
    check_set = {start}
    is_change = True
    checked = [False] * (n + 1)
    checked[cut] = True
    
    while is_change:
        is_change = False
        for wire in wires:
            if wire[0] in check_set and not checked[wire[1]]:
                checked[wire[1]] = True
                check_set.add(wire[1])
                is_change = True
            if wire[1] in check_set and not checked[wire[0]]:
                checked[wire[0]] = True
                check_set.add(wire[0])
                is_change = True
    return len(check_set)
    
