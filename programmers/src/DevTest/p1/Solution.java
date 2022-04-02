package DevTest.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int[][] solution(int[][] dist) {

        boolean[] select = new boolean[dist.length];
        ArrayList<int[]> resultList = new ArrayList<>();

        recursive(1,select,dist,resultList);

        Collections.sort(resultList,(l1,l2) -> {
            for(int i = 0; i < l1.length; i++ ){
                if(l1[i] == l2[i])
                    continue;
                if(l1[i] > l2[i])
                    return 1;
                else
                    return -1;
            }
            return 0;
        });

        int[][] answer = new int[resultList.size()][dist.length];
        for(int i = 0; i < resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    private void recursive(int location, boolean[] select , int[][] dist, ArrayList<int[]> resultList){
        if (validCheck(location, select, dist))
            return;
        if(location == select.length) {
            int[] result = makeResultList(select, dist);
            resultList.add(result);
            return;
        }

        select[location] = true;
        recursive(location+1,select,dist,resultList);
        select[location] = false;
        recursive(location+1,select,dist,resultList);
    }

    private int[] makeResultList(boolean[] select, int[][] dist) {
        int[] result = new int[select.length];
        PriorityQueue<Location> forResultHeap = new PriorityQueue<>();

        for(int i = 0; i < select.length; i++){
            forResultHeap.add(new Location(i, select[i] ? dist[i][0] : dist[i][0]*-1));
        }

        int idx = 0;
        while (!forResultHeap.isEmpty()){
            Location value = forResultHeap.remove();
            result[idx++] = value.location;
        }
        return result;
    }

    private boolean validCheck(int location, boolean[] select, int[][] dist) {
        int changeIndex = location -1;
        int changeSign = select[location -1] ? -1 : 1;
        for(int check = 1; check < location -1; check++){
            int checkSign = select[check] ? -1 : 1;
            if(Math.abs(dist[0][changeIndex]*changeSign - dist[0][check]*checkSign) != dist[check][changeIndex])
                return true;
        }
        return false;
    }

    private class Location implements Comparable<Location>{
        int location;
        int distance;

        private Location(int location, int distance){
            this.location = location;
            this.distance = distance;
        }

        @Override
        public int compareTo(Location o) {
            if(o.distance == distance)
                return 0;
            if(o.distance < distance)
                return 1;
            else
                return -1;
        }
    }
}
