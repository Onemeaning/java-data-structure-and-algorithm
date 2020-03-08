package tencen;

public class Test1 {

    public static void main(String[] args){

        String ss = "scnaskcschcasjdksach";
//        System.out.println(ss.contains("ch"));


        String newString =  ss.replaceAll("ch","char");
//        System.out.println(ss.replace("ch","char"));
        System.out.println(newString);
    }
}
