package lv.accenture.bootcamp.threads;

public class JoinExample {

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new JoinThread(), "th1");
        Thread th2 = new Thread(new JoinThread(), "th2");
        Thread th3 = new Thread(new JoinThread(), "th3");

        th1.start();
        th1.join();

        th2.start();
        th3.start();
    }

}

class JoinThread implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Thread started: " + t.getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Thread ended: " + t.getName());
    }
}


