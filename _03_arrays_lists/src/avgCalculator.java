import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class avgCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] studentsGrades = new double[10];

        double totalSum = 0;

        for (int i = 0; i < 10; i++){
           try {
               System.out.println("Type the grades of the student #" + (i + 1));
               studentsGrades[i] = scanner.nextDouble();
               totalSum += studentsGrades[i];
           } catch (Exception e){
               System.out.println("Please enter a valid number");
               break;
           }
        }
        double average = (totalSum/studentsGrades.length);

        System.out.println(Arrays.toString(studentsGrades));
        System.out.println("The average of the grades are: " + average);
    }
}