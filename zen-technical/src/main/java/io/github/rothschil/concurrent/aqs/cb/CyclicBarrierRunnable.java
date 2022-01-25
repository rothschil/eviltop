package io.github.rothschil.concurrent.aqs.cb;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierRunnable implements Runnable{

    private String source;

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierRunnable() {
    }

    public CyclicBarrierRunnable(String source, CyclicBarrier cyclicBarrier) {
        this.source = source;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        int id = new Random().nextInt(5);
        try {
            TimeUnit.SECONDS.sleep(id);
            LocalDateTime localDateTime = LocalDateTime.now();
            String resutl = source+"_"+id;
            System.out.println("当前时间 "+localDateTime.getMinute()+":"+localDateTime.getSecond()+" 当前线程名: "+Thread.currentThread().getName()+ " 结果为: "+ resutl);
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
