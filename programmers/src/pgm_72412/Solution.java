package pgm_72412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public Integer[] solution(String[] info, String[] query) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String , ArrayList<Integer>> db = new HashMap<>();
        inputInfo(db, info);

        for(String q : query)
            answer.add(processQuery(db,q));
        return answer.toArray(new Integer[0]);
    }

    public void inputInfo(Map<String, ArrayList<Integer>> db, String[] infos){
        for(String info : infos){
            StringBuilder sb = new StringBuilder();
            String[] columns = info.split(" ");
            for(int i = 0; i < columns.length-1; i++)
                sb.append(columns[i]);

            String key = sb.toString();
            int score = Integer.parseInt(columns[4]);

            ArrayList<Integer> list;
            if(db.containsKey(key))
                list = db.get(key);
            else
                list = new ArrayList<>();
            list.add(score);
            db.put(key,list);
        }
    }

    public int processQuery(Map<String, ArrayList<Integer>> db,String query){
        AtomicInteger count = new AtomicInteger();
        String[] splitQuery = query.split(" and ");
        String lang = splitQuery[0];
        String part = splitQuery[1];
        String career = splitQuery[2];
        String food = splitQuery[3].split(" ")[0];
        String score = splitQuery[3].split(" ")[1];

        db.keySet().stream().
                filter((k) -> {
                    if (lang.equals("-"))
                        return k.contains("java") || k.contains("python") || k.contains("cpp");
                    else
                        return k.contains(lang);
                }).
                filter((k) -> {
                    if (part.equals("-"))
                        return k.contains("backend") || k.contains("frontend");
                    else
                        return k.contains(part);
                }).
                filter((k) -> {
                    if (career.equals("-"))
                        return k.contains("junior") || k.contains("senior");
                    else
                        return k.contains(career);
                }).
                filter(k -> {
                    if (food.equals("-"))
                        return k.contains("chicken") || k.contains("pizza");
                    else
                        return k.contains(food);
                }).forEach(key ->{
                    ArrayList<Integer> list = db.get(key);
                    list.forEach(s ->{
                        if(s >= Integer.parseInt(score))
                            count.getAndIncrement();
                    });
                });
        return count.get();
    }
}