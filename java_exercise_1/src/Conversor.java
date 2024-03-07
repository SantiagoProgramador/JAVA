import java.util.Scanner; 

public class Conversor {
    
    public Conversor(){

    }

    public  void Converseitor() {
        
        Scanner scanner = new Scanner(System.in);
        double mile = 1.60936; 
        
        System.out.println("""
                Welcome to the unities conversor:
                Type a distance in kilometers:
                """);
        double distance = scanner.nextDouble();

        System.out.println("The result is: " + (distance * mile) + " miles");



    }
}
