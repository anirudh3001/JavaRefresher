package JavaConcepts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SUV extends Vehicle{
    private boolean fourWheelDrive;

    public SUV(String make, String model, int year, String date) {
        super(make, model, year, date);
    }

    @Override
    public String getType() {
        return "JavaConcepts.SUV";

    }
}
