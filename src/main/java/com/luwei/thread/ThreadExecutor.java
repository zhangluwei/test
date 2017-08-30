package com.luwei.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutor {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor fixedThreadPool = new ThreadPoolExecutor(2, 2, 0l, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1), new ThreadPoolExecutor.AbortPolicy());

        System.out.println();

        for (int i = 0; i < 10; i++) {

            final int n = i;

            fixedThreadPool.execute(new Runnable() {

                public void run() {

                     try {
                     Thread.sleep(3000);
                     } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                     }
                    System.out.println(Thread.currentThread().getName()+"-----"+n);
                    ;

                }
            });
        }

        System.out.println("end");

        Thread.sleep(10000);

        fixedThreadPool.execute(new Runnable() {

            public void run() {

                // try {
                // Thread.sleep(1000);
                // } catch (InterruptedException e) {
                // throw new RuntimeException(e);
                // }
                System.out.println("ssssss");
                ;

            }
        }
        );

    }
}
