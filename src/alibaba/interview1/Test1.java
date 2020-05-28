package alibaba.interview1;

import java.util.Scanner;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        Stack<String> opt = new Stack<>();
        Stack<Integer> num = new Stack<>();
        Stack<String> data = new Stack<>();


        boolean flag = false;

        String str = "";

        for (int i = 0; i < string.length(); i++) {

            str= string.charAt(i)+"";
            if (str.equals("[")){

                opt.push(str);
                continue;
            }
            if (str.matches("[1-9]")){

                StringBuilder sb = new StringBuilder();
                while ((str = string.charAt(i)+"").matches("[0-9]")){

                  sb.append(str);
                  i++;
                }
                num.push(Integer.parseInt(sb.toString()));
                sb.delete(0,sb.length());
                i--;
                continue;
            }


            //操作数为空的情况下；
            if (opt.isEmpty()){

                if (str.matches("[A-Z]")){

                    builder.append(str);
                }
                else if (str.equals("]")){
                    throw new RuntimeException("输入字符串压缩格式有误！");
                }

            }
            else {//操作符栈不为空；

                if (str.matches("[A-Z]")){

                    temp.append(str);
                    flag = true;

                }else {

                   if (flag){

                       data.push(temp.toString());
                       flag = false;
                       temp.delete(0,temp.length());
                   }

                }


               if (str.equals("]")){

                    int tempNum = num.pop();
                    String tempStr = data.pop();
                    StringBuilder sb = new StringBuilder();

                    for (int j = 0; j < tempNum; j++) {

                       sb.append(tempStr);
                    }

                    System.out.println(sb.toString());


                    if (!data.isEmpty()){

                        sb.insert(0,data.pop());
                        data.push(sb.toString());
                        sb.delete(0,sb.length());
                    }
                    else {

                        builder.append(sb.toString());
                        sb.delete(0,sb.length());
                    }

                    opt.pop();
                }


            }


        }

        System.out.println(builder.toString());


    }
}
