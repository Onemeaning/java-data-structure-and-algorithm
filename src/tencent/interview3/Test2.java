package tencent.interview3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test2 {

    public static void main(String[] args){

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        List<Integer> output = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {

            String[] temp = scanner.nextLine().trim().split(" ");
            if (temp[0].equals("add")){

                stack1.push(Integer.parseInt(temp[1]));
            }
            else if (temp[0].equals("poll")){

                poll(stack1,stack2);
            }
            else if (temp[0].equals("peek")){

                output.add(peek(stack1,stack2));
            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));

        }

    }

    private static int peek(Stack<Integer> s1, Stack<Integer> s2){

        while (!s1.isEmpty()){

            s2.push(s1.pop());
        }

        int temp =  s2.peek();

        while (!s2.isEmpty()){

            s1.push(s2.pop());
        }

        return temp ;
    }

    private static void poll(Stack<Integer> s1, Stack<Integer> s2){

        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s2.pop();

        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }

    }

}
