package io.github.rothschil.concurrent.queue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{

    private BlockingQueue<String> queue;
    private String produce;
    public Producer(BlockingQueue<String> queue, String produce) {
        this.queue = queue;
        if (null != produce)
            this.produce = produce;
        else this.produce = "null ";
    }

    @Override
    public void run() {
        String uuid = UUID.randomUUID().toString();
        try {
            TimeUnit.SECONDS.sleep(1);
            queue.put(produce + " : " + uuid);
            System.out.println("Produce \"" + produce + "\" : " + uuid + " " + Thread.currentThread());

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
