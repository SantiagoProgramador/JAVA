import java.util.Scanner;

public class Calculator {

    //Encapsulation
    private final Scanner scanner;

    public Calculator(Scanner scanner){
        this.scanner = scanner;
    }

    public void startCalculator(){
        System.out.println("""
                        Hello and welcome, type a number  \s
                         1.Sum\s
                         2.Multiply\s
                         3.Divide\s
                         4.Rest\s
                         5.exit""");

        System.out.println("Type the number:");
        int userSelection = scanner.nextInt();
        int userN1;
        int userN2;

        switch (userSelection) {
            case 1:
                System.out.println("Type the first number");
                userN1 = scanner.nextInt();
                System.out.println("Type the second number");
                userN2 = scanner.nextInt();
                System.out.println("The result is:" + (userN1 + userN2));
                break;

            case 2:
                System.out.println("Type the first number");
                userN1 = scanner.nextInt();
                System.out.println("Type the second number");
                userN2 = scanner.nextInt();
                System.out.println("The result is:" + (userN1 * userN2));
                break;
        }
        scanner.close();
    }

}
