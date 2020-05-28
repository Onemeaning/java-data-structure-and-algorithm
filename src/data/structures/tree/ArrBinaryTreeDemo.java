package data.structures.tree;

import org.omg.SendingContext.RunTime;

public class ArrBinaryTreeDemo {

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);

        System.out.println("前序遍历！");
        arrBinaryTree.preOrder();

        System.out.println("中序遍历！");
        arrBinaryTree.midOrder();

        System.out.println("后序遍历！");
        arrBinaryTree.postOrder();
    }

}

class ArrBinaryTree{

    private int[] arr;

    public ArrBinaryTree(int[] arr){

        this.arr = arr;
    }


    public void preOrder(){

        this.preOrder(0);
    }

    public void midOrder(){

        this.midOrder(0);
    }

    public void postOrder(){

        this.postOrder(0);
    }


    private void preOrder(int index){

        if (arr == null || arr.length ==0){

            System.out.println("数组为空无法遍历！");
        }

        System.out.println(arr[index]);

        if ((2*index+1) < arr.length){

            this.preOrder(2*index+1);
        }

        if ((2*index+2) < arr.length){

            this.preOrder(2*index+2);
        }

    }



    private void midOrder(int index) {

        if (arr == null || arr.length ==0){

            System.out.println("数组为空无法遍历！");
        }


        if ((2*index+1) < arr.length){

            this.midOrder(2*index+1);
        }

        System.out.println(arr[index]);

        if ((2*index+2) < arr.length){

            this.midOrder(2*index+2);

        }
    }


    private void postOrder(int index){

        if (arr == null || arr.length ==0){

            System.out.println("数组为空无法遍历！");
        }


        if ((2*index+1) < arr.length){

            this.postOrder(2*index+1);
        }

        if ((2*index+2) < arr.length){

            this.postOrder(2*index+2);
        }
        System.out.println(arr[index]);
    }

}
