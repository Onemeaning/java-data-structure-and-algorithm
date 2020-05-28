package byteDance;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        int[] res = new int[text.length()];
        Set<String> dic = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dic.add(scanner.nextLine());
        }

        int lastTimes = 0;
        long result = 1;

        for (int i = 0; i < text.length(); i++) {
          int index= i+1;
          while (index <= text.length()){

              if (dic.contains(text.substring(i,index))){
                  index++;
                  lastTimes++;
              }
              else {
                  break;
              }
          }
          System.out.println("lastTimes " + lastTimes);
          res[i] = lastTimes;
          lastTimes = 0;
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0){
                result *= res[i];
            }

        }

        System.out.println(result % 835672545);

    }
}
