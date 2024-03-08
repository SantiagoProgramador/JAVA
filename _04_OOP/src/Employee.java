public class Employee {

    //Attributes
    private String employeeName;
    private String employeeCharge;
    private double employeeSalary;
    private int employeeId;


    //Constructors
    public Employee(){}
    public Employee(String employeeName, String employeeCharge, double employeeSalary, int employeeId) {
        this.employeeName = employeeName;
        this.employeeCharge = employeeCharge;
        this.employeeSalary = employeeSalary;
        this.employeeId = employeeId;
    }

    //Methods
    public void increaseSalary(int percentage){
        this.employeeSalary += (this.employeeSalary * percentage)/100;
    }

    //Setters and Getters
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCharge() {
        return employeeCharge;
    }

    public void setEmployeeCharge(String employeeCharge) {
        this.employeeCharge = employeeCharge;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    //To string
    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeCharge='" + employeeCharge + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeId=" + employeeId +
                '}';
    }
}
