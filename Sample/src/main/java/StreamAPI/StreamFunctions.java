package StreamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFunctions {
    public static void main(String args[]){
        List<Integer> exList = new ArrayList<>();
        exList = IntStream.rangeClosed(1,100)
                .boxed().collect(Collectors.toList());


        //Using Map
        List result = exList.stream().map(x->x+1).collect(Collectors.toList());
        System.out.println("Order changed from:"+result);

        //Using Filter
        List result2 = exList.stream().filter(s->s%2==0).collect(Collectors.toList());
        System.out.println("All even numbers from 1-100"+result2);


        //Using Collect
        Set result3 = exList.stream().filter(s -> s%2!=0).collect(Collectors.toSet());
        System.out.println("Collecting as set:"+result3);

        //Using reduce
        Integer result4 = exList.stream().filter(s -> s>40 && s%2==0).reduce(0,(ans,i)->ans+i);
        System.out.println("Sum of even numbers greater than 40:"+result4);

        //Using Sorted
        List<Integer> result5 = exList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("In reverse:"+result5);
    }
}

