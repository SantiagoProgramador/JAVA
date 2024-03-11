import java.util.ArrayList;

public class Student {
    //Attributes
    private String name;
    private ArrayList<Double> grades;
    
    //Constructors
    public Student() {
    }

    //Methods
    public double averageGrades(){
        if (this.grades.size() > 0) {
            double result = 0;
            for (int i = 0; i < this.grades.size(); i++){
                result += this.grades.get(i);
            }
            return result/this.grades.size();    
        } else {
            System.out.println("Enter the grades before you make the average.");
        }
        return -1;
    }

    public void addGrades(double grade){
            if (grade <=0 || grade > 5) {
                System.out.println("Please type a valid number");
                return;
            }
            this.grades.add(grade);
    }
    //Setters and Getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }
    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    //ToString()
    @Override
    public String toString() {
        return "Student [name=" + name + ", grades=" + grades + "]";
    }    
}
