package Future_Completable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Fibonacci implements Callable {
    private int num;

    Fibonacci(int num){
        this.num  = num;
    }
    public List<Integer> call() throws Exception{
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        int n1=0,n2=1;
        for(int i = 2;i<num;i++)
        {
            int n3 = n1+n2;
            fibonacci.add(n3);
            n1 =n2;
            n2 =n3;
        }
        Thread.sleep(1000);
        return fibonacci;
    }
}
