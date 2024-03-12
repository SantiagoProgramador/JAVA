package CourseSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    //Attributes
    private String code;
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private static int idStudent = 1;


    //Constructors
    public Course(){}
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
    }
    //Methods
    public void addStudent(Scanner scanner){
        System.out.println("""
                    Add a new student:\s
                    Type the name of the student.
                    """);
        String name = scanner.nextLine();


        System.out.println("Type the email of the student.");
        String email = scanner.nextLine();

        Student student = new Student(idStudent,name,email);
        idStudent++;

        if (this.students.add(student)){
            System.out.println("Student: " + name + " has been added successfully!");

        } else {
            System.out.println("Something went wrong while adding the new student, try again.");
        }
    }
    public void showStudents(){
        if (this.students.isEmpty()){
            System.out.println("The course " + this.name + " does not have students.");
        } else {
            System.out.println("Below are the current students:");
            for (Student student : this.students){
                System.out.println("Id: "+ student.getIdStudent()  + " Name: " + student.getName() +
                        " email: " + student.getEmail());
            }
        }
    }

    public void removeStudent(Scanner scanner){
        this.showStudents();
        System.out.println("Type the id of the student you want to remove from the course");
        int idSent = scanner.nextInt();

        if (this.students.removeIf(student -> student.getIdStudent() == idSent)){
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("The student was not found in the list D:");
        }
    }
    //Setters and getters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }    
    //ToString

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
