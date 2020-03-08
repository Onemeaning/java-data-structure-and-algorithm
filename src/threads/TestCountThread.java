package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建100个线程按顺序打印 0-99；
 */
public class TestCountThread {

    public static void main(String[] args){

        //先创建一个被锁住的对象;
        LockObject lockObject = new LockObject(0);

        //创建一个线程池，
        ExecutorService executors = Executors.newCachedThreadPool();

        //向线程池中提交任务，
        for (int i = 0;i<100;i++){

            executors.submit(new CountThread(99-i,lockObject));
        }

        //关闭线程池
        executors.shutdown();

    }

}
