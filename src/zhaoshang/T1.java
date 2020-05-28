package zhaoshang;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = (n * (n +1))/2;
        int[] nums = new int[x];

        for (int i = 0; i < x; i++) {
            nums[i] = scanner.nextInt();
        }

        Node.createBinaryTreeByArray(nums,0);

    }


    }

class Node{

    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }


    public static Node createBinaryTreeByArray(int[]array, int index)
    {
        Node tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new Node(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

}
