package pgm_12951;

public class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");
        for(String word : words){
            if(word.equals("")){
                answer += " ";
                continue;
            }
            String lowerCase = word.toLowerCase();
            word = lowerCase;
            if(!Character.isDigit(lowerCase.charAt(0))){
                word = lowerCase.toUpperCase().charAt(0) +"";
                if(lowerCase.length() > 1)
                    word += lowerCase.substring(1);
            }
            answer = answer +" "+ word;
        }
        if(s.charAt(s.length()-1) == ' ')
            return answer.substring(1) +" ";
        return answer.substring(1);
    }
}