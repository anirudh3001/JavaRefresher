package Comparable_Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
class Employee {
    private String name;
    private Integer age;
    private Integer salary;
}

class EmployeeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee a1, Employee a2){
        int AgeCompare = a1.getAge().compareTo(a2.getAge());

        int SalCompare = a1.getSalary().compareTo(a2.getSalary());

        return (AgeCompare == 0)? SalCompare : AgeCompare;
    }
}

public class SortingEmployee{
    public static void main(String args[]){
        List<Employee> listEmp = new ArrayList<Employee>();

        listEmp.add(new Employee("Anirudh",22,55000));
        listEmp.add(new Employee("Manasa",24,55000));
        listEmp.add(new Employee("Bharat",24,45000));
        listEmp.add(new Employee("Ajay",22,50000));

        Iterator<Employee> empIterator = listEmp.iterator();

        System.out.println("Before Sorting:\n");

        while (empIterator.hasNext()) {
            System.out.println(empIterator.next());
        }

        Collections.sort(listEmp,
                new EmployeeComparator());

        System.out.println("\n\nAfter Sorting:\n");

        for (Employee emp : listEmp) {
            System.out.println(emp);
        }
    }

}
