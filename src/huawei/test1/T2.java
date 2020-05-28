package huawei.test1;

import java.util.*;

public class T2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int maxBag = 0;
        int N = scanner.nextInt();

        Set<Integer> bags = new TreeSet<>();
        List<Node> lists = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int temp = scanner.nextInt();
            bags.add(temp);
            maxBag = (temp > maxBag) ? temp : maxBag;
        }

        for (int i = 0; i < N; i++) {

            int weight = scanner.nextInt();
            int value= scanner.nextInt();

            if (weight <= maxBag)
            {
                lists.add(new Node(weight,value));
            }

        }
        Collections.sort(lists, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.val - o1.val;
            }
        });
        int res = 0;
        for (Node node:lists){

            if (bags.isEmpty()){
                break;
            }
            for (Integer bag : bags){
                if (node.weight <= bag){
                    res += node.val;
                    bags.remove(bag);
                    break;
                }
            }
        }


        System.out.println(res);



    }

}

class Node{
    int weight ;
    int val ;

    public Node(int weight, int val) {
        this.weight = weight;
        this.val = val;
    }
}