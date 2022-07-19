package pgm_12981;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> sayLog = new HashSet<>();
        int cnt = 1;
        int person = 0;
        String prevWord = String.valueOf(words[0].charAt(0));
        for(String word : words){
            if(sayLog.contains(word) || prevWord.charAt(prevWord.length()-1) != word.charAt(0))
                return new int[]{person+1,cnt};
            prevWord = word;
            sayLog.add(word);
            if(person % n == n-1)
                cnt++;
            person = (person + 1)%n;
        }
        return new int[]{0,0};
    }
}