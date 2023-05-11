package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
    int tasknum;
    Task(int tasknum){
        this.tasknum = tasknum;
    }
    public void run(){
        System.out.println("Task:"+tasknum+" Thread Name:"+Thread.currentThread().getName());
    }
}
public class ExecutorFramework {
    public static void main(String argsp[]){
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Task(1));
        executorService.submit(new Task(2));
        executorService.submit(new Task(3));
        executorService.submit(new Task(4));
        executorService.submit(new Task(5));

        executorService.shutdown();

    }
}
