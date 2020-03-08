package data.structures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 栈的应用：
 * 1）计算一个表达式的值
 * 2）
 */

public class StackApplication {

    /**
     * Test:7*2*2-5+1-5+3-4;    2*2*2*3+10-11+12-13+10-11
     * 模拟计算器，计算表达式的结果
     * @param expression
     * @return
     */
    public static int eval(String expression){

        expression = expression.replaceAll(" ","");
        if (!expression.matches("[\\d\\+\\-\\*\\/]+\\d*")){
            return -1;
        }
        int len = expression.length();
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < len; i++) {

            char c = expression.charAt(i);
            String ch = "";
            if (c >= '0' && c <= '9'){

                //如果是多位数字怎么办
                ch += c;
                int index = i+1;
                while (index <= len-1 && expression.charAt(index) >= '0' && expression.charAt(index) <='9'){
                    ch += expression.charAt(index);
                    index++;
                }
                i = index-1;
                numbers.push(Integer.valueOf(ch));

            }
            else {

                if (operators.isEmpty()){
                    operators.push(c);
                }
                else {

                    int preOpt = StackApplication.priority(operators.peek());
                    int curOpt = StackApplication.priority(c);

                    if (curOpt > preOpt){

                        operators.push(c);

                    }else {

                        char operator = operators.pop();
                        int result = StackApplication.cal(numbers.pop(),numbers.pop(),operator);
                        operators.push(c);
                        numbers.push(result);
                    }
                }
            }


        }


        while (!operators.isEmpty()){

            char operator = operators.pop();
            int result = StackApplication.cal(numbers.pop(),numbers.pop(),operator);
            numbers.push(result);
        }

        return numbers.pop();
    }

    private static int priority(char c){
        if (c == '*' || c == '/')
            return 1;
        else if (c == '+' || c == '-')
            return 0;
        else
            return -1;
    }

    private static int cal(int num1, int num2, char operator){
        int result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }


    /**
     * 将中缀表达式转换成后缀表达式
     * @param expression 输入一个中缀表达式
     * @return 后缀表达式
     */
    public static List<String> mid2Suffix(String expression){

        expression = expression.replaceAll(" ","");
        int length = expression.length();
//      Stack<Character> numbers = new Stack<>();
        List<String> numbers = new ArrayList<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < length; i++) {

            char c = expression.charAt(i);
            String ch = "";
            if (c >= '0' && c <= '9'){

                ch += c;
                int index = i+1;
                while (index <= length-1 && expression.charAt(index) >= '0' && expression.charAt(index) <='9'){
                    ch += expression.charAt(index);
                    index++;
                }
                i = index-1;

                numbers.add(ch);
            }
            else {
                if (operators.isEmpty() || operators.peek() == '('){

                    operators.push(c);

                }else {
                    if (c == '('){
                        operators.push(c);
                        continue;
                    }

                    if (c == ')'){
                        char temp;
                        while ((temp = operators.pop()) !='('){
                           numbers.add(""+temp);
                        }
                        continue;
                    }
                    if (StackApplication.priority(operators.peek()) < StackApplication.priority(c)){
                        operators.push(c);
                    }
                    else {
                        numbers.add(""+operators.pop());
                        --i;
                    }
                }
            }

        }


        while (!operators.isEmpty()){
            numbers.add(""+operators.pop());
        }

        return numbers;
    }


    public static int evalSuffix(List<String> exp){

        int len = exp.size();
        Stack<String> symbols = new Stack<>();

        for (int i = 0; i < len; i++) {

            String c = exp.get(i);
            if (c.matches("\\d+")){
                symbols.push(c);
            }
            else {

              int num1 = Integer.valueOf(symbols.pop());
              int num2 = Integer.valueOf(symbols.pop());
              int res = StackApplication.cal(num1,num2,c.charAt(0));
              symbols.push(""+res);

            }

        }

        return Integer.valueOf(symbols.pop());

    }

}
