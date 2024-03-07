import java.util.Scanner;

public class IMC {
    
    public IMC(){

    }

    public void IMC_calculator(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
            Welcome to the IMC Calculator.
            Type your height in meters:
        """);
        double height = scanner.nextDouble();
        System.out.println("Type your weight in kilograms:");
        double weight = scanner.nextDouble();
        System.out.println("Your IMC is: " + (weight/(height*height)));
        
    }
}
