package pgm_42578;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[][] clothes) {
        int answer;

        Map<String, ArrayList<String>> map = new HashMap<>();
        makeMap(clothes, map);

        answer = map.keySet().stream().mapToInt(key -> (map.get(key).size() + 1)).reduce(1, (a, b) -> a * b);
        return answer-1;
    }

    private void makeMap(String[][] clothes, Map<String, ArrayList<String>> map) {
        for(int i = 0; i < clothes.length; i++){
            ArrayList<String> list = new ArrayList<>();
            if(map.containsKey(clothes[i][1]))
                list = map.get(clothes[i][1]);
            list.add(clothes[i][0]);
            map.put(clothes[i][1], list);
        }
    }
}
