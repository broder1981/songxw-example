package com.songxw.universalbox.thread;

public class BothThreadDemo {

    public static void main(String[] args) {
        BothThreadDemo bothThreadDemo = new BothThreadDemo();
        bothThreadDemo.createMixedThread();//创建混合模式的线程
    }

    /**
     * 创建混合模式的线程
     */
    private void createMixedThread() {
        BaseRunnableDemo baseRunnableDemo = new BaseRunnableDemo();
        Thread threadA = new Thread(baseRunnableDemo, "警官A");//属性共享
        Thread threadB = new Thread(baseRunnableDemo, "警官B");//属性共享
        Thread threadC = new Thread(new BaseRunnableDemo(), "警官C");//新对象，属性独立
        BaseThreadDemo baseThreadDemo = new BaseThreadDemo("警官D");//属性对立
        threadA.start();
        System.out.println("警官A已经就绪");
        threadB.start();
        System.out.println("警官B已经就绪");
        threadC.start();
        System.out.println("警官C已经就绪");
        baseThreadDemo.start();
        System.out.println("警官D已经就绪");
    }

}
