package io.github.rothschil.concurrent.threadlocal;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class ThreadLocalExample implements Runnable{


    private static final ThreadLocal<SimpleDateFormat>
    TIME_LOCAL = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample example = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(example," SORT_"+i);
            TimeUnit.SECONDS.sleep(2);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("BEGIN "+Thread.currentThread().getName()+ " default Formatter =" + TIME_LOCAL.get().toPattern() );
        TIME_LOCAL.set(new SimpleDateFormat());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END "+Thread.currentThread().getName() + " default Formatter =" + TIME_LOCAL.get().toPattern());
    }
}
