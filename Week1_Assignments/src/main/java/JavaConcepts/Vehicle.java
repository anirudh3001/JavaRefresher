package JavaConcepts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private String date;

    Vehicle(String make, String model, int year, String date){
        this.make = make;
        this.model = model;
        this.year = year;
        this.date = date;
    }

    public abstract String getType();
}
