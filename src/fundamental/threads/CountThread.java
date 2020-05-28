package fundamental.threads;

public class CountThread extends Thread {

    private int printNum = 0;

    //锁对象是唯一的
    private LockObject lockObject;

    public CountThread(int printNum, LockObject lockObject) {
        this.printNum = printNum;
        this.lockObject = lockObject;
    }

    @Override
    public void run() {

       synchronized (lockObject){

           while (lockObject.orderNum <= lockObject.MAX_NUM && !interrupted()){

               if (printNum == lockObject.orderNum){

                   System.out.println(printNum+" ");
                   lockObject.orderNum++;

                   if (lockObject.orderNum == 100){
                       Thread.interrupted();
                       System.out.println("打印完成了！");
                   }

                   lockObject.notifyAll();

               }
               else {

                   try {

                       lockObject.wait();
                       System.out.println("我有要睡觉去了" + lockObject.orderNum);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }



           }



       }



    }
}
