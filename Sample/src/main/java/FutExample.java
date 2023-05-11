import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutExample {
    public static void main(String[] args){
        List<Integer> result = new ArrayList<>();
        ExecutorService ex = Executors.newFixedThreadPool(10);

        Future<List<Integer>> fut = ex.submit(()->{
           List<Integer> a = new ArrayList<>();
           int i = 0;
           while(i<10){
               if(i%2==0)
                   a.add(i);
           }
           return a;

        });

        try{
            result = fut.get();
        }
        catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        System.out.println(result);
        ex.shutdown();
    }
}
