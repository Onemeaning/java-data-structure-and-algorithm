package collections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args){
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();

        map.put("wangminglin",22);
        map.put("wangsi",24);


        System.out.println(map.get("wangminglin"));
    }






}
