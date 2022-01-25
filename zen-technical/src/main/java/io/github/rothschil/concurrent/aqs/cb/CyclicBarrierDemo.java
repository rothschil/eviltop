package io.github.rothschil.concurrent.aqs.cb;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) throws Exception{
        int cdl = 5;
        ExecutorService executorService =  Executors.newFixedThreadPool(cdl);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(cdl,new BarrierAction());
        for (int i = 0; i < cdl; i++) {
            executorService.submit(new CyclicBarrierRunnable("source"+i,cyclicBarrier));
        }
        System.out.println("执行完成");
        executorService.shutdown();
    }
}

class BarrierAction implements Runnable {

    @Override
    public void run() {
        System.out.println(" Thread Name is: "+ Thread.currentThread().getName() + " ,BarrierAction Task End");
    }
}
