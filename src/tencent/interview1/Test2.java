package tencent.interview1;

import java.util.LinkedList;
import java.util.Queue;

public class Test2 {


//    1、判断一棵树是否为完全二叉树：

    public static boolean isCBT(Node head){

        if (head == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        Node left = null;
        Node right = null;
        boolean leaf = false;// 开启叶子节点判断

        queue.offer(head);//将节点加入到队列中

        while (!queue.isEmpty()){

            head = queue.poll();//从队列中取出节点
            left = head.left;
            right = head.right;

            /*
             * （1）叶子节点,如果还有子节点的情况
             *
             *  或者
             *
             * （2）左节点为空但是右节点不为空的情况
             *
             *  都不是完全二叉树
             */
            if ((leaf && (left != null || right != null)) || (left == null && right != null )){

                return false;
            }

            if (left != null){

                queue.offer(left);
            }

            if (right != null){
                queue.offer(right);
            }

            if (left == null || right == null){
                leaf = true; // 开启叶节点判断;
            }


        }

        return true;
    }


    /**
     * 判断一棵树是否为搜索二叉树
     */

     public static boolean isBST(Node node){

         return true;

     }




}
