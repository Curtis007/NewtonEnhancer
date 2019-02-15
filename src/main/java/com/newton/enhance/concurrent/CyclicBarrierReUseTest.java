package com.newton.enhance.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行
 */
public class CyclicBarrierReUseTest {




    static class Writer extends Thread{

        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }


        public void run(){
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }

    }




    public static void main(String[] args){
        int N=4;
        CyclicBarrier barrier = new CyclicBarrier(N);

        for(int i=0;i<N;i++){
            new CyclicBarrierTest.Writer(barrier).start();
        }

        System.out.println("...main end...");
        for(int i=0;i<N;i++){
            System.out.println("......................................");
            new CyclicBarrierTest.Writer(barrier).start();
        }
    }
}
