package JavaConcepts;

import java.awt.desktop.SystemEventListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class RentalSystem {
    private ArrayList<Rental> vehiclesRented;

    RentalSystem()
    {
        vehiclesRented = new ArrayList<Rental>();
    }

    public void rentingVehicle(){
        Scanner a = new Scanner(System.in);
        Vehicle newVehicle = null;
        System.out.println("Enter type of JavaConcepts.Vehicle you wish to rent(JavaConcepts.SUV/JavaConcepts.Sedan):");
        String type = a.nextLine();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        if(type.equals("JavaConcepts.SUV"))
            newVehicle = new SUV("Toyota","Innova",2016,date);
        else if(type.equals("JavaConcepts.Sedan"))
            newVehicle = new Sedan("Toyota","Etios",2016,date);

        System.out.println("Enter duration of rental:");
        int duration = a.nextInt();
        System.out.println("Do you wish to opt for GPS:");
        boolean GPS = a.nextBoolean();
        System.out.println("Do you wish to opt for Child Seat:");
        boolean childSeat = a.nextBoolean();
        System.out.println("Do you wish to opt for Roof Rack:");
        boolean roofRack = a.nextBoolean();

        Rental newRental = new Rental(newVehicle,date,duration,GPS,childSeat,roofRack);
        vehiclesRented.add(newRental);

    }

    public void returnVehicle(){
        ListIterator<Rental> rg = vehiclesRented.listIterator();
        boolean rem;
        Scanner rem1 = new Scanner(System.in);
        while(rg.hasNext()){
            System.out.println(rg.next().toString());
            System.out.println("Want to Return this Vehicle?: ");
            rem = rem1.nextBoolean();
            if(rem==true)
                rg.remove();

        }
    }

    public void generateReport(){
        ListIterator<Rental> rg = vehiclesRented.listIterator();

        int totalRevenue = 0;
        while(rg.hasNext())
        {
            totalRevenue+=rg.next().calculateRentalCost();
        }
        System.out.println("Total Revenue generated is: "+totalRevenue);

    }

    public static void main(String args[]){
        System.out.println("What do you wish to do?");
        System.out.println("1.Rent a Vehicle");
        System.out.println("2.Return a Vehicle");
        System.out.println("3.Generate Expense Reports");
        System.out.println("4.Exit");
        Scanner a = new Scanner(System.in);
        int opt = a.nextInt();
        while(opt!=4)
        {
            switch(opt){
                case 1: {
                    new RentalSystem().rentingVehicle();
                    break;
                }
                case 2: {
                    new RentalSystem().returnVehicle();
                    break;
                }
                case 3: {
                    new RentalSystem().generateReport();
                    break;
                }
            }
            opt = a.nextInt();
        }
    }
}
