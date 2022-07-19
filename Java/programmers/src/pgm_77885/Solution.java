package pgm_77885;

public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        for(long number : numbers){
            long value = solve(number);
            answer[idx++] = value;
        }
        return answer;
    }

    public long solve(long number){
        long depth = 0;
        long target = number;
        while (true){
            if((target&1) == 0){
                break;
            }
            target /= 2;
            depth++;
        }

        double addValue = Math.pow(2, depth);
        double minusValue = depth == 0 ? 0 : Math.pow(2, depth-1);
        return number + (long) addValue - (long)minusValue;
    }
}
