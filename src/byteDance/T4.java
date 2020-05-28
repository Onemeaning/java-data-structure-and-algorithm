package byteDance;

import java.util.*;

public class T4 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> result = new ArrayList<>();
        Set<Character> sets = new HashSet<>();
        int start = 0,end = 0;
        for (int i = 0; i < n; i++) {

            String[] line  = scanner.nextLine().trim().split(" ");
            switch (line[0]){

                case "1":
                    int index = Integer.parseInt(line[1])-1;
                    text[index] = line[2].charAt(0);
                    break;
                case "2":

                    start = Integer.parseInt(line[1])-1;
                    end = Integer.parseInt(line[2]);
//                    int len = end-start;
//                    char[] res = new char[len];
//                    System.arraycopy(text,start,res,0,len);

                    for (int j = start; j < end; j++) {
                        sets.add(text[j]);
                    }
                    result.add(sets.size());
                    sets.clear();
                    break;

            }

        }

        for (Integer integer : result){
            System.out.println(integer);
        }

    }
}
