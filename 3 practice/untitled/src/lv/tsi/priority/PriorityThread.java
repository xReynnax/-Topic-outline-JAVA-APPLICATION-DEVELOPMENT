package lv.tsi.priority;
import java.util.*;

class PriorityThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Current Thread: "
                    + Thread.currentThread());
            System.out.println("Priority of thread is: "
                    +Thread.currentThread().getPriority());

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class PriorityMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        PriorityThread t1 = new PriorityThread();
        t1.setPriority(Thread.MIN_PRIORITY);
        PriorityThread t2 = new PriorityThread();
        t2.setPriority(Thread.NORM_PRIORITY);
        PriorityThread t3 = new PriorityThread();
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
