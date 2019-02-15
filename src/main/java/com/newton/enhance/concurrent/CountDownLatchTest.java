package com.newton.enhance.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 *  await(): 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
 *  await(long timeout, TimeUnit unit):和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
 *  countDown(): 将count值减1
 */
public class CountDownLatchTest {

    public static void main(String[] args){

        final CountDownLatch latch = new CountDownLatch(2);

        //线程1
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    latch.countDown();

                    System.out.println("goooooooooooooon111............"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        //线程2
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    latch.countDown();

                    System.out.println("goooooooooooooon222............"+Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();


        //线程3
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    latch.countDown();

                    System.out.println("goooooooooooooon333............"+Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        try {
            //System.out.println("等待2个子线程执行完毕..."+Thread.currentThread().getName());


            latch.await();

            System.out.println("...3个子线程已经执行完毕....."+Thread.currentThread().getName());
            System.out.println("继续执行主线程"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 子线程Thread-0正在执行
     * 子线程Thread-1正在执行
     * 子线程Thread-2正在执行
     * 子线程Thread-0正在执行
     * goooooooooooooon111............Thread-0
     * 子线程Thread-1正在执行
     * goooooooooooooon222............Thread-1
     * 子线程Thread-2正在执行
     * goooooooooooooon333............Thread-2
     * ...3个子线程已经执行完毕.....main
     * 继续执行主线程main
     *
     *
     * 得出结论：线程在countDown()之后，会继续执行自己的任务;而CyclicBarrier会在所有线程任务结束之后，才会进行后续任务
     */
}
