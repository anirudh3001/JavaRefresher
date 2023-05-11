package Future_Completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureEx {
    public static void main(String args[]){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time:"+startTime);
        try{
            List<Callable<List<Integer>>> callables = Arrays.asList(new Fibonacci(20),new Fibonacci(30),new Fibonacci(40));

            exec.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try{
                            return future.get();
                        }
                        catch (Exception e){
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(s-> System.out.println("Values:"+s));

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("End time:"+System.currentTimeMillis());
            exec.shutdown();
        }



    }
}
