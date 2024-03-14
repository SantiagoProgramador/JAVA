package CourseSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseSystem{
    //Attributes
    private ArrayList<Course> courses;
    //Constructors
    public CourseSystem(){
        this.courses = new ArrayList<>();
    }

    //Methods
    public void addCourse(Scanner scanner){
        System.out.println("""
                Add a course:
                Type the name of the course.
                """);
        String name = scanner.nextLine();

        System.out.println("Type the code of the course");
        String code = scanner.nextLine();

        if (this.findCode(code) != null){
            System.out.println("The course you want to add already exist.");
        } else {
            Course course = new Course(code,name);
            this.courses.add(course);
            System.out.println("Course " + name + " has been added successfully!");
        }
    }

    public Course findCode(String code){
        for(Course course : this.courses){
            if (course.getCode().equalsIgnoreCase(code)){
                return course;
            }
        }
        return null;
    }
    public boolean showCourses(){
        if (this.courses.isEmpty()){
            System.out.println("No courses right now.");
            return false;
        } else {
            System.out.println("Courses: ");
            for (Course course : this.courses){
                System.out.println(course.toString());
            }
            return true;
        }
    }
    //Setters y getters
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    //ToString

}
