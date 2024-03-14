import CourseSystem.CourseSystem;
import CourseSystem.Course;

import EmployeeSystem.Employee;
import EmployeeSystem.EmployeeGestion;
import EmployeeSystem.PermanentEmployee;

// import InventorySystem.Inventory;
// import InventorySystem.Product;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // POINT #1 INVENTORY SYSTEM.
        /*Inventory inventory = new Inventory();
        Product product = new Product();*/
        /*Product product1 = new Product(1,"pencil",2000);
        Product product2 = new Product(2,"notebook",9000);
        Product product3 = new Product(3,"eraser",1000);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);*/

        /*String option;
        do {
            try {
                System.out.println("""
                        Welcome to your inventory control system.
                        1. Add a product.
                        2. Delete a product.
                        3. Show products.
                        4. Search products by name or category.
                        5. Exit
                        Select an option.
                        """);

                option = scanner.nextLine();
                switch (option){
                    case "1":
                        System.out.println("Type the id of the product");
                        int idSent = scanner.nextInt();
                        System.out.println("Type the name of the product: ");
                        String nameSent = scanner.next();
                        System.out.println("Type the price of the product: " + nameSent);
                        double priceSent = scanner.nextDouble();

                        Product addedProduct = new Product(idSent,nameSent,priceSent);
                        inventory.addProduct(addedProduct);
                        System.out.println("Product added successfully.");

                        System.out.println("type any key to return to the menu.");

                        scanner.next();
                        break;
                    case "2":
                        System.out.println("""
                            Type the id of the product you want to remove from the list.
                            Available products at the moment:\s
                            """);
                        for (Product element : inventory.getProducts()){
                            System.out.println(element.getId() + " " + element.getName());
                        }
                        idSent = scanner.nextInt();

                        inventory.removeProduct(idSent);
                        System.out.println("Product removed successfully.");
                        System.out.println("type any key to return to the menu.");

                        scanner.next();
                        break;
                    case "3":
                        System.out.println("Below are the current products: ");
                        inventory.showProducts();

                        System.out.println("type any key to return to the menu.");

                        scanner.next();
                        break;
                    case "4":
                        System.out.println(inventory.filtrateProductsbyName("pencil"));

                        System.out.println("type any key to return to the menu.");
                        scanner.next();
                        break;
                    case "5":
                        System.out.println("Thanks for using your inventory system.");
                        break;
                }
            } catch (Exception e){
                System.out.println("Please enter a valid value!");
                break;
            }


        } while (!option.equals("5"));
        */

        //POINT #2 Employees register system.
        /*EmployeeGestion employeeGestion = new EmployeeGestion();

        Employee employee = new PermanentEmployee("Pepe",20,1,20000);
        Employee employee2 = new Employee("Papo",10,2,22000);
        Employee employee3 = new Employee("Papa",25,3,21000);

        employeeGestion.addEmployee(employee);
        employeeGestion.addEmployee(employee2);
        employeeGestion.addEmployee(employee3);


        employeeGestion.showEmployees();
        System.out.println("---------------------------------------------------------------------");
        employeeGestion.removeEmployees(2);
        employeeGestion.showEmployees();*/
        Employee employee = new Employee();
        EmployeeGestion employeeGestion = new EmployeeGestion();
        String option = null;

        do {
            try {
                System.out.println("""
                        1. Add a employee.
                        2. Remove a employee.
                        3. Show employees.
                        4. Exit.
                        """);
                option = scanner.next();

                switch (option){
                    case "1":
                        System.out.println("""
                                    Type the data of the employee.
                                    Name:
                                    """);
                        String name = scanner.next();
                        System.out.println("Age:");
                        int age = scanner.nextInt();
                        System.out.println("Id:");
                        int id = scanner.nextInt();
                        System.out.println("Salary:");
                        double salary = scanner.nextDouble();

                        employee = new Employee(name,age,id,salary);
                        System.out.println("Employee added successfully!");
                        employeeGestion.addEmployee(employee);
                        break;
                    case "2":
                        System.out.println("""
                                    Type the id of the employee you want to remove:
                                    """);
                         id = scanner.nextInt();
                        if (employeeGestion.removeEmployees(id)){
                            System.out.println("Employee removed successfully!");

                        } else {
                            System.out.println("The employee was not found!");
                        }
                        break;
                    case "3":
                        employeeGestion.showEmployees();
                        break;
                    case "4":
                        System.out.println("Closing the employee management system...");
                        break;
                }

            } catch (Exception e){
                System.out.println("An error occurred unexpectedly");
            }
        } while (!option.equals("4"));
        
        //POINT #3 Course management system
        /*CourseSystem courseSystem = new CourseSystem();
        Course course = new Course();

        String option = null;

        do {
            try {
                System.out.println("""
                        1. Admin courses.
                        2. Admin Students.
                        3. EXIT.
                        Select an option:
                        """);
                option = scanner.nextLine();

                switch (option){
                    case "1":
                        String option2 = null;
                        do {
                            System.out.println("""
                                        Administrate courses:
                                        1. Create a course.
                                        2. Search a course by its code.
                                        3. Show current courses.
                                        4. Exit.
                                        """);
                            option2 = scanner.nextLine();
                            switch (option2){
                                case "1":
                                    courseSystem.addCourse(scanner);
                                    break;
                                case "2":
                                    System.out.println("Type the code of the course.");
                                    String code = scanner.next();
                                    System.out.println(courseSystem.findCode(code).toString());
                                    break;
                                case "3":
                                    courseSystem.showCourses();
                                    break;
                                case "4":
                                    System.out.println("Closing the administration menu...");
                                    break;

                            }
                        } while (!option2.equals("4"));
                        break;
                    case "2":
                        String option3 = null;
                            do {
                                System.out.println("""
                                    Administrate students:
                                    1. Add student
                                    2. Remove student
                                    3. Show students
                                    4. Exit
                                    """);
                                option3 = scanner.next();
                                switch (option3){
                                    case "1":
                                        if(!courseSystem.showCourses()){
                                            break;
                                        }
                                        System.out.println("Type the code of the course you want to add the student");
                                        String code = scanner.next();

                                        course = courseSystem.findCode(code);
                                        if (course == null){
                                            System.out.println("Course was not found!");
                                        } else {
                                            course.addStudent(scanner);
                                        }
                                        break;
                                    case "2":
                                        if(!courseSystem.showCourses()){
                                            break;
                                        }
                                        System.out.println("Type the code of the course you want to remove the student");
                                         code = scanner.next();

                                        course = courseSystem.findCode(code);
                                        if (course == null) {
                                            System.out.println("Course was not found!");
                                        } else {
                                            course.removeStudent(scanner);
                                        }
                                        break;
                                    case "3":
                                        course.showStudents();
                                        break;
                                    case "4":
                                        System.out.println("Closing the administration menu...");
                                        break;
                                    default:
                                        System.out.println("Please insert a valid value!");
                                        break;
                                }
                            }while (!option3.equals("4"));
                        break;
                    case "3":
                        System.out.println("Thanks for using your Course management system");
                        break;
                }

            }catch (Exception e){
                System.out.println("Please type a valid value!" + e);
            }

        }while (!option.equals("3"));
*/

        scanner.close();
    }
}
