package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Callable c = new MyCallable();
            Future f = pool.submit(c);
            list.add(f);
        }

        pool.shutdown();

        for (Future future : list){

            System.out.println("res: " + future.get().toString());
        }
    }
}
