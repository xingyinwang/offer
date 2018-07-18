package com.wxy.bixuhui;

import java.util.Stack;

/**
 * Created by Cser_W on 2018/5/6.
 */
public class EvalString {
    public static void main(String[] args){
        String[] str = new String[]{"4", "13", "5", "/", "+"};
        int res = new EvalString().evalRPN(str);
        System.out.println(res);
    }
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; ++i) {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                int temp1 = Integer.parseInt(stack.pop());
                int temp2 = Integer.parseInt(stack.pop());
                switch (tokens[i]) {
                    case "+":
                        stack.push(String.valueOf(temp2 + temp1)); break;
                    case "-":
                        stack.push(String.valueOf(temp2 - temp1)); break;
                    case "*":
                        stack.push(String.valueOf(temp1 * temp2));break;
                    case "/":
                        stack.push(String.valueOf(temp2 / temp1));break;
                    default:
                        break;
                }

            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
