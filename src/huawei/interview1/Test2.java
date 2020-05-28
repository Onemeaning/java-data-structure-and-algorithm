package huawei.interview1;

import java.util.*;

public class Test2 {

    public static void main(String[] args){

//        System.out.println(selectNums("3d50J, Aa3"));

//        String s = "5a 12 5b ba 34 5b bb 88 05 5a 75 cd bb 62 5a 34 cd 78 cc da fb 06 5a";
//        System.out.println(protocolCheck(s));

//        System.out.println(getCombinationCounts("baac"));

//        String[] array = new String[]{"1","2","3","4"};
//        listAll(Arrays.asList(array), "");

        System.out.println(removeDicChar("abaccd",2));
    }



    //--------------------------------------------
    public static String selectNums(String strs){

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < strs.length(); i++) {
            char ch = strs.charAt(i);
            if ( ch >='0' && ch <= '9'){
                res.add(Integer.parseInt(ch+"") );
            }
        }

        Collections.sort(res);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            builder.append(res.get(i));
        }

        return builder.toString();
    }


    public static String protocolCheck(String ori){

        String[] messages = ori.trim().split("5a");
        StringBuilder res = new StringBuilder();

        for (int i = 1; i < messages.length; i++) {

            String message = messages[i];

            message = message.replaceAll("5b ba","5a");
            message =  message.replaceAll("5b bb","5b");

            String[] temp = message.trim().split(" ");
            int len = temp.length;

            int num = Integer.parseInt(temp[len-1].charAt(0)+"")*16 + Integer.parseInt(temp[len-1].charAt(1)+"");

            if (len-1 == num){
                res.append("5a");
                res.append(messages[i]);
            }

        }

        res.append("5a");

        return res.toString();
    }

    public static void listAll(List candidate, String prefix) {
        if(prefix.length()==4){
            System.out.println(prefix);
        }
        for(int i=0;i<candidate.size();i++) {
            List tmp = new LinkedList(candidate);
            listAll(tmp, prefix + tmp.remove(i));//函数中的参数从右边开始解析
        }
    }


    public static int getCombinationCounts(String s){

        int n = s.length();
        Map<Character,Integer> data = new HashMap<>();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (data.get(ch) == null)  data.put(ch,1);

            else  data.put(ch,data.get(ch)+1);

        }

        long temp = 1;

        for (Map.Entry<Character,Integer> entry : data.entrySet()){
            temp *= getFactorial(entry.getValue());
        }

        return (int) (getFactorial(n) / temp);


    }

    private static int getFactorial(int num){
        if (num == 0 || num == 1) return 1;

        else return num * getFactorial(num-1);
    }


    //---------------------------------------------------------------

    /**
     *
     * @param ori 原始字符串
     * @param k 删除字符的个数
     * @return 字符升序字符串
     */
    public static String removeDicChar(String ori,int k){

        for (int i = 0; i < k; i++) {
            StringBuilder builder = new StringBuilder();
            boolean flag = false; //没有找到

            builder.append(ori.charAt(0));
            for (int j = 1; j < ori.length(); j++) {
                char ch = ori.charAt(j);
                if (ch > ori.charAt(j-1)){

                    if (!flag){
                        flag = true;
                        continue;
                    }
                    else {
                        builder.append(ch);
                    }

                }else{
                    builder.append(ch);
                }
            }

            ori = builder.toString();


        }

        return ori;
    }

}
