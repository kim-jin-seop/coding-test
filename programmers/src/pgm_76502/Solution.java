package pgm_76502;

import java.util.Stack;
import java.util.function.Predicate;

public class Solution {
    public int solution(String s) {
        int moveCount = 0;
        int count = 0;
        while (moveCount != s.length()){
            String check = "";
            for(int i = 0; i < s.length(); i++){
                check = check + s.charAt(i);
                if(isCorrect(check)){
                    check = "";
                    count ++;
                }
            }
            if(!check.equals("")) {
                count = 0;
                s = rotate(s);
                moveCount++;
            }
            else
                break;
        }
        return count;
    }

    private boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        Predicate<Character> isOpen = c -> c == '[' || c == '(' || c == '{';

        for(int i = 0; i < s.length(); i++){
            if(isOpen.test(s.charAt(i)))
                stack.add(s.charAt(i));
            else{
                if(stack.isEmpty() || !isPare(stack.pop(),s.charAt(i)))
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    private boolean isPare(Character open, Character close){
        return (open == '{' && close == '}') || (open == '[' && close == ']') || (open == '(' && close == ')');
    }

    private String rotate(String s){
        return s.substring(1) + s.charAt(0);
    }
}