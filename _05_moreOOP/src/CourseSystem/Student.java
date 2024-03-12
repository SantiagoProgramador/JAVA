package CourseSystem;

public class Student {
    //Attributes
    private int idStudent;
    private String name;
    private String email;
    
    //Constructors
    public Student(int idStudent, String name, String email) {
        this.idStudent = idStudent;
        this.name = name;
        this.email = email;
    }
    //Methods
    
    //Setters and getters
    public int getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //ToString
}
