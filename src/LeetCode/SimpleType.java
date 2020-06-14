package LeetCode;

import java.util.*;

public class SimpleType {

    public static void main(String[] args){

//        System.out.println(isPalindrome(121));

//        System.out.println(romanToInt("MCMXCIV"));

//        System.out.println(longestCommonPrefix1(new String[]{"flower","flow","floweight"}));

//        System.out.println(isValid("){"));

//          ListNode l1 = new ListNode(1);
//          l1.next = new ListNode(2);

//        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,3,3,3,4,5}));

//        System.out.println(divide(-2147483648,1));

//           System.out.println(myPow(2,-2));

//        System.out.println(removeElement(new int[] {0,1,2,2,3,0,4,2},2));

//        System.out.println(strStr("mississippi","pi"));

//            System.out.println(searchInsert(new int[]{1,3,5,6},6));

//        System.out.println(countAndSay(7));

//        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));

//        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));

//        System.out.println(addBinary("1111","1111"));

//            System.out.println(mySqrt(0));

//        System.out.println(climbStairs(3));

//        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));


        System.out.println(getIndex(new int[] {1,2,3,1}));
        System.out.println(getIndex(new int[] {3,4,5,6,1,2}));
        System.out.println(getIndex(new int[] {3,3,3,1,2,3}));
        System.out.println(getIndex(new int[] {5,6,1,2,3,4}));
        System.out.println(getIndex(new int[] {6,1,2,3,4,5}));
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param arr
     * @return
     */
    public static int getIndex(int[] arr){

        int temp = arr[0];// 因为是递增，所以arr[0]是第一段中最小的，找到不比它大的值就OK
        int left = 0;
        int right = arr.length-1;
        int mid;

        while (left <= right){

            mid = (left + right)/2;

            if (arr[mid] == temp ){

                return temp;
            }

             else if (arr[mid] > temp ){

                left = mid+1 ;
            }

            else if (arr[mid] < temp ){

                right = mid-1;
                temp = arr[mid];
            }
        }

        return temp;

    }


    /**
     * 回文数
     * @param x
     * @return 判断一个数是否为回文数，是就返回true
     */

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x!=0)){
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum){

            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        return (reverseNum == x) || (reverseNum / 10 == x);

    }

    public static boolean isPalindrome1(int x) {

        StringBuilder builder = new StringBuilder(x+"");
        builder.reverse();
        String revStr = builder.toString();
        if (revStr.equals(x+"")){
            return true;
        }
        else {
            return false;
        }

    }

    //------------------------------------------------------------

    /**
     * 罗马数字转换成整数：
     * @param s
     * @return
     */
    public static int romanToInt(String s) {

        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == 'I'){ //1

                if ((i+1) < chars.length && chars[i+1] == 'V'){
                    i++;
                    res += 4;
                }
                else if ((i+1) < chars.length && chars[i+1] == 'X'){
                    i++;
                    res += 9;
                }
                else {
                    res += 1;
                }

            }else if (chars[i] == 'V'){ //5

               res += 5;
            }
            else if (chars[i] == 'X'){ //10

                if ((i+1) < chars.length && chars[i+1] == 'L'){
                    i++;
                    res += 40;
                }
                else if ((i+1) < chars.length && chars[i+1] == 'C'){
                    i++;
                    res += 90;
                }
                else {
                    res += 10;
                }
            }
            else if (chars[i] == 'L'){ // 50
                res += 50;
            }
            else if (chars[i] == 'C'){ // 100

                if ((i+1) < chars.length && chars[i+1] == 'D'){
                    i++;
                    res += 400;
                }
                else if ((i+1) < chars.length && chars[i+1] == 'M'){
                    i++;
                    res += 900;
                }
                else {
                    res += 100;
                }

            }else if (chars[i] == 'D'){ // 500
                res += 500;

            }else if (chars[i] == 'M'){ //1000

                res += 1000;
            }

        }
        return res;
    }

    //--------------------------------------------------

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){

            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j ++) {

                if (i == strs[j].length() || strs[j].charAt(i) != c) // i == strs[j].length() : 说明已经到了最短字符串的末尾；
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0){
            return "";
        }
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {

            int tempLen = strs[i].length();
            if (tempLen < minLen){
                minLen = tempLen;
            }
        }

        boolean flag = true; //指示所有字符串是存在公共子字符串的；

        for (int column = 0; column < minLen; column++) {//遍历列，指的是遍历每个字符

            for (int rows = 1; rows < strs.length; rows++) { // 遍历行，指的是遍历不同的字符串

                if (strs[0].charAt(column) != strs[rows].charAt(column)){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                return strs[0].substring(0,column);
            }
        }
        return strs[0].substring(0,minLen);
    }
    //--------------------------------------------------

    /**
     * LeetCode 20 ：有效括号
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        if (s == "" || s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack1 = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);

            if (ch == '{' || ch == '[' || ch == '('){
                stack1.push(ch);
            }
            else {

                if (stack1.isEmpty()){
                   return false;
                }
                Character temp = stack1.pop();
                switch (ch){

                    case '}':
                        if (temp != '{') flag = false; break;

                    case ']':
                        if (temp != '[') flag = false; break;

                    case ')':
                        if (temp != '(') flag = false; break;

                }
            }
        }

        if (!stack1.isEmpty()){
            flag = false;
        }

        return flag;

    }

    //-------------------------------------------------------

    /**
     * LeetCode 21： 合并两个有序的链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(-1);
        ListNode listNode = root;

        while (l1 != null && l2 != null){

           if (l1.val <= l2.val){
               listNode.next = l1;
               l1 = l1.next;
           }
           else {
               listNode.next = l2;
               l2 = l2.next;
           }

            listNode = listNode.next;
        }

//        while (l1 != null){
//            listNode.next = l1;
//            listNode = listNode.next;
//            l1 = l1.next;
//        }
//
//        while (l2 != null){
//            listNode.next = l2;
//            listNode = listNode.next;
//            l2 = l2.next;
//        }

        listNode.next = (l1 == null ? l2 : l1);

        return root.next;
    }

    //--------------------------------------------------

    /**
     * LeetCode 26 ：删除排序数组中重复项
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        int temp=nums[0];
        int  adress=1;

        for (int i = 1; i < nums.length; i++) {

           if(nums[i]==temp){
               i++;
           }
            else{
             temp=nums[i];
             nums[adress] =nums[i];
             adress++;
           }

            i--;

        }
        return adress;
    }


    //---------------------------------------------------------
    /**
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {

        //记负数的个数
        int i=0;

        // 商
        long temp_res = 1;
        long result = 0;

        long temp_dividend = dividend;
        long temp_divisor = divisor;


        //处理可能溢出的情况
        if (divisor == 0 || (dividend == -2147483648 && divisor == -1)){
            return  Integer.MAX_VALUE;
        }

        if(dividend < 0) {
            temp_dividend = Math.abs(temp_dividend);
            i++;
        }

        if(divisor < 0) {
            temp_divisor = Math.abs(temp_dividend);
            i++;
        }

        if (temp_divisor > temp_dividend){
            return 0;
        }
       long  t_divisor = temp_divisor;


       while((temp_divisor << 1) < temp_dividend){ //找到不大于被除数的最大整数

           temp_divisor = temp_divisor << 1;
           temp_res  = temp_res << 1;
       }


       while (temp_dividend >= t_divisor){ //之所以取等号，是因为可能会存在整除的情况；

           temp_dividend -= temp_divisor;
           result += temp_res;

           while (temp_divisor > temp_dividend){

               temp_divisor  = temp_divisor >> 1;
               temp_res = temp_res >> 1;
           }
       }

       if(i==1){ //只有一个负号，说明结果是负数
          result = -result;
       }

       return (int) result;
    }

    //----------------------------------------------------------

    /**
     *LeetCode 50 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {

        boolean negtive =  false;

        long abs_n = n;
        if (n < 0){
            negtive = true;
            abs_n = Math.abs(abs_n);
        }

        double res = fastPow(x,(int) abs_n);

        if (negtive){
            return 1/res;
        }
        else
            return res;
    }

    private static double fastPow(double x, int n){

       if (n == 0){
           return 1.0;
       }

       double halfVal = fastPow(x, n / 2);

       if (n % 2 == 0){

           return halfVal * halfVal;
       }else {

           return halfVal * halfVal * x;
       }
    }

    //----------------------------------------------

    /**
     * LeetCode 27 移除元素
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        int curIndex = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val){ //找到与目标值相等的值；
                continue;
            }
            else {
                nums[curIndex] = nums[i];
                curIndex++;
            }

        }
        return curIndex;
    }

    //--------------------------------------------------------

    /**
     * LeetCode 28 实现 strStr() 函数。
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if (needle.equals("") || needle.equals(haystack)){
            return 0;
        }
        if (haystack.equals("")){
            return -1;
        }

        int size = needle.length();
        Map<String,Integer> data = new HashMap<>();
        for (int i = 0; i < (haystack.length() - size+1); i++) {

            String temp = haystack.substring(i,i+size);
            System.out.println(temp);
            data.putIfAbsent(temp,i);

        }

       for (Map.Entry<String,Integer> entry : data.entrySet()){

           if (entry.getKey().equals(needle)){
               return entry.getValue();
           }

       }
       return -1;

    }

    //---------------------------------------------

    /**
     * leetcode:35 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while (left <= right){

            int index = (left + right) / 2;

            if (nums[index] == target){
                return index;
            }

            if (nums[index] < target){
                left = index+1;
            }

            else {
                right = index-1;
            }

        }

        return left;
    }

    //------------------------------------------------------------

    /**
     * leecode 38 外观数列
     * @param n
     * @return
     */
    public static String countAndSay(int n) {

        if (n == 1){
            return "1";
        }

        else {
            String temp  = countAndSay(n-1);
            StringBuilder builder = new StringBuilder();
            int count ;

            for (int i = 0; i < temp.length(); i++) {

                char c = temp.charAt(i);
                count = 0;
                while (i< temp.length() && temp.charAt(i)== c){
                    count++;
                    i++;
                }
                builder.append(count);
                builder.append(c);
                i--;

            }

            return builder.toString();
        }

    }

    //-----------------------------------------------------

    /**
     * leetcode 53 最大子序和： 使用动态规划的方法求解（DP）
     * @param nums
     * @return
     */
    /*public static int maxSubArray(int[] nums) {

       int size = nums.length;
       int[] dp = new int[size]; //用于存储以索引i结尾的连续子数组的最大和

       dp[0] = nums[0];//初始化
       int ans = dp[0];

       for (int i = 1; i < size ; i++) {
          dp[i] =  Math.max(dp[i-1] + nums[i],nums[i]);
          ans = Math.max(dp[i],ans);
       }

//       System.out.println(Arrays.toString(dp));
      return ans;
    }*/

    //--------------------------------------------------------------

    /**
     * leetcode :58最后一个单词的长度
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {

        if (s==null || s.length() == 0){
            return 0;
        }
        String[] strings = s.trim().split(" ");
        return strings[strings.length-1].length();

    }

    //---------------------------------------------------

    /**
     * leetcode 66 加一：
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

      int len = digits.length;
        for (int i = len-1; i >=0 ; i--) {

            digits[i]++;
            digits[i] %= 10;

            if (digits[i] != 0) return digits;
        }

        int[] res = new int[len+1];
        res[0] = 1;
        return res;

    }

    //-------------------------------------------------------

    /**
     * leetcode 67 : 二进制求和；
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {

        int index_b = b.length()-1;
        int index_a = a.length()-1;
        StringBuilder builder = new StringBuilder();
        int diff = Math.abs(index_a - index_b);

        for (int i = 0; i < diff; i++) {
            builder.append(0);
        }

        if (index_a > index_b)
            b = builder.toString() + b;
        else
            a = builder.toString() + a;

        int size = a.length()-1;
        builder.delete(0,diff);

        int flag = 0;
        while (size >=0){

           int temp_res = flag + Integer.parseInt(a.charAt(size)+"") +
                   Integer.parseInt(b.charAt(size)+"");

           if (temp_res >= 2)
               flag = 1;
           else
               flag = 0;

           builder.append(temp_res % 2);
           size--;

           if (size<0 && flag ==1){
               builder.append(1);
           }

        }


        return builder.reverse().toString();
    }

   //*******************************************************************************

    /**
     * leetcode 69 求平方根； 牛顿迭代法
     * @param x
     * @return
     */
    public static int mySqrt(int x) {

        HashSet<Character> set = new HashSet<>();

        double res = 2;
        double init = 0;

        while (Math.abs(res - init) > 0.1){

            init = res;
            res = init - (init * init - x) /(2 * init);

        }

        return (int) res;

    }

    //------------------------------------------------

    /**
     * leetCode 70 爬楼梯；
     * @param n
     * @return
     */
    public static int climbStairs(int n) {

        if (n == 1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {

            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];

    }

    //---------------------------------------------------------
    public static ListNode deleteDuplicates(ListNode head) {

       ListNode cur = head;
       int val = cur.val;

       while (cur.next!=null){

           if (cur.next.val == val){
               cur.next = cur.next.next;
           }
           else {
               cur = cur.next;
               val = cur.val;
           }

       }

       return head;
    }

    //------------------------------------------------------------------

    /**
     * leetcode 88 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m+n];
        int index_m = 0,index_n = 0,index = 0;

        while (index_m < m && index_n < n){

            if (nums1[index_m] <= nums2[index_n]){
                temp[index++] = nums1[index_m++];
            }else {
                temp[index++] = nums2[index_n++];
            }
        }

        while (index_m < m){
            temp[index++] = nums1[index_m++];
        }

        while (index_n < n){
            temp[index++] = nums2[index_n++];
        }

        System.arraycopy(temp,0,nums1,0,m+n);
    }

    //-------------------------------------------------------------

    /**
     * leetcode 100: 相同的数：DFS 宽度优先搜索
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q== null ){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        if (p.val != q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    //----------------------------------------------------------

    /**
     * leetcode101: 对称二叉树  中序遍历
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;

            if (t1 == null || t2 == null)  return false;

            if (t1.val != t2.val) return false;

            queue.add(t1.left);
            queue.add(t2.right);

            queue.add(t1.right);
            queue.add(t2.left);

        }

        return true;

    }

    //------------------------------------------------------

    /**
     * leetcode 104. 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        int maxDep = 1;

        if (root.left != null)
            maxDep =  Math.max(maxDep,maxDepth(root.left)+1);

        if (root.right != null)
            maxDep =  Math.max(maxDep,maxDepth(root.right)+1);

       return maxDep;
    }


    //----------------------------------------------------

    /**
     * 107. 二叉树的层次遍历 II
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        if (root == null){
            return lists;
        }

        queue.add(root);
        TreeNode last = root;
        TreeNode nlast = null;


        while (!queue.isEmpty()){

            TreeNode cur = queue.poll();
            tempList.add(cur.val);

            if (cur.left!=null)
            {
                queue.add(cur.left);
                nlast = cur.left;
            }

            if (cur.right!=null)
            {
                queue.add(cur.right);
                nlast = cur.right;
            }

            if (cur == last){
                lists.add(0,tempList);
                tempList = new ArrayList<>();
                last = nlast;
            }

        }

        return lists;
    }

    /**
     * leetcode: 108. 将有序数组转换为二叉搜索树,(高度平衡)
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {

       TreeNode root = helper(nums,0,nums.length-1);
       return root;
    }

    private static TreeNode helper(int[] nums, int left, int right){

        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid -1);
        root.right = helper(nums,mid+1,right);

        return root;
    }


    //-----------------------------------------------------------------------

    /**
     * leetcode 110 平衡二叉树
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {

        return false;
    }

    /**
     * leetcode 111. 二叉树的最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        if (root.left == null && root.right==null){
            return 1;
        }

        int minDep = Integer.MAX_VALUE;

        if (root.left!=null)
            minDep = Math.min(minDep,minDepth(root.left)+1);

        if (root.right!=null)
            minDep = Math.min(minDep,minDepth(root.right)+1);

        return minDep;
    }

    //----------------------------------------------------------------

    /**
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;

        sum -= root.val;

        if (root.left==null && root.right==null) return sum==0;

        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }

    //----------------------------------------------------------------------

    /**
     * leetcode 118 杨辉三角；
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        if (numRows == 0) return res;

        row.add(1);
        res.add(row);
        List<Integer> pre = null;

        for (int i = 1; i < numRows; i++) {
            pre = res.get(i - 1);
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {

               if (j == 0) row.add(pre.get(j));
               else if (j == i) row.add(pre.get(j-1));
               else row.add(pre.get(j-1),pre.get(j));

            }
            res.add(row);

        }
        return res;
    }

    /**
     * leetcode 119. 杨辉三角 II
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();
        long preNum = 1;
        int n = rowIndex;
        res.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            preNum = preNum + (n-i+1)/i;
            res.add((int)preNum);
        }

        return res;

    }

    //-----------------------------------------------------------------

    /**
     * int k = 1;  //允许的交易次数;
     * int n = prices.length; //交易的时间
     * int states = 2; //交易状态，0：表示手中不持有股票状态，1：表示手中持有股票的状态
     * int[][][]  maxProfits = new int[n][k][states]; //第n天的时候还可以进行k次交易时，此时手中股票的状态为state时的收益情况；
     *
     * dp[i][k][0] = max{ dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
     *
     * dp[i][k][1] = max{ dp[i-1][k][1], dp[i-1][k-1][0] - prices[i] }
     *
     *
     * leetcode 121. 买卖股票的最佳时机
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

//        int[][] dp = new int[prices.length][2];
//
//        for (int i = 0; i < prices.length; i++) {
//
//            if (i == 0){
//
//                dp[i][0] = Math.max(0, Integer.MIN_VALUE + prices[i]);
//                dp[i][1] = Math.max(Integer.MIN_VALUE, 0 - prices[i]);
//            }
//            else{
//
//                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i-1][1], 0 - prices[i]);
//            }
//
//        }
//        return dp[prices.length-1][0];

        int withoutStock = 0;
        int withStock = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {

            withoutStock = Math.max(withoutStock, withStock + prices[i]);

            withStock = Math.max(withStock, 0 - prices[i]);

        }

       return withoutStock;
    }



}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}


//  Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
