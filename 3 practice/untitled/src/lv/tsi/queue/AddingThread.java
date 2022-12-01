package lv.tsi.queue;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class AddingThread extends Thread {
    private BlockingQueue<String> blockedQueue;

    AddingThread(BlockingQueue<String> blockedQueue) {
        this.blockedQueue = blockedQueue;
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            var threadName = "Added Element"+i;
            blockedQueue.add(threadName);
            System.out.println("Current Thread: "
                    + threadName);
        }
    }
}
class TakingThread extends Thread {
    private BlockingQueue<String> blockedQueue;
    TakingThread(BlockingQueue<String> blockedQueue){
        this.blockedQueue = blockedQueue;
    }
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                System.out.println(blockedQueue.take());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
class BlockingMain {
    public static void main(String[] args) {
        final BlockingQueue<String> blockingQueue1 = new ArrayBlockingQueue<>(10);
        AddingThread addingThread = new AddingThread(blockingQueue1);
        TakingThread takingThread = new TakingThread(blockingQueue1);
        addingThread.start();
        takingThread.start();
    }
}
