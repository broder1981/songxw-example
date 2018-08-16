package com.songxw.universalbox.thread;

/**
 * 实现基本的多线程效果
 */
public class BaseThreadDemo extends Thread {

    private String name;
    private int taskNum = 15;

    BaseThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (taskNum > 0) {
            System.out.println(name + "执行了任务" + taskNum);
            taskNum--;
        }
    }

    public static void main(String[] args) {
        /*实例化多个对象，每个对象各自执行自己的线程任务，并且各对象中的属性不共享*/
        BaseThreadDemo baseThreadDemoA = new BaseThreadDemo("警官A");
        BaseThreadDemo baseThreadDemoB = new BaseThreadDemo("警官B");
        BaseThreadDemo baseThreadDemoC = new BaseThreadDemo("警官C");
        baseThreadDemoA.start();
        System.out.println("警官A已经就绪");
        baseThreadDemoB.start();
        System.out.println("警官B已经就绪");
        baseThreadDemoC.start();
        System.out.println("警官C已经就绪");
    }

}

