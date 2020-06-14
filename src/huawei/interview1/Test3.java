package huawei.interview1;

public class Test3 {

    public static void main(String[] args){

       String str = "let's go to school";
       System.out.println(reverseWord(str));

    }

    public static String reverseWord(String str){

        String[] words = str.split(" ");
        StringBuilder res = new StringBuilder();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {

            res.append(builder.append(words[i]).reverse().toString() + " ");
            builder.delete(0,builder.length());
        }
        return res.toString().trim();
    }
}
