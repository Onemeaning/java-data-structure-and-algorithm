package data.structures.stack;

import java.util.List;
import java.util.Scanner;

public class StackApplicationTest {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String exp = "1+((20+3)*4)-5";
        while (!exp.equals("exit")){
            exp= scanner.nextLine();
            exp = exp.replaceAll(" ","");
            if (!exp.matches("[\\d\\+\\-\\*\\/]+\\d*")){

               System.out.println("ERROR：输入表达式有误！请重新输入----");
               continue;
            }

            int res =  0;
            res = StackApplication.eval(exp);
            if (res != -1){
                System.out.printf("中缀表达式：%s = %d\n",exp,res);
            }else {
                System.out.println("ERROR");
            }


            List<String> suffixExp = StackApplication.mid2Suffix(exp);
//            for (String ele : suffixExp){
//                System.out.print(ele);
//            }
//            System.out.println();
            res = StackApplication.evalSuffix(suffixExp);
            if (res != -1){
                System.out.printf("后缀表达式：%s = %d\n",exp,res);
            }else {
                System.out.println("ERROR");
            }

        }



    }
}
