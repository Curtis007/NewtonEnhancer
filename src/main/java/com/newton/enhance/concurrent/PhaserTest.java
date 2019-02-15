package com.newton.enhance.concurrent;

import java.util.concurrent.Phaser;

public class PhaserTest {

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5) {
            //所有线程都执行完成
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                //当所有线程都完成了一个任务的时候，会回调。
                System.out.println("完成了第" + phase + "个屏障"+Thread.currentThread().getName());
                //true:后面的屏障无效。false:保持屏障的有效性
                return false;
            }
        };
        //线程数量
        int threadNum = 5;
        for (int i = 0; i < threadNum; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"开始" + finalI);
                        Thread.sleep(1000);
                        //与CyclicBarrier相同，都是等待所有线程到达屏障后，再统一释放
                        phaser.arriveAndAwaitAdvance();
                        System.out.println("结束" + finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
