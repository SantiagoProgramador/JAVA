package CourseSystem;

import java.util.ArrayList;

public class Course {
    //Attributes
    private String code;
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
   

    //Constructors
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
    }
    //Methods

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
}
