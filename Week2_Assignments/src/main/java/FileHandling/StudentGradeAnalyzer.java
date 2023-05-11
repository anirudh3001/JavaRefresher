package FileHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
class Student{
    private String id;
    private String name;
    private double totalGrade;
    private int numGrades;
    private double averageGrade;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        averageGrade=0;
    }

    public void addGrade(double grade){
        totalGrade+=grade;
        numGrades++;
    }

    public void calculateAverageGrade(){
        averageGrade = totalGrade/numGrades;
    }


}
public class StudentGradeAnalyzer {
    private Map<String,Student> students;

    public void readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line =reader.readLine())!=null){
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            double grade = Double.parseDouble(parts[2]);
            if(!students.containsKey(id)){
                students.put(id,new Student(id,name));
            }
            students.get(id).addGrade(grade);
        }
        reader.close();
    }
    public void calculateAverage(){
        for(Student student:students.values()){
            student.calculateAverageGrade();
        }

    }
    public void printResults(){
        for(Student student:students.values()){
            System.out.print("Student ID:"+student.getId());
            System.out.print("Name:"+student.getName());
            System.out.print("Average Grade:"+student.getAverageGrade()+"\n");
        }
    }
    public static void main(String args[]){
        StudentGradeAnalyzer analyzer = new StudentGradeAnalyzer();
        try {
                analyzer.readFile("grades.csv");
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
        analyzer.calculateAverage();
        analyzer.printResults();
    }

}
