package fundamental.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    static class Writer extends Thread{

        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);

                System.out.println("线程" +  Thread.currentThread().getName() + "写入数据完毕等待其他线程写入");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("所有的线程都写入完毕，继续处理其他任务，例如写入数据……");

        }
    }

    public static void main(String[] args){
        final  int N = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Writer(cyclicBarrier).start();
        }
    }

}
