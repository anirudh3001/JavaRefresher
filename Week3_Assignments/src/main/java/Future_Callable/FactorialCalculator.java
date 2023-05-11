package Future_Callable;

import java.util.Scanner;
import java.util.concurrent.*;

public class FactorialCalculator implements Callable<Double> {
    private int num;

    FactorialCalculator(int num){
        this.num=num;
    }
    public Double call() throws InterruptedException {
        Double fact = 1.0;
        for(int i=1;i<=num;i++)
            fact*=i;
        Thread.sleep(400);
        return fact;
    }

    public static void main(String args[]){
        System.out.println("Enter number to find factorial:");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        FactorialCalculator factorialCalculator = new FactorialCalculator(num);
        ExecutorService exec = Executors.newSingleThreadExecutor();

        Future<Double> future = exec.submit(factorialCalculator);
        Double result = null;
        try{
            result = future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Factorial is:"+result);

        exec.shutdown();
    }
}
