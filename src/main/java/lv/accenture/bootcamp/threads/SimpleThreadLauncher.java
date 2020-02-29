package lv.accenture.bootcamp.threads;

import lv.accenture.bootcamp.ifaces.geometry.Cylinder;

public class SimpleThreadLauncher {

    public static void main(String[] args) throws InterruptedException {

        SimpleThreadLauncher simpleThreadLauncher = new SimpleThreadLauncher();
        SimpleThread simpleThread = simpleThreadLauncher.new SimpleThread();
        Thread thread = new Thread(simpleThread);

        System.out.println("thread.getName() = " + thread.getName());
        thread.setName("Simple thread #0");
        System.out.println("thread.getName() = " + thread.getName());

        System.out.println("thread state = " + thread.getState());
        thread.start();
        System.out.println("thread state = " + thread.getState());

        Thread.sleep(100);
        System.out.println("Main is finished");
    }

    private class SimpleThread implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Thread has started!");
                Thread.sleep(500);
                System.out.println("Thread has finished!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
