package lv.tsi.producer_consumer;
import java.util.Random;

class Goods {
    public int amount;
    public synchronized void produce(int amount) {
        while (this.amount != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.amount = amount;
        notify();
    }
    public synchronized int consume() {
        int temp = amount;
        amount = 0;
        while (amount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notify();
        return temp;
    }
}
class Producer extends Thread {
    private final Goods g;
    Producer(Goods g) {
        this.g = g;
    }
    public void run(){
        Random random = new Random();
        while(true) {
            int n = random.nextInt(100);
            g.produce(n);
            System.out.println("Produced: " + n);
            return;
            }
        }
}
class Consumer extends Thread {
    private final Goods g;
    Consumer(Goods g) {
        this.g = g;
    }
    public void run(){
        while(true) {
            int n = g.consume();
            System.out.println("Consumed: " + n);
        }
    }
}
class ProducerConsumerMain{
    public static void main(String[] args){
        Goods g = new Goods();
        Producer producer = new Producer(g);
        Consumer consumer = new Consumer(g);

        producer.start();
        consumer.start();
    }
}
