package data.structures.linkedlist;

public class LinkedListDemo {
    public static void main(String[] args){

        HeroNode hero1 = new HeroNode(1,"Tom1");
        HeroNode hero2 = new HeroNode(2,"Tom2");
        HeroNode hero3 = new HeroNode(3,"Tom3");
        HeroNode hero4 = new HeroNode(4,"Tom4");

        HeroNode hero5 = new HeroNode(5,"Tom5");
        HeroNode hero6 = new HeroNode(6,"Tom6");
        HeroNode hero7 = new HeroNode(7,"Tom7");
        HeroNode hero8 = new HeroNode(8,"Tom8");


        LinkedList linkedList = new LinkedList();
        linkedList.addById(hero4);
        linkedList.addById(hero1);
        linkedList.addById(hero7);
        linkedList.addById(hero6);
//      linkedList.addById(hero5);
        linkedList.list();


        LinkedList linkedList2 = new LinkedList();
        linkedList2.addById(hero5);
        linkedList2.addById(hero3);
        linkedList2.addById(hero8);
        linkedList2.addById(hero2);
        System.out.println("linkedList2的遍历结果");
        linkedList2.list();



//        System.out.println(AboutLinkedListQues.getNodeNums(linkedList));

//        System.out.println(AboutLinkedListQues.getNode(linkedList,3).toString());

//        System.out.println("==================================");
//        AboutLinkedListQues.reverseLinkedList(linkedList);
//        linkedList.list();

//         AboutLinkedListQues.reversePrintLinkedList(linkedList);

        LinkedList li = AboutLinkedListQues.mergerLinkedListByOrder(linkedList, linkedList2);
        System.out.println("合并后的结果");
        li.list();
    }
}

class LinkedList{

    private final HeroNode head = new HeroNode(0,"");

    public HeroNode getHead() {
        return head;
    }

    //按照ID号码从小到大的顺序进行添加
    public void addById(HeroNode node){

        HeroNode temp = head;

        while (temp.next != null){

            if (temp.next.id == node.id){
                System.out.println("ID:" + node.id + "添加失败，ID重复");
                return;
            }

            //查找并添加，在链表的中间位置添加
            if (temp.next.id >= node.id){
                node.next = temp.next;
                temp.next = node;
                break;
            }

            temp = temp.next;

        }


       if (temp.next == null){

           temp.next = node;
        }


    }


    public void list(){
        if (head.next == null){
            return;
        }
        HeroNode temp = head;
        while ((temp = temp.next) != null){

            System.out.println(temp.toString());

        }
    }


}





class HeroNode{

    int id;
    String name;
    HeroNode next;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}