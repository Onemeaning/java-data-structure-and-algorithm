package tencent.interview3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> nums = new LinkedList<>();
        List<Integer> output = new ArrayList<>();

        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {

            int t1 = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < t1; j++) {

                String[] temp = scanner.nextLine().trim().split(" ");
                if (temp[0].equals("PUSH")){
                    nums.add(Integer.parseInt(temp[1]));
                }
                else if (temp[0].equals("TOP")){

                    if (nums.size() > 0){
                        output.add(nums.getFirst());
                    }else {
                        output.add(-1);
                    }

                }
                else if (temp[0].equals("POP")){

                    if (nums.size() > 0){
                        nums.removeFirst();
                    }else {
                        output.add(-1);
                    }


                }else if (temp[0].equals("SIZE")){

                    output.add(nums.size());


                }else if (temp[0].equals("CLEAR")){

                    nums.clear();
                }


            }

        }
        scanner.close();

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }

    }
}
