package data.structures.tree.bst;

public class BinarySortTreeDemo {

    public static void main(String[] args){

        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree bst = new BinarySortTree();

        for (int i = 0; i < arr.length; i++) {

            bst.add(new Node(arr[i]));
        }

        System.out.println("中序遍历结果！");

        bst.inFixOrder();

        bst.delNode(2);
        bst.delNode(5);
        bst.delNode(9);
        bst.delNode(12);
        bst.delNode(7);
        bst.delNode(3);
        bst.delNode(1);
        bst.delNode(10);


        System.out.println("删除节点之后的结果");
        bst.inFixOrder();


    }

}

class BinarySortTree{

    private Node root;

    public void add(Node node){

        if (root == null){
            root = node;
        }
        else {

            root.add(node);
        }
    }

    public void inFixOrder(){

        if (root != null){
            root.inFixOrder();
        }
        else {
            System.out.println("这是一个空树");
        }
    }


    public Node search(int value){

        if (this.root == null){
            return null;
        }
        else {
            return root.search(value);
        }
    }


    public Node searchParent(int val){

        if (root == null){
            return null;
        }
        else {
            return root.searchParent(val);
        }
    }

    /*
        从targetNode 的右子树找到最小的结点
        删除该最小结点;
     */
    public int delRightTreeMin(Node node){

        Node cur = node;
        while (cur.left != null){
            cur = cur.left;
        }

        //删除最小的节点；
        delNode(cur.value);
        return cur.value;
    }

    public int delLefTreeMax(Node node){

        Node cur = node;
        while (cur.right!= null){
            cur = cur.right;
        }

        delNode(cur.value);
        return cur.value;

    }

    /*
        从targetNode的左子树找到最大的节点
        删除这个最大的节点
     */
    public void delNode(int val){

        if (root == null){
            return;
        }

        else {

            //1、需要找到要删除的节点
            Node targetNode = root.search(val);
            if (targetNode == null){
                return;
            }

            //如果待删除节点是没有父节点的情况下,说明此时只有一个根节点；
            if (root.left == null && root.right == null){
                root = null;
                return;
            }


            //2、需要找到要删除节点的父节点；
            Node parent = root.searchParent(val);


            //3、判断是哪一种节点

            //(1) 待删除的节点是一个叶子节点：
            if (targetNode.left== null && targetNode.right == null){
                // 判断待删除节点是父节点的左节点还是右节点，从而直接删除

                if (parent.left != null && parent.left == targetNode){
                    parent.left = null;
                }
                else if (parent.right!= null && parent.right == targetNode){
                    parent.right = null;
                }
            }

            // 待删除节点带有两个字节点的情况；
            else if (targetNode.left != null && targetNode.right != null){

                //方法1： 从右子树中找最小值；
//                int minVal = delRightTreeMin(targetNode.right);
//                targetNode.value = minVal;

                //方法2： 从左子树中找最大值；

                int maxVal = delLefTreeMax(targetNode.left);
                targetNode.value = maxVal;

            }

            //待删除节点只有一个子节点的情况；
            else {

                 if (targetNode.left !=null){ // 待删除节点有一个左子节点

                     if (parent == null){ //考虑到整颗树中只有两个节点的时候，此时targetNode没有父节点
                         root = targetNode.left;
                     }
                     else {
                         if (parent.left == targetNode) {
                             parent.left = targetNode.left;
                         } else if (parent.right == targetNode) {
                             parent.right = targetNode.left;
                         }
                     }
                 }

                 else if (targetNode.right != null){ // 待删除节点有一个右子节点

                     if (parent == null){

                         root = targetNode.right;
                     }
                     else {
                         if (parent.left == targetNode){
                             parent.left = targetNode.right;
                         }else if (parent.right == targetNode){
                             parent.right = targetNode.right;
                         }
                     }

                 }

            }

        }

    }

}



class Node{

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){

        if (node.value < this.value){

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

    /*
        中序遍历
     */
    public void inFixOrder(){

        if (this.left != null){
            this.left.inFixOrder();
        }

        System.out.println(this.value);

        if (this.right != null){
            this.right.inFixOrder();
        }

    }


    public Node search(int value){

        if (this.value == value){
            return this;
        }

        else if (this.left != null && value < this.value){
            return this.left.search(value);
        }
        else if (this.right != null && value >= this.value){
            return this.right.search(value);
        }else {
            return null;
        }

    }

    public Node searchParent(int value){

        //如果当前节点是要删除节点的父节点，则直接返回当前节点
        if (this.left != null && this.left.value == value ||
                this.right != null && this.right.value == value){
            return this;
        }else {
            //如果要查找的节点的值小于当前节点的值，并且当前节点的左节点不为空
            if (value < this.value && this.left!= null){

                return this.left.searchParent(value);
            }
            //如果要查找的节点的值大于等于当前节点的值，并且当前节点的右节点不为空
            else if (value >= this.value && this.right != null){

                return this.right.searchParent(value);
            }
            else {
                return null;
            }

        }

    }

}
