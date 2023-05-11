package Exception_Handling;

import java.util.Scanner;

class NegativeNumberException extends Exception{
    public NegativeNumberException(String s)
    {
        super(s);
    }
}

class EmptyArrayException extends Exception{
    public EmptyArrayException(String s){
        super(s);
    }
}
public class ExceptionHandler {
    public static void main(String args[]){
        int[] arr = new int[10];
        int length_arr;
        Scanner a = new Scanner(System.in);

        System.out.println("Enter length of array");
        try{
            length_arr=a.nextInt();
            if(length_arr==0||length_arr>10)
                throw new EmptyArrayException("Enter length of array");
            System.out.println("Enter elements of array");
            for(int i=0;i<length_arr;i++)
            {
                int newElement = a.nextInt();
                if(newElement<0)
                    throw new NegativeNumberException("Negative element entered");
                arr[i] = newElement;
            }
        }catch(EmptyArrayException ex){
            System.out.println("Empty Array Requested");
        }catch(NegativeNumberException ex){
            System.out.println("Negative Number Entered");
        }
    }
}
