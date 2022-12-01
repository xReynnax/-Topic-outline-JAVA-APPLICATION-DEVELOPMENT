package lv.tsi.sync;

class TaskManager {
    void performTask(int taskId)
            throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + taskId);
        Thread.sleep(4);
        System.out.println(Thread.currentThread().getName() + " " + taskId);
    }
}
class TaskThread extends Thread {
    private TaskManager task;
    private int taskId;
    public TaskThread(String threadName, int taskId, TaskManager task){
        super(threadName);
        this.taskId = taskId;
        this.task = task;
    }

    public void run() {
        System.out.println("Current Thread: "
                + Thread.currentThread());
    }
}
class SyncMain{
    public static void main(String[] args)
            throws InterruptedException {
        final TaskManager t1 = new TaskManager();
        TaskThread th1 = new TaskThread("Thread - 1",10, t1);
        TaskThread th2 = new TaskThread("Thread - 2",11, t1);

        System.out.println(th1.getName());
        System.out.println(th2.getName());

        th1.start();
        Thread.sleep(2);
        th2.start();
    }
}