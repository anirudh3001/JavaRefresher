package JavaConcepts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Sedan extends Vehicle{
    private int noOfSeats;
    private String fuelType;

    public Sedan(String make, String model, int year, String date) {
        super(make, model, year, date);
    }

    @Override
    public String getType() {
        return "JavaConcepts.Sedan";
    }
}