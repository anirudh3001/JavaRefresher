package Multithreading;

public class MultiThread {
    public static void main(String args[]){

        Thread t1 = new Thread() {
            public void run(){
                for(int i = 0; i<10;i++) {
                    System.out.println("This is thread 1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                for(int i = 0;i < 10;i++){
                    System.out.println("This is thread 2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        t1.start();

        t2.start();

    }
}
