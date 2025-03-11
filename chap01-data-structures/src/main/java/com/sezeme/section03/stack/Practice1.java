package com.sezeme.section03.stack;

import java.io.IOException;
import java.util.Stack;

public class Practice1 {
    public String solution(String input) throws IOException {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '(') stack.push(ch);
            else if(ch == ')'){
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(stack.isEmpty()) return "YES";
        return "NO";
    }
}
