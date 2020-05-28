package tencent.interview2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = scanner.nextInt();
        }

        int[] result = new int[n-m];

        for (int j = 0; j < n-m ; j++) {

            Map<Integer,Boolean> save = new HashMap<>();
            for (int i = 1; i <= m; i++) {
                save.put(i,true);
            }
            int times = 0;
            for (int i = j; i < n; i++) {

                int tempData = temp[i];
                if (save.get(tempData) != null){
                    save.remove(tempData);
                }
                times++;

                if (save.isEmpty()){
                    break;
                }
            }
            result[j] = times;
        }
        Arrays.sort(result);
        System.out.println(result[0]);

    }
}
