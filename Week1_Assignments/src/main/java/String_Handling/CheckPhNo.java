package String_Handling;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPhNo {
    public static void main(String args[]){
        Scanner check = new Scanner(System.in);
        System.out.println("Enter Phone Number in this format (XXX) XXX-XXXX: ");
        String phNo = check.nextLine();
        boolean matcher = Pattern.matches("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$",phNo);
        System.out.println(matcher);
        if(matcher){
            StringBuilder b = new StringBuilder();
            b.append(phNo.substring(1,4)).append("-").append(phNo.substring(6));
            System.out.println(b.toString());

        }

    }
}
