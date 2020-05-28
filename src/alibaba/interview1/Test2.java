package alibaba.interview1;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        int[] heights = new int[nums];
        for (int i = 0; i < nums; i++) {
            heights[i] = scanner.nextInt();
        }

        int[] res = new int[nums];
        int[] forward = new int[nums];
        int[] backward = new int[nums];


        int counts = 0;
        int maxHigh = 0;
        int index = 0;

        for (int i = 0; i < nums; i++) {

            if (i == nums-1){

                forward[i] = 0;
            }else {

                index = i+1;
                maxHigh = heights[index];
                while (index < nums){

                    if (heights[index] > maxHigh){
                        maxHigh = heights[index];
                        counts++;
                    }
                    index++;
                }
                forward[i] = counts;
            }

            counts = 0;
        }

        System.out.println(Arrays.toString(forward));

        for (int i = nums-1; i >= 0; i--) {

            if (i == 0){

                backward[i] = 0;
            }else {

                index = i-1;
                maxHigh = heights[index];
                while (index >= 0){

                    if (heights[index] > maxHigh){
                        maxHigh = heights[index];
                        counts++;
                    }
                    index--;
                }
                backward[i] = counts;
            }
            counts = 0;
        }


        for (int i = 0; i < nums; i++) {

            if (i == 0 || i == nums-1){

                res[i] = forward[i] + backward[i] + 2;

            }
            else{

                res[i] = forward[i] + backward[i] +3;
            }

        }

        for (int i = 0; i < nums; i++) {

            System.out.print(res[i] + " ");
        }

    }

}
