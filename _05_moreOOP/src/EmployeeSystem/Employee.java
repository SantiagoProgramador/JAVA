package EmployeeSystem;

public class Employee extends Person{
    //Attributes
    private int idEmployee;
    private double salary;
    
    //Constructors
    public Employee(){}
    public Employee(int idEmployee, double salary) {
        this.idEmployee = idEmployee;
        this.salary = salary;
    }
    public Employee(String name, int age, int idEmployee, double salary) {
        super(name, age);
        this.idEmployee = idEmployee;
        this.salary = salary;
    }
    //Methods

    //Setters and getters
    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    //ToString
}
