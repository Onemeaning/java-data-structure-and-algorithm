package data.algo.kmp;

import java.util.Arrays;

/**
 * 高效匹配算法 KMP
 *
 * @author meanlam
 * @date 2020/6/2-10:45
 */
public class KMPMatch {

    public static void main(String[] args){

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext(str2);
        System.out.println("next = " + Arrays.toString(next));


        System.out.println("index = " + kmpSearch(str1,str2,next));

    }

    /**
     * 部分匹配表；
     * @param des
     * @return
     */
    public static int[] kmpNext(String des){

        int[] next = new int[des.length()];

        next[0] = 0; // 表示：当只有一个字符的时候，它没有前缀，也没有后缀，此时前缀与后缀的部分匹配情况为0

        for (int i = 1,j = 0; i < des.length(); i++) {

            while (j > 0 && des.charAt(i) != des.charAt(j)){

                j = next[j-1]; // kmp算法的核心
            }

            if (des.charAt(i) == des.charAt(j)){
                j++;
            }

            next[i] = j;

        }

        return next;
    }

    /**
     *
     * @param str1 源字符串
     * @param str2 模式字符串
     * @param next 部分匹配表
     * @return -1 表示没有找到，其它值表示第一次匹配时的下标
     */
    public static int kmpSearch(String str1, String str2, int[] next){

        for (int i = 0,j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }

            if (j == str2.length())
                return i-j +1;
        }

        return -1;
    }

}
