package JavaConcepts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Rental {
    private Vehicle vehicle;
    private String rentalDate;
    private int rentalDuration;
    private boolean GPS;
    private boolean childSeat;
    private boolean roofRack;

    public int calculateRentalCost(){
        int carRate = 0;
        if(vehicle.getType().equals("JavaConcepts.SUV"))
            carRate = 700;
        else if (vehicle.getType().equals("JavaConcepts.Sedan"))
            carRate = 500;
        carRate = carRate * rentalDuration;
        if(GPS)
            carRate = carRate + 500;
        if(childSeat)
            carRate = carRate + 500;
        if(roofRack)
            carRate = carRate + 500;
        System.out.println("The rate for renting the vehicle for "+rentalDuration+" is: "+carRate);
        return carRate;
    }
}
