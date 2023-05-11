package Collections_Framework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
class Student{
    private String name;
    private int rollNo;
    private List<Integer> grades;

    Student(){
        grades = new ArrayList<>();
    }
}
public class Student_Grades {
    Set<Integer> rollNoUniq;
    List<Student> students;
    Map<Integer, Integer> avgGrades;
    Student_Grades(){
        rollNoUniq = new HashSet<Integer>();
        students = new ArrayList<Student>();
        avgGrades = new HashMap<Integer,Integer>();
    }
    public void addStudent(){
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter Student Name:");
        String name = inp.nextLine();

        System.out.println("Enter Student RollNo:");
        int rollNo = inp.nextInt();
        rollNoUniq.add(rollNo);

        System.out.println("Enter grades of 5 subjects:");
        List<Integer> grades = new ArrayList<Integer>();

        int avggrade = 0;

        for(int i=0;i<5;i++){
           int grade = inp.nextInt();
           avggrade+=grade;
           grades.add(grade);
        }

        avggrade = avggrade / 5;

        avgGrades.put(rollNo,avggrade);
        students.add(new Student(name,rollNo,grades));
    }

    public void remStudent(int rollNo){
        rollNoUniq.remove(rollNo);
        Iterator<Student> it1 = students.listIterator();
        while(it1.hasNext()){
            Student toBeRem = it1.next();
            if(toBeRem.getRollNo()==rollNo){
                it1.remove();
            }
        }

        avgGrades.remove(rollNo);
    }

    public void addGrade(int rollNo, int grade){
        int num_list=1;
        for(Student student: students){
            if(student!=null && student.getRollNo()==rollNo){
                List<Integer> newGrades = student.getGrades();
                newGrades.add(grade);
                num_list = newGrades.size();
                student.setGrades(newGrades);
            }
        }

        int avggrade = avgGrades.get(rollNo);
        int avggrade1 = ((avggrade*num_list)+grade)/num_list;

        avgGrades.replace(rollNo,avggrade,avggrade1);

    }

    public void remGrade(int rollNo, int gradeInd){
        int num_list=1, remGrad=1;
        for(Student student: students){
            if(student!=null && student.getRollNo()==rollNo){
                List<Integer> newGrades = student.getGrades();
                remGrad = newGrades.remove(gradeInd);
                num_list = newGrades.size();
                student.setGrades(newGrades);
            }
        }

        int avggrade = avgGrades.get(rollNo);
        int avggrade1 = (avggrade*(num_list+1) - remGrad)/num_list;

        avgGrades.replace(rollNo,avggrade,avggrade1);

    }

    public void sortAvgGrades(){
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(avgGrades.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<Integer,Integer> result = new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> entry : list){
            result.put(entry.getKey(),entry.getValue());
        }
        avgGrades.clear();
        avgGrades.putAll(result);
        result.toString();
    }
    public void sortStudents(){
        Scanner inp1 = new Scanner(System.in);
        System.out.println("How do you wish to sort the students? \n 1. By Name \n 2. By Avg Grade:");
        int opt = inp1.nextInt();
        switch (opt){
            case 1:{
                break;
            }
            case 2:{
                sortAvgGrades();
                break;
            }
        }
    }

    public void findTopper(){
        sortAvgGrades();
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(avgGrades.entrySet());
        Iterator<Student> itr1 = students.listIterator();
        while(itr1.hasNext()){
            Student top = itr1.next();
            if(top.getRollNo()==list.get(0).getKey()){
                top.toString();
            }
        }
    }

    public static void main(String args[]) {
        Student_Grades func = new Student_Grades();
        int opt;
        do {
            System.out.println("Enter what functionality you would like to explore?");
            System.out.println("1. Add a student \n 2. Remove a Student \n 3. Add grade\n 4. Remove a grade " +
                    "\n 5. Sorting Student \n 6. Identify Topper \n 7. Exit");
            Scanner inp1 = new Scanner(System.in);
            opt = inp1.nextInt();
            switch(opt) {
                case 1: {
                    func.addStudent();
                    break;
                }
                case 2: {
                    System.out.println("Enter rollno of student to be deleted:");
                    int rollNo = inp1.nextInt();
                    func.remStudent(rollNo);
                    break;
                }
                case 3:{
                    System.out.println("Enter rollno of student to add grade:");
                    int rollNo = inp1.nextInt();
                    System.out.println("Enter grade to add:");
                    int grade = inp1.nextInt();
                    func.addGrade(rollNo,grade);
                    break;

                }
                case 4:{
                    System.out.println("Enter rollno of student to remove grade:");
                    int rollNo = inp1.nextInt();
                    System.out.println("Enter grade index to remove:");
                    int grade = inp1.nextInt();
                    func.remGrade(rollNo,grade);
                    break;
                }
                case 5:{
                    func.sortStudents();
                }
                case 6:{
                    func.findTopper();
                }
                case 7:{
                    System.exit(0);
                }
            }
        }while (opt!=7);

    }


    }

