import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


// import figures.GeometricFigure;

// import figures.Circle;
// import figures.Rectangle;
// import figures.Square;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // POINT #1
        /*Book book = new Book();*/

        // POINT #2
        /*Employee employee = new Employee();
        Employee employee1 = new Employee("pepe","papo",1000,10);
        */
        //Below you can test both programs,


        /*-----------------------------------------------------------------------------------------------------------*/

        // POINT #3
        /*bankAccount bankAccount = new bankAccount("pepe",19999);

        System.out.println("Welcome to your bankAccount " + bankAccount.getOwner() + " Your balance is " + bankAccount.getBalance());

        System.out.println("Type the ammount you want to retire: ");
        double decrement = scanner.nextDouble();
        bankAccount.decreaseBalance(decrement);

        System.out.println("Type the ammount you want to add: ");
        double increment = scanner.nextDouble();
        bankAccount.increaseBalance(increment);*/

        // POINT #4
        /*Circle circle = new Circle(2);
        System.out.println(circle.calculateArea());

        Rectangle rectangle = new Rectangle(2,4);
        System.out.println(rectangle.calculateArea());

        Square square = new Square(4);
        System.out.println(square.calculateArea());*/

        //POINT 5
        /*Product objProduct = new Product();

        int increment = scanner.nextInt();
        objProduct.addStock(increment);
        System.out.println(objProduct.getStock());

        int decrement = scanner.nextInt();
        objProduct.removeStock(decrement);
        System.out.println(objProduct.getStock());*/
        
        //POINT 6
        Student objStudent = new Student();
        objStudent.setName("pepe");
        ArrayList<Double> grade = new ArrayList<>(Arrays.asList(2.0,1.0,3.0,4.0,2.0));

        objStudent.setGrades(grade);
        System.out.println("Hello");
        System.out.println(objStudent.getName());

        System.out.println(objStudent.averageGrades());
        objStudent.addGrades(5);
        System.out.println(objStudent.getGrades());

        scanner.close();
    }
}
