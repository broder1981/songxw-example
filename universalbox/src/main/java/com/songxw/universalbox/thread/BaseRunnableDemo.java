package com.songxw.universalbox.thread;

/**
 * 实现基本的多线程效果
 */
public class BaseRunnableDemo implements Runnable {

    private int taskNum = 15;

    @Override
    public void run() {
        while (taskNum > 0) {
            System.out.println(Thread.currentThread().getName() + "执行了任务" + taskNum);
            taskNum--;
        }
    }

    public static void main(String[] args) {
        /*实例化一个对象，该对象生成多个独立的线程，各线程之间共享对象的属性*/
        BaseRunnableDemo baseRunnableDemo = new BaseRunnableDemo();
        Thread threadA = new Thread(baseRunnableDemo, "警官A");
        Thread threadB = new Thread(baseRunnableDemo, "警官B");
        Thread threadC = new Thread(baseRunnableDemo, "警官C");
        threadA.start();
        System.out.println("警官A已经就绪");
        threadB.start();
        System.out.println("警官B已经就绪");
        threadC.start();
        System.out.println("警官C已经就绪");
    }

}
