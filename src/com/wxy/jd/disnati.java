package com.wxy.jd;

/**
 * Created by Cser_W on 2018/4/9.
 */



import java.util.Scanner;
import java.util.Stack;

public class disnati {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String temp = scanner.nextLine();
        for(int i = 0; i < t; ++i){
            String str = scanner.nextLine();
            boolean isYes= new disnati().isOk(str);
            if(isYes) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private  boolean isOk(String str) {
        Stack<Character> stack = new Stack<>();
        boolean tag = false;
        for(int i = 0; i < str.length(); ++i){
            char c = str.charAt(i);
            if(c != '('){
                if(!stack.empty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push('(');
                    tag = true;
                }

            }else{
                stack.push(c);
            }
        }
        if(tag && stack.size() == 2){
            char c1 = stack.pop();
            char c2 = stack.pop();
            if(c1 == '(' && c2 == '(') {
                return true;
            }
        }
        if(!tag && stack.empty()){
            if(str.length() >= 4) {
                return true;
            }
        }
        return false;
    }
}






/*
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < t; i++){
            list.add(in.nextLine());
        }

        for(int i = 0; i < list.size();i++){
            if(new Main1().isOk(list.get(i).toCharArray()))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    private  boolean isOk(char[] arr){
       // char[] arr = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        boolean hasLeft = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != '('){
                if(stack.size() > 0)
                    stack.pop();
                else if(!hasLeft)
                    hasLeft = true;
                else
                    return false;

            }
            else{
                stack.push(arr[i]);
            }
        }
        if(stack.size() == 0)
            return true;
        else if(stack.size() == 1 && hasLeft)
            return true;
        else
            return false;
    }
}
*/
