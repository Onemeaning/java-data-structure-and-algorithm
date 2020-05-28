package data.structures.tree;

/**
 * 二叉树：
 *
 */
public class BinaryTreeDemo {

    public static void main(String[] args){

        BinaryTree binaryTree = new BinaryTree();

        HeroNode head = new HeroNode(1,"松江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");

        //手动创建二叉树
        binaryTree.setHead(head);
        head.setLeft(node2);
        head.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);


//        //遍历
//        System.out.println("***********前序遍历**************");
//        binaryTree.preList();
//
//        System.out.println("***********中序遍历**************");
//        binaryTree.midInOrderList();
//
//        System.out.println("***********后序遍历**************");
//        binaryTree.postList();


//       System.out.println("***********前序查找**************");
//        HeroNode resNode = binaryTree.preSearch(15);
//        if (resNode == null){
//            System.out.printf("没有找到编号为%d的英雄",15);
//        }else {
//
//            System.out.printf("编号为%d的英雄的姓名为：%s",resNode.getNo(),resNode.getName());
//       }


//        System.out.println("***********中序查找**************");
//        HeroNode resNode = binaryTree.midSearch(15);
//        if (resNode == null){
//            System.out.printf("没有找到编号为%d的英雄",15);
//        }else {
//            System.out.printf("编号为%d的英雄的姓名为：%s",resNode.getNo(),resNode.getName());
//        }
//

//        System.out.println("***********后序查找**************");
//        HeroNode resNode = binaryTree.preSearch(15);
//        if (resNode == null){
//            System.out.printf("没有找到编号为%d的英雄",15);
//        }else {
//
//            System.out.printf("编号为%d的英雄的姓名为：%s",resNode.getNo(),resNode.getName());
//        }


        //遍历
        System.out.println("***********删除前前序遍历**************");
        binaryTree.preList();

        binaryTree.delNode(5);

        System.out.println("***********删除后前序遍历**************");
        binaryTree.preList();


    }


}

class BinaryTree{

    HeroNode head;

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }


    public void preList(){

        if (head != null){

            this.head.preList();
        }
        else {
            System.out.println("二叉数为空，不能遍历！");
        }
    }


    public void midInOrderList(){

        if (head != null){

            this.head.midList();
        }
        else {
            System.out.println("二叉数为空，不能遍历！");
        }
    }


    public void postList(){

        if (head != null){

            this.head.afterList();
        }
        else {
            System.out.println("二叉数为空，不能遍历！");
        }
    }


    public HeroNode preSearch(int no){

        if (head == null){
            return null;
        }
        else {
            return head.preSearch(no);
        }
    }

    public HeroNode midSearch(int no){
        if (head ==null){
            return null;
        }
        else {

            return head.midSearch(no);
        }
    }

    public HeroNode postSearch(int no){

        if (head == null){
            return null;
        }
        else {

            return head.postSearch(no);
        }
    }



    public void delNode(int no){

        if (head == null){
            System.out.println("这是一个空树，无法删除！");
        }
        else {

            if (head.getNo() == no){
                head = null;
            }else
                head.delete(no);

        }

    }


}



class HeroNode{

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preList(){
        System.out.println(this.toString());

        if (this.left != null){
            this.left.preList();
        }
        if (this.right != null){
            this.right.preList();
        }
    }


    //编写中序遍历的方法
    public void midList(){

        if (this.left != null){

            this.left.midList();
        }

        System.out.println(this.toString());

        if (this.right != null){

            this.right.midList();
        }
    }

    // 后续遍历的方法
    public void afterList(){

        if (this.left!= null){
            this.left.afterList();
        }

        if (this.right != null){
            this.right.afterList();
        }

        System.out.println(this.toString());

    }

    //


    /********************三种遍历查找代码**************************/

    //前序遍历查找代码
    public HeroNode preSearch(int no){

        if (this.no == no){
            return this;
        }

        HeroNode resNode = null;
        if (this.left != null){

            resNode = this.left.preSearch(no);
        }

        if (resNode != null){
            return resNode;
        }

        if (this.right != null){

            resNode = this.right.preSearch(no);
        }

        return resNode;
    }



    //中序遍历查找代码
    public HeroNode midSearch(int no){

        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.midSearch(no);
        }

        if (resNode != null){
            return resNode;
        }

        if (this.no == no){
            return this;
        }

        if (this.right != null){
            resNode = this.right.midSearch(no);
        }

        return resNode;

    }

    //后序遍历查找
    public HeroNode postSearch(int no){

        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postSearch(no);
        }

        if (resNode != null){
            return resNode;
        }

        if (this.right != null){

            resNode = this.right.postSearch(no);
        }

        if (resNode != null){
            return  resNode;
        }

        if (this.no == no){
            return this;
        }

        return null;
    }

    /********************删除节点的方法**************************/


    public void delete(int no){

        if (this.left!=null && this.left.no == no){
            this.left = null;
            return;
        }

        if (this.right!=null && this.right.no == no){
            this.right = null;
            return;
        }

        if (this.left !=null){
            this.left.delete(no);
        }

        if (this.right != null){
            this.right.delete(no);
        }



    }



}