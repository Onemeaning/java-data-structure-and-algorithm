package huawei.test1;

import java.util.ArrayList;

public class Solution {


    public static void main(String[] args){

        int[] nums = {2,3,4,2,6,2,5,1};

        ArrayList<Integer> integers = maxInWindows(nums, 3);
        System.out.println(integers.toString());
    }


    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res= new ArrayList();

        int len = num.length;
        int index = size;

        for(int i = 0;i< len-size +1;i++){
            TreeNode1 temp = new TreeNode1();
            int j = i;
            while(j < index){

                Node1 node = new Node1(num[j]);
                temp.add(node);
                j++;
            }
            res.add(temp.getMax());
            index ++;
        }
        return res;
    }

}


class Node1{
    Node1 left;
    Node1 right;
    int val;

    public Node1(int val){
        this.val = val;
    }

   public void add(Node1 node){
       if (node.val < this.val){

           if (this.left == null){
               this.left = node;
           }else {
               this.left.add(node);
           }
       }
       else {

           if (this.right == null){
               this.right = node;
           }else {
               this.right.add(node);
           }
       }
   }

}

class TreeNode1{

    Node1 root;

    public void add(Node1 node){

        if (root == null){
            root = node;
        }
        else {

            root.add(node);
        }
    }

    public int getMax(){
        if(root == null){
            return 0;
        }
        while(root.right != null){
            root = root.right;
        }

        return root.val;
    }


}