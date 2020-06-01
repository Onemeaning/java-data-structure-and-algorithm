package data.structures.tree.avl;

import java.nio.channels.Channels;

/**
 * @author meanlam
 * @date 2020/5/29-10:40
 */
public class AVLTreeDemo {


    public static void main(String[] args){

//      int[] arr = new int[]{4,3,6,5,7,8}; // 演示左旋
//      int[] arr = new int[]{10,12,8,9,7,6}; // 演示右旋

        int[] arr = new int[]{10,11,7,6,8,9}; // 演示双旋转的情况

        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        System.out.println("===========调整之后的数据============");
        avlTree.inFixOrder();
        System.out.println("树的高度为：" + avlTree.getRoot().height());
        System.out.println("右子树树高度为：" + avlTree.getRoot().rightHeight());
        System.out.println("左子树的高度为：" + avlTree.getRoot().leftHeight());

    }

}

class AVLTree{

    private  Node root ;

    public Node getRoot() {
        return root;
    }

    public void add(Node node){
        if (root == null)
            root = node;
        else
            root.add(node);
    }

    public void inFixOrder(){

        if (root == null){
            System.out.println("这是一颗空树！");
        }
        else {
            root.inFixOrder();
        }

    }


}


class Node{

    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    //返回当前节点为根节点的树的高度
    public int height(){
        return Math.max(left==null ? 0:left.height(),right == null ? 0:right.height())+1;
    }

    //返回当前节点的左子树的高度
    public int leftHeight(){
        if (left == null)
            return 0;
        else
            return left.height();
    }

    //返回当前节点的右子树的高度
    public int rightHeight(){
        if (right == null)
            return 0;
        else return right.height();
    }

    //左旋转
    public void leftRotate(){

        Node node = new Node(val); //创建一个新的节点，以当前节点的值作为新节点的值

        node.left = left;//把新节点的左指针---> 当前节点的左子树

        node.right = right.left;//把新节点的右指针 --> 当前节点的右子树的左指针

        val = right.val;//把当前节点的值，换为当前节点的右节点的值；

        right = right.right;//把当前节点的右指针 --> 当前节点的右子树的右子树

        left = node;// 把当前节点的左指针 --> 新的节点
    }

    //右旋转
    public void rightRotate(){

        Node node = new Node(val);//创建一个新的节点，以当前节点的值作为新节点的值

        node.right = right;//把新节点的右指针---> 当前节点的右子树

        node.left = left.right; // 把新节点的左指针 --> 当前节点的左子树的右指针

        val = left.val; // 把当前节点的值，换为当前节点的左节点的值；（从而复制了一份当前节点的左子节点，则原来的左子节点就淘汰了）

        left = left.left;//把当前节点的左指针 --> 当前节点的左子树的左子树

        right = node;//把当前节点的右指针 --> 新的节点
    }

    /**
     * 添加节点，这里与普通bst树有点不一样，这里会涉及到左旋，右旋，双旋转，从而保证树的平衡；
     * @param node
     */
    public void add(Node node){

       if (node == null){
           return;
       }

       if (node.val < this.val){

           if (left == null){
               left = node;
           }
           else {
               left.add(node);
           }
       }
       else {
           if (right == null)
               right = node;
           else
               right.add(node);
       }

       //右子树比左子树高，则往左旋转调整
       if (rightHeight() - leftHeight() > 1){

           if (right != null && right.leftHeight() > right.rightHeight()){
               right.rightHeight();
               leftRotate();
           }
           else{
              leftRotate();
           }

           return;
       }

       //左子树比右子树高，则往右旋转
        if (leftHeight() - rightHeight() > 1){

            if (left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }
            else{
                rightRotate();
            }

        }
    }

    /**
     * 中序遍历，递归实现；
     */
    public void inFixOrder(){

        if (this.left != null){
            this.left.inFixOrder();
        }

        System.out.println(this.val);

        if (this.right!=null){
            this.right.inFixOrder();
        }

    }





}
