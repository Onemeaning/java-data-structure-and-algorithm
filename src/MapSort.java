import java.util.*;

public class MapSort {
    public static void main(String[] args){

        Map<String,String> map = new TreeMap<>();

        map.put("a", "1");
        map.put("b", "3");
        map.put("c", "2");
        map.put("a1", "5");
        map.put("a2", "7");
        map.put("a3", "9");


        //原始没有经过排序的map；
        for (Map.Entry<String,String> entry: map.entrySet())
        {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-----------------------------------------------");

        //进过key排序后的
        Map<String,String> sortedByKey = sortedByKey(map);
        for (Map.Entry<String,String> entry: sortedByKey.entrySet())
        {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //经过Value排序后的
        Map<String,String> sortedByValue = sortedByValue(map);
        System.out.println("-----------------------------------------------");

        //进过key排序后的
        for (Map.Entry<String,String> entry: sortedByValue.entrySet())
        {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }


    private static Map<String, String> sortedByKey(Map<String, String> map) {

       Map<String,String> tempMap = new TreeMap<>(new SortedByKeyComparator());

       tempMap.putAll(map);

       return  tempMap;

    }


    private static Map<String, String> sortedByValue(Map<String, String> map) {

        Map<String,String> tempMap = new LinkedHashMap<>();

        List<Map.Entry<String,String>> entriesList = new ArrayList<>();

        for (Map.Entry<String,String> entry : map.entrySet())
        {
            entriesList.add(entry);
        }

        Collections.sort(entriesList,new SortedByValueComparator());

        //增强for循环遍历List ，这里也可以换成Iterator迭代遍历

        /**
         * 总结一下：
         * 1、什么时候用foreach 和 Iterator ，什么时候用for循环？
         *
         * A、当存储数据为顺序存储的时候，for比前面两种方法速度要快；
         * B、当存储数据为链接式存储的时候，那么前面两种的方法比for快的多；
         * C、foreach 和 Iterator 效率相近；
         *
         *
         * 2、Iterator 怎么使用 ，它只是一个接口，具体的实现类有Collection实现
         *
         *      eg： Iterator ite = collection.iterator();
         *           Iterator listIte = list.listIterator();//可以双向遍历
         */
        for (Map.Entry<String,String> entry : entriesList)
        {
            tempMap.put(entry.getKey(),entry.getValue());
        }

        return tempMap;

    }


}

class SortedByKeyComparator implements Comparator<String>
{


    @Override
    public int compare(String o1, String o2) {

//        return o1.compareTo(o2);//升序

        return  o2.compareTo(o1); //降序
    }
}

class SortedByValueComparator implements Comparator<Map.Entry<String,String>>
{

    @Override
    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {

//        return o1.getValue().compareTo(o2.getValue()); //升序

        return o2.getValue().compareTo(o1.getValue()); //降序
    }
}