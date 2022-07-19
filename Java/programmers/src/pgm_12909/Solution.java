package pgm_12909;

import java.util.Stack;

public class Solution {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add('(');
                continue;
            }

            if(stack.isEmpty())
                return false;
            stack.pop();
        }

        return stack.isEmpty();
    }
}
