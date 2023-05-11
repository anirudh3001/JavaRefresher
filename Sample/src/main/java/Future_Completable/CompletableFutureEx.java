package Future_Completable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureEx {

    public List<Integer> fibonacciSeries(int size) {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        int n1=0,n2=1;
        for(int i = 2;i<size;i++)
        {
            int n3 = n1+n2;
            fibonacci.add(n3);
            n1 =n2;
            n2 =n3;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return fibonacci;
    }

    public static void main(String args[]) {
//        List<CompletableFuture<List<Integer>>> futuresList = new ArrayList<>();
        CompletableFuture<List<Integer>> fib1 = CompletableFuture.supplyAsync(() -> new CompletableFutureEx().fibonacciSeries(20));
        CompletableFuture<List<Integer>> fib2 = CompletableFuture.supplyAsync(() -> new CompletableFutureEx().fibonacciSeries(30));
        CompletableFuture<List<Integer>> fib3 = CompletableFuture.supplyAsync(() -> new CompletableFutureEx().fibonacciSeries(40));

        long startTime = System.currentTimeMillis();
        fib1.thenAccept(result -> {
            System.out.println("Fibonacci(20):"+result);
        });

        fib2.thenAccept(result -> {
            System.out.println("Fibonacci(30):"+result);
        });

        fib2.thenAccept(result -> {
            System.out.println("Fibonacci(40):"+result);
        });

        System.out.println("End time:"+(startTime-System.currentTimeMillis()));
//        CompletableFuture<List<Integer>> fib1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return new Fibonacci(20).call();
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        CompletableFuture<List<Integer>> fib2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return new Fibonacci(30).call();
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        CompletableFuture<List<Integer>> fib3 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return new Fibonacci(40).call();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//
//        futuresList.add(fib1);
//
//        futuresList.add(fib2);
//
//        futuresList.add(fib3);
//
//        CompletableFuture<Void> allFutures = CompletableFuture
//                .allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
//
//
//        CompletableFuture<List<List<Integer>>> allCompletableFuture = allFutures.thenApply(future -> futuresList.stream().map(completableFuture -> completableFuture.join())
//
//                .collect(Collectors.toList()));
//
//        CompletableFuture<List<List<Integer>>> completableFuture = allCompletableFuture.toCompletableFuture();
//
//        try {
//
//            List<List<Integer>> finalList = completableFuture.get();
//
//            System.out.print(finalList);
//
//        } catch (InterruptedException e) {
//
//            e.printStackTrace();
//
//        } catch (ExecutionException e) {
//
//            e.printStackTrace();
//        }
    }







}
