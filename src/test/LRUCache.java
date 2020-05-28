package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private static final int MAXSIZE = 3;

    public LRUCache(){

        super(MAXSIZE,0.75f,true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAXSIZE;
    }

    public static void main(String[] args){

        LRUCache<Integer,Integer> cache = new LRUCache<>();
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);

        cache.get(1);
        cache.put(4,4);

        System.out.println(cache.keySet());
    }
}
