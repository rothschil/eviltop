package io.github.rothschil.concurrent.aqs.semaphone;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CredentialsRunnable implements Runnable{

    private String source;
    private Semaphore semaphore;

    public CredentialsRunnable() {
    }

    public CredentialsRunnable(String source, Semaphore semaphore) {
        this.source = source;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("ThreadName is "+ Thread.currentThread().getName()+" 凭据: "+source +" 等待中 准备获取许可");
            semaphore.acquire();
            System.out.println("ThreadName is "+ Thread.currentThread().getName()+" 凭据: "+source +" 获取许可");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("ThreadName is "+ Thread.currentThread().getName()+" 凭据: "+source +" 许可使用完毕，准备释放");
            semaphore.release();
        }
    }
}
