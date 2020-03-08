package data.structures.linkedlist;

public class CircleLinkedListDemo {
    public static void main(String[] args){

        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(5);
        circleLinkedList.showBoys();

        System.out.println("测试小孩出圈的顺序是否正确：");
        circleLinkedList.outOfCircle(1,2,5);
    }
}

class CircleLinkedList{

    BoyNode first = null;
    BoyNode curBoy = null;

    /**
     * 产生一个连续编号的n个节点
     * @param n
     */
    public void add(int n){

        if (n<1){
            System.out.println("输入节点的个数有误！");
            return;
        }

        for (int i = 1; i <= n;i++){

            BoyNode boyNode = new BoyNode(i);
            if (i==1){
                first = boyNode;
                first.setNext(first);//构成一个环
                curBoy = first;
            }else {
                curBoy.setNext(boyNode);
                boyNode.setNext(first);//构成一个环
                curBoy = curBoy.getNext();
            }

        }
    }


    /**
     * 根据报数得到出圈的顺序
     * @param startNum 开始报数的小孩的索引
     * @param countNum 需要的报的数
     * @param boysNum 玩游戏小孩的数量
     */
    public void outOfCircle(int startNum,int countNum,int boysNum){

        if (startNum < 1 || countNum > boysNum || boysNum < 1 ){
            System.out.println("参数输入有误，请重新输入：");
            return;
        }
        BoyNode helper = first;
        while (helper.getNext() != first){
            helper = helper.getNext();
        }

        for (int i = 0; i < startNum-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (helper != first ){

            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            System.out.printf("出圈小孩的编号为[%d]\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后一个留在圈中的小孩的编号为[%d]\n",first.getNo());



    }

    /**
     * 遍历整个循环链表；
     */
    public void showBoys(){

        if (first.getNext() == null){
            System.out.println("链表为空");
            return;
        }

        curBoy = first;
        while (true){

            System.out.printf("当前节点的编号为[%d]\n",curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            else {
                curBoy = curBoy.getNext();
            }

        }

    }



}

class BoyNode{

    private int no;
    private BoyNode next;

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

}