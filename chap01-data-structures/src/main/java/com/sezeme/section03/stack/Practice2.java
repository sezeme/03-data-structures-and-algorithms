package com.sezeme.section03.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;

public class Practice2 {
    public int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        String value = br.readLine();
        Stack<Character> stack = new Stack<>();
        int pieceCnt = 0;
        for(int i = 0; i < value.length(); i++){
            char ch = value.charAt(i);
            if( ch == '(') stack.push(ch);
            else {
                stack.pop();
                if(value.charAt(i-1) == '(') {
                    //레이저
                    pieceCnt += stack.size();
                } else {
                    //쇠막대기
                    pieceCnt++;
                }
            }
        }
        System.out.println(pieceCnt);
        return pieceCnt;
    }

}
