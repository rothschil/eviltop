package io.github.rothschil.concurrent.aqs.cdl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        int cdl = 5;
        ExecutorService executorService =  Executors.newFixedThreadPool(cdl);
        CountDownLatch countDownLatch = new CountDownLatch(cdl);
        for (int i = 0; i < cdl; i++) {
            executorService.submit(new CountDownLatchRunnable("source"+i,countDownLatch));
        }
        countDownLatch.await();
        System.out.println("执行完成");
        executorService.shutdown();

    }
}
