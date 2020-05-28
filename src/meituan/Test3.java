package meituan;

import java.util.*;

public class Test3 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        Set<Integer> temp = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        Map<Integer,Integer> startMap = new HashMap<>();
        Map<Integer,Integer> endMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            start[i] = scanner.nextInt();
            startMap.put(start[i],i);
        }

        for (int i = 0; i < n; i++) {
            end[i] = scanner.nextInt();
            endMap.put(end[i],i);
        }


        for (int i = 0; i < n; i++) {

            int s = i;
            int e = endMap.get(start[i]);

            for (int j = s + 1; j < n; j++) {

                temp.add(start[j]);
            }

            for (int j = 0; j < e ; j++) {

               if (temp.contains(end[j])){
                   result.add(end[j]);
               }

            }

            temp.clear();

        }

        System.out.println(result.size());
    }

}
