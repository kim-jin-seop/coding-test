package sk_ict_p4;

import java.util.*;

class Solution {
    public long solution(int n, int[][] edges) {
        long answer = 0;
        Set<Integer>[] notConnect = new Set[n];
        Set<Integer>[] connect = new Set[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> inputSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                inputSet.add(j);
            }
            notConnect[i] = inputSet;
            connect[i] = new HashSet<>();
        }

        //연결
        for (int i = 0; i < edges.length; i++) {
            int vertexA = edges[i][0];
            int vertexB = edges[i][1];
            connect[vertexA].add(vertexB);
            connect[vertexB].add(vertexA);
            if (notConnect[vertexA].contains(vertexB))
                notConnect[vertexA].remove(vertexB);
            if (notConnect[vertexB].contains(vertexA))
                notConnect[vertexB].remove(vertexA);
        }

        //찾기
        for (int i = 0; i < n; i++) {
            Set<Integer> check = notConnect[i];
            for (Integer findValue : check) {
                for (Integer connectVal : connect[i]) {
                    Queue<Integer> queue = new LinkedList<>();
                    boolean[] checked = new boolean[n];
                    checked[i] = true;
                    checked[connectVal] = true;
                    queue.add(connectVal);
                    boolean find = false;
                    int depth = 1;
                    int[] d = new int[n];
                    d[connectVal] = 1;
                    while (!queue.isEmpty()) {
                        int getConnect = queue.remove();
                        for (Integer inputV : connect[getConnect]) {
                            if (inputV == findValue) {
                                find = true;
                                answer+= d[getConnect];
                                break;
                            }
                            if (!checked[inputV]) {
                                d[inputV] = d[getConnect]+1;
                                queue.add(inputV);
                                checked[inputV] = true;
                            }
                        }
                        if(find)
                            break;
                    }
                }
            }
        }
        return answer;
    }
}