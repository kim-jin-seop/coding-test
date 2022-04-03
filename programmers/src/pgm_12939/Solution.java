package pgm_12939;

public class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");

        int min = Integer.valueOf(numbers[0]);
        int max = Integer.valueOf(numbers[0]);
        for(String number : numbers){
            min = min < Integer.valueOf(number) ? min : Integer.valueOf(number);
            max = max > Integer.valueOf(number) ? max : Integer.valueOf(number);
        }

        return min + " " + max;
    }
}