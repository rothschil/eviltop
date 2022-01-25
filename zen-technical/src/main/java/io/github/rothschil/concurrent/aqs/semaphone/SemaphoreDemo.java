package io.github.rothschil.concurrent.aqs.semaphone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        int cdl = 2;
        ExecutorService executorService =  Executors.newFixedThreadPool(cdl);
        Semaphore semaphore = new Semaphore(cdl);
        for (int i = 0; i < 6; i++) {
            executorService.submit(new CredentialsRunnable("source"+i,semaphore));
        }
        System.out.println("执行完成");
        executorService.shutdown();
    }
}
