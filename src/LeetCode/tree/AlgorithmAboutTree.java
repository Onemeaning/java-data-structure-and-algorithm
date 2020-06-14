package LeetCode.tree;

public class AlgorithmAboutTree {

    public static void main(String[] args){

    }


    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

       return Math.abs(height(root.left) - height(root.right)) <= 1
               && isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode root){

        if (root == null)
            return 0;

        return Math.max(root.left == null ? 0:height(root.left),root.right == null?0:height(root.right))+1;

    }


}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }