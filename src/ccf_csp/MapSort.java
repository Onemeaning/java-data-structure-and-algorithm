package ccf_csp;

import java.util.*;
/*

这个类是一个关于Map排序的示例
1) 根据Key进行排序
2) 根据Value进行排序

测试样例：
d k
e f
s j
a e
p g
end
 */
public class MapSort {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String buffer = "";
        Map<String,String> originMap = new HashMap<>();
        while (!(buffer = scanner.nextLine()).equals("end"))
        {
            String[] data = buffer.trim().split(" ");
            originMap.put(data[0],data[1]);
        }

//        Map<String,String> resultMap =  sortedBykey(originMap);
        Map<String,String> resultMap =  sortedByvalue(originMap);



        for(Map.Entry<String,String> entrySet:resultMap.entrySet())
        {
            System.out.println(entrySet.getKey() + ":" + entrySet.getValue());
        }




    }

    private static Map<String, String> sortedByvalue(Map<String, String> originMap) {
        if (originMap==null || originMap.isEmpty()){
            return originMap;
        }

        Map<String,String> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String,String>> listEntry = new ArrayList<>(originMap.entrySet());
        Collections.sort(listEntry,new MyComparatorByValue());

        Iterator<Map.Entry<String,String>> itr = listEntry.iterator();
        Map.Entry<String,String> tempEntry = null;
        while (itr.hasNext()){
            tempEntry = itr.next();
            sortedMap.put(tempEntry.getKey(),tempEntry.getValue());
        }
        return  sortedMap;

    }

    private static Map<String, String> sortedBykey(Map<String, String> originMap) {

        if (originMap==null || originMap.isEmpty()){
            return originMap;
        }

        Map<String,String> sortedMap = new TreeMap<>(new MyComparatorByKey());
        sortedMap.putAll(originMap);
        return sortedMap;

    }


}

class MyComparatorByKey implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

class MyComparatorByValue implements Comparator<Map.Entry<String,String>>{


    @Override
    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}