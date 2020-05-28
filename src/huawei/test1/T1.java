package huawei.test1;


import java.util.*;

public class T1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        MyLinkedList list = new MyLinkedList();
        Set<Integer> sets = new LinkedHashSet<>();
        for (int i = 0; i < input.length; i++) {

            int temp = Integer.parseInt(input[i]);
            sets.add(temp);
        }

        for (Integer integer : sets){
            list.add(integer);
        }

        list.list();
    }

}

class MyLinkedList{

    private final MyNode root = new MyNode(-1);

    public void add(int val){

        MyNode temp = root;
        while (temp.next!=null){
            temp = temp.next;
        }
        for (int i = 0; i < 3; i++) {
            MyNode node = new MyNode(val);
            temp.next = node;
            temp = temp.next;
        }

    }

    public void list(){
        MyNode temp = root.next;
        while (temp !=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }

}

class MyNode{

    int val;
    MyNode next;

    public MyNode(int val) {
        this.val = val;
    }
}
