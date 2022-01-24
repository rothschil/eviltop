package io.github.rothschil.concurrent.synch;

public class SynchronizedDemo {

    public void method1(){
        synchronized (this){
            System.out.println("=====");
        }
    }

    public synchronized void method2(){
        System.out.println("=====");
    }
}
