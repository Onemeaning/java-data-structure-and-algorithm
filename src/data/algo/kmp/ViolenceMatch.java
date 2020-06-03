package data.algo.kmp;

/**
 * @author meanlam
 * @date 2020/6/2-9:58
 */
public class ViolenceMatch {

    public static void main(String[] args){


        String str1 = "dbaisjdaksifovasnfoas";
        String str2 = "ifova";

        System.out.println("index = " + violenceMatch(str1,str2));

    }

    /**
     * 暴力匹配算法,判断 str1 中是否包含 str2
     * @param str1 原始字符串
     * @param str2 正则字符串
     * @return 匹配位置的索引 ，找不到则返回-1
     */
    public static int violenceMatch(String str1, String str2){

      char[] s1 = str1.toCharArray();
      char[] s2 = str2.toCharArray();

      int s1Len = s1.length;
      int s2Len = s2.length;

      int index1 = 0;
      int index2 = 0;

      while (index1 < s1Len && index2 < s2Len){

          if (s1[index1] == s2[index2]){
              index1++;
              index2++;

          }else { // 匹配失败，回溯重新匹配

              index1 = index1 - (index2-1);
              index2 = 0;
          }
      }

      if (index2 == s2Len){
          return index1 - index2;
      }
      else
          return -1;

    }

}
