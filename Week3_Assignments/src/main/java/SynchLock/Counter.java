package SynchLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class IncrementTask implements Runnable{
    private Counter counter;

    IncrementTask(Counter counter){
        this.counter = counter;
    }
    public void run(){
        for(int i=0;i<1000;i++){
            counter.increment();
        }
    }
}
public class Counter {
    private int count =0 ;
    private Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            count++;
        }finally {
            lock.unlock();
        }

    }

    public int getCount() {return count;}

    public static void main(String args[]) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new IncrementTask(counter));
        Thread t2 = new Thread(new IncrementTask(counter));
        Thread t3 = new Thread(new IncrementTask(counter));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Count:"+counter.getCount());
    }
}
