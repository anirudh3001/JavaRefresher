package Enums_Loops_DataTypes;

import java.util.Scanner;

enum Temp{
    CELSIUS,
    FAHRENHEIT;
}
public class TempCalculator {
    public static void main(String args[]){
        Scanner a = new Scanner(System.in);
        System.out.println("Enter name of city to calc avg temp");
        String city = a.nextLine();
        System.out.println("Enter month:");
        String month = a.nextLine();

    }
}
