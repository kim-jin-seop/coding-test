package pgm_42747;

public class Solution {
    public int solution(int[] citations) {
        int[] count = new int[1001];
        for(int i = 0; i < citations.length; i++){
            for(int j = 0; j < count.length; j++){
                if (citations[i] >= j)
                    count[j] ++;
                else
                    break;
            }
        }

        for(int i = 0; i < count.length; i ++){
            if(count[i] >= i)
                continue;
            return i-1;
        }
        return 0;
    }
}
