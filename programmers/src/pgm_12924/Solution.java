package pgm_12924;

public class Solution {
    public int solution(int n) {
        int count = 0;
        for(int start = 1; start <= n; start++){
            int target = n;
            for(int val = start; target > 0; val++){
                target -= val;
                if(target == 0)
                    count++;
            }
        }
        return count;
    }
}