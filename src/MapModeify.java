import java.util.HashMap;
import java.util.Map;

public class MapModeify {


    public static void main(String[] args){

        Map<Integer,Map<Integer,Integer>> goodstTypes = new HashMap<>();


        Map<Integer,Integer> good = new HashMap<>();
        for (int i = 0; i < 3; i++)
        {
            good.put(i+1,3-i);

        }


        for (int j = 0; j < 2; j++) {

            goodstTypes.put(j,new HashMap<>(good));

        }



        Map<Integer,Integer> aGood = goodstTypes.get(0);
        aGood.put(5,1);
        aGood.put(4,3);
        goodstTypes.put(0,aGood);



        for (Map.Entry<Integer,Map<Integer,Integer>> mapEntry : goodstTypes.entrySet())
        {

            for (Map.Entry<Integer,Integer> goodEntry : mapEntry.getValue().entrySet())
            {
                System.out.println(goodEntry.getKey() + " " + goodEntry.getValue());
            }
            System.out.println("-------------------------------");


        }

    }



}
