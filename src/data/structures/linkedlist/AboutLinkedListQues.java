package data.structures.linkedlist;

import java.util.Stack;

public class AboutLinkedListQues {

    /**
     * 求一个单项链表的节点的个数
     */

    public static int getNodeNums(LinkedList linkedList){

        HeroNode temp = linkedList.getHead();

        int count = 0;

        while (temp.next!=null){

            count++;
            temp = temp.next;
        }

        return count;

    }

    /**
     * 查找单链表中倒数第k个节点的内容【新浪面试题】
     * @param k：表示倒数第k个节点
     * @return
     */
    public static HeroNode getNode(LinkedList linkedList, int k){

        HeroNode temp = linkedList.getHead();
        Stack<HeroNode> stack = new Stack<>();

        while (temp.next!=null){
            temp = temp.next;
            stack.push(temp);
        }

        while (k>1){
            stack.pop();
            k--;
        }

        return stack.pop();
    }


    /**
     * 【腾讯面试】 实现单链表的反转
     * @param linkedList
     */
    public static void reverseLinkedList(LinkedList linkedList){

        HeroNode temp = linkedList.getHead();
        Stack<HeroNode> stack = new Stack<>();

        while (temp.next!=null){
            temp = temp.next;
            stack.push(temp);
        }

        temp = linkedList.getHead();

        while (!stack.isEmpty()){
            HeroNode node = stack.pop();
            node.next = null;
            temp.next = node;
            temp = temp.next;
        }

    }


    /**
     * 【百度】反序打印单向链表的值,要求一：反向遍历；方式二：Stack栈；
     * @param linkedList
     */
    public static void reversePrintLinkedList(LinkedList linkedList){

        HeroNode cur = linkedList.getHead().next;

        HeroNode tempHead = new HeroNode(0,"");

        HeroNode next = null;//记录当前节点的后一个节点，以防断链

        //方式一：反向遍历
        System.out.println("==========反向遍历=========");
        while (cur != null){

            next = cur.next;
            cur.next = tempHead.next;
            tempHead.next = cur;
            cur = next;
        }

        linkedList.getHead().next = tempHead.next;

        linkedList.list();



        //方式二：Stack栈
        System.out.println("=========方式二：Stack栈=========");

        HeroNode temp = linkedList.getHead();
        Stack<HeroNode> stack = new Stack<>();

        while (temp.next!=null){
            temp = temp.next;
            stack.push(temp);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().toString());
        }

    }

    /**
     * 合并两个数组，使得合并后的两个数组是一个有序数组
     * @param list1
     * @param list2
     */
    public static LinkedList mergerLinkedListByOrder(LinkedList list1, LinkedList list2){

        HeroNode leftCur = list1.getHead().next;//第一个链表的当前指针位置
        HeroNode rightCur = list2.getHead().next;//第二个链表的当前指针位置

        HeroNode leftNext = null;  // 第一个链表的当前指针的下一个节点
        HeroNode rightNext = null; // 第二个链表的当前指针的下一个节点

        HeroNode mergerHead = new HeroNode(0,"");
        HeroNode tempHead = mergerHead;


        while (leftCur != null && rightCur != null){

            if (leftCur.id == rightCur.id){
                throw new RuntimeException("出现错误，ID重复，无法完成链表的合并");
            }

            if (leftCur.id < rightCur.id){

                leftNext = leftCur.next;
//                leftCur.next = mergerHead.next;
//                mergerHead.next = leftCur;

                mergerHead.next = leftCur;
                mergerHead = leftCur;

                leftCur = leftNext;
            }
            else if (leftCur.id > rightCur.id){

                rightNext = rightCur.next;
//                rightCur.next = mergerHead.next;
//                mergerHead.next = rightCur;
                mergerHead.next = rightCur;
                mergerHead = rightCur;

                rightCur = rightNext;
            }

        }

        while (leftCur != null){

            leftNext = leftCur.next;
//            leftCur.next = mergerHead .next;
//            mergerHead.next = leftCur;
            mergerHead.next = leftCur;
            mergerHead = leftCur;

            leftCur = leftNext;

        }

        while (rightCur != null){

            rightNext = rightCur.next;
//            rightCur.next = mergerHead.next;
//            mergerHead.next = rightCur;

            mergerHead.next = rightCur;
            mergerHead = rightCur;
            rightCur = rightNext;
        }

        LinkedList newLinkedList = new LinkedList();
        newLinkedList.getHead().next = tempHead.next;

        return newLinkedList;

    }


    /**
     * 判断两个链表是否有环;
     */

    public static boolean hashCircle(LinkedList linkedList){

        HeroNode fast = linkedList.getHead();
        HeroNode slow = linkedList.getHead();

        while (slow != null  && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }

        return false;
    }


    /**
     * 找到存在环的链表的入口点
     */

    public static HeroNode findLoopStart(LinkedList circleList){

        HeroNode fast = circleList.getHead();
        HeroNode slow = circleList.getHead();

        while (slow != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){

                HeroNode head = circleList.getHead();
                HeroNode pre = slow;

                while (head != head){
                    head = head.next;
                    pre = pre.next;
                }

                return pre;
            }
        }

       return null;
    }


    /**
     * 求链表中环中节点的个数
     **/
    public static int getLoopNodeNumbers(LinkedList circleList){

        HeroNode loopStart = AboutLinkedListQues.findLoopStart(circleList);
        HeroNode curNode = loopStart.next;
        int resNum = 0;
        while (curNode != loopStart ){

            curNode = curNode.next;
            resNum++;
        }

        return resNum;

    }






}
