import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class min_maxNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        int[] numbers = new int[5];


        System.out.print("Welcome to the max and min number calculator.");

        for (int i = 0; i < numbers.length; i++){
            System.out.println(" Type the numbers");
            numbers[i] = scanner.nextInt();

        }
        System.out.println(Arrays.toString(numbers));
        int minor = numbers[0];
        int mayor = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if (mayor < numbers[i]){
                mayor = numbers[i];
            }
            if (minor > numbers[i]){
                minor = numbers[i];
            }
        }
        System.out.println(mayor);
        System.out.println(minor);

        int[] newArray = numbers;

    }

}
