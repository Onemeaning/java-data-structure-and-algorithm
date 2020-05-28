package huawei.test1;


import java.util.Scanner;
import java.util.Stack;

public class T3 {

   static int sumVal = 0;
   static int tempVal = 0;
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // -1(3(3,6),2(1,5))
        //-1(3,2(1,5))


        MyTree myTree = new MyTree();
        TreeNode root = myTree.createBinTreeByGLists(str);
        myTree.setRoot(root);

        //前序遍历
        myTree.preOrder(root);

        System.out.println(maxPath(root));

    }

    private static int maxPath(TreeNode root){

        if (root == null){
            return 0;
        }
        tempVal += root.val;

        //对于叶子节点的处理;
        if (root.left == null && root.right == null){
            sumVal = Math.max(sumVal,tempVal);
            tempVal -= root.val;//叶子节点比较结束之后，需要减掉，

            System.out.println("sumVal =" + sumVal +",tempVal = " + tempVal );
        }

        if (root.left != null){

            maxPath(root.left);
        }

        if (root.right != null){

            maxPath(root.right);

            if (root.left!=null){ //把左子节点去掉；
                tempVal-=root.val;
            }
        }

        return sumVal;
       }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class MyTree{

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }


    public TreeNode createBinTreeByGLists(String str){

        int index = str.indexOf('(');
        TreeNode temp = null;
        TreeNode root = null;
        root = new TreeNode(Integer.parseInt(str.substring(0,index)));

        final int LEFT_CHILD = 1;
        final int RIGHT_CHILD = 2;

        Stack<TreeNode> stack = new Stack<>();
        int flag = 0;
        while (index < str.length()){

            char ch = str.charAt(index++);
            switch (ch){

                case '(':
                    stack.push(temp);
                    flag = LEFT_CHILD;
                    break;
                case ',':
                    flag = RIGHT_CHILD;
                    break;
                case ')':
                    stack.pop();
                    break;
                default:

                    StringBuilder builder = new StringBuilder();
                    builder.append(ch);
                    char curChar = str.charAt(index);
                    while (curChar < '9' && curChar > '0'){
                        index++;
                        builder.append(curChar);
                        curChar = str.charAt(index);
                    }
                    temp = new TreeNode(Integer.parseInt(builder.toString()));

                    if (stack.peek() == null){
                        stack.push(root);
                    }

                    switch (flag){

                        case LEFT_CHILD:
                            stack.peek().left = temp;
                            break;
                        case RIGHT_CHILD:
                            stack.peek().right = temp;
                            break;
                    }

            }

        }

        return root;
    }


    public void preOrder(TreeNode root){

        if (root == null){
            System.out.println("这是一颗空树");
            return;
        }
        System.out.println(root.val);
        if (root.left!=null) preOrder(root.left);
        if (root.right!=null) preOrder(root.right);
    }
}