package LeetCode;

public class array {
    public static void main(String[] args){


    }


    public static int singleNumber(int[] nums) {

        int ans = nums[0];
        if (nums.length > 1){

            for (int i = 1; i < nums.length; i++) {

                ans = ans ^ nums[i];
            }

        }
        return ans;




    }

}


