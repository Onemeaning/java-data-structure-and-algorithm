package tencen;

public class Test2 {

    public static void main(String[] args){

        Node node1 = new Node(2);
        Node node2 = new Node(3);

        //作为根节点
        Node test = new Node(5);
        test.setLeft(node1);
        test.setRight(node2);

        //判断一个数据是否为完全二叉树
        if (test.left!=null && test.right!=null){

            System.out.println("这是一个完全二叉树");
        }else {

            System.out.println("不是一个完全二叉树");
        }



    }
}
