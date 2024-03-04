// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);

        try {
                System.out.println("""
                    Hello and welcome, type the number for the operation you want to make \s
                     1.Calculator\s
                     2.Age verifier\s
                     3.Unit converter \s
                     4.IMC\s
                     5.number classifier\s
                     6.Days in a month\s
                     7.Average calculation\s
                     8.leap-year calculator\s
                     9.Tip calculator\s
                     10.Order three numbers \s
                     11.Horoscope generator \s
                     12.Taxi fare \s
                     13.Temperature converter \s
                     14.Qualification System.\s
                     Choose an option:"""
                );

                int userChose = scanner.nextInt();
                switch (userChose) {
                    case 1:
                        Calculator calculator = new Calculator(scanner);
                        calculator.startCalculator();
                        break;
                }
                scanner.close();
        } catch (Exception e){
            System.out.print("Please enter a valid field");
        }
    }
}

