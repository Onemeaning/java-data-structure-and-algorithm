package zhaoshang;

import java.util.Stack;

public class T3 {

    public static void main(String[] args){

        System.out.println(reverse(1534236469));

    }

    public  static  int reverse(int x) {

        if (x == 0){
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        boolean positive = true;
        int index = 0;

        String s = x + "";
        if (s.charAt(0) == '-'){
            positive = false;
            index = 1;
        }

        for (int i = index; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        while (!stack.isEmpty()){
           Character ch = stack.peek();
           if (ch =='0'){
               stack.pop();
           }
           else {
               break;
           }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

        double result;
        if (!positive){
            result = Double.parseDouble("-" + res.toString());
        }
        else {
            result = Double.parseDouble(res.toString());
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            result = 0;
        }

       return (int) result;

    }

}
