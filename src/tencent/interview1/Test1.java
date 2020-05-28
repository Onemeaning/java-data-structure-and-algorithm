package tencent.interview1;

import java.util.*;

public class Test1 {

    public static void main(String[] args) {

        List<String> strs = new ArrayList<>();
        strs.add("81");
        strs.add("9");
        strs.add("6");
        strs.add("35");
        strs.add("3");
        strs.add("60");
        strs.add("30");

        Collections.sort(strs,new SortedByKeyComparator());

        for(String item : strs){
            System.out.println(item);
        }

    }

}

class SortedByKeyComparator implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {

        if (o2.length() != o1.length())
        {
            if (o1.endsWith("0")){
                return 1;
            }
            else
                return  o2.compareTo(o1);
        }

        else
            return  o2.compareTo(o1); //降序
    }
}