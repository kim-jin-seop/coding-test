package pgm_42583;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int count = 0;
        int roadWeight = 0;
        Queue<int[]> road = new LinkedList<>();
        int ptr = 0;

        while (ptr < truck_weights.length){
            count++;

            if(!road.isEmpty() &&count-road.peek()[1] == bridge_length){
                int[] truck = road.remove();
                roadWeight -= truck[0];
            }

            if(truck_weights[ptr] + roadWeight <= weight){
                road.add(new int[]{truck_weights[ptr],count});
                roadWeight += truck_weights[ptr];
                ptr ++;
            }
            else{
                int[] truck = road.remove();
                roadWeight -= truck[0];
                count += truck[1] + bridge_length-count-1;
            }
        }

        while (!road.isEmpty()){
            int[] truck = road.remove();
            count += truck[1] + bridge_length-count;
        }
        return count;
    }
}
