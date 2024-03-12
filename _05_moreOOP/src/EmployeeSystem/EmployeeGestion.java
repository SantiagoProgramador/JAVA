package EmployeeSystem;

import java.util.ArrayList;


public class EmployeeGestion{
    //Attributes
    private ArrayList<Employee> employees = new ArrayList<>();
    //Constructors
    public EmployeeGestion(){
        this.employees = new ArrayList<>();
    }
    //Methods
    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
    public boolean removeEmployees(int id){
        return this.employees.removeIf(employee -> employee.getIdEmployee() == id);
    }
    public void showEmployees(){
        for (Employee employee : this.employees){
            System.out.println("Current employees: "+ " Id: " + employee.getIdEmployee() + " Name: " + employee.getName()
             + "  Age: " + employee.getSalary() + " Salary: " + employee.getSalary());
        }
    }
    //Setters and getters

    //ToString
}