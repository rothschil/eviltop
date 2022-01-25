package io.github.rothschil.concurrent.aqs.cdl;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2022/1/25 - 9:55
 * @since 1.0.0
 */
public class CountDownLatchRunnable implements Runnable{

    private String source;

    private CountDownLatch countDownLatch;

    public CountDownLatchRunnable() {
    }

    public CountDownLatchRunnable(String source, CountDownLatch countDownLatch) {
        this.source = source;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        int id = new Random().nextInt(5);
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String resutl = source+"_"+id;
        System.out.println("当前时间 "+localDateTime.getMinute()+":"+localDateTime.getSecond()+" 当前线程名: "+Thread.currentThread().getName()+ " 结果为: "+ resutl);
        countDownLatch.countDown();
    }
}
