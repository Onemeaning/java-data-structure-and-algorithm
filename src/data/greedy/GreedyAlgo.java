package data.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * 贪婪算法 解决地区覆盖问题
 * @author meanlam
 * @date 2020/6/3-14:51
 */
public class GreedyAlgo {

    public static void main(String[] args){


        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("北京");
        hashSet2.add("广州");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        
        HashSet<String> allAreas = new HashSet<>();
        allAreas.addAll(hashSet1);
        allAreas.addAll(hashSet2);
        allAreas.addAll(hashSet3);
        allAreas.addAll(hashSet4);
        allAreas.addAll(hashSet5);
        
        System.out.println("allAreas = "+allAreas);


        ArrayList<String> selects = new ArrayList<>(); //保存选中的结果；
        
        String maxKey = ""; // 记录每次循环过后，覆盖区域最多的key

        while (allAreas.size() != 0){

            maxKey = null;

            for(String key : broadcasts.keySet()){

                HashSet<String> broadcastArea = broadcasts.get(key);
                broadcastArea.retainAll(allAreas);

                if (broadcastArea.size() > 0 && (maxKey == null || broadcastArea.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }

            if (maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }
        
        System.out.println("selects = " + selects);

    }




}


