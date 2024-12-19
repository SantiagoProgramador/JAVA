import javax.swing.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        /* Simple counter */

        /*
         * for (int i = 1; i <= 10; i++) {
         * System.out.println(i);
         * }
         * 
         *//* Summing each number until 100 *//*
                                               * int counter = 0;
                                               * int totalSume = 0;
                                               * 
                                               * while (counter <= 100) {
                                               * totalSume += counter++;
                                               * 
                                               * }
                                               * System.out.println(totalSume);
                                               * 
                                               *//* Multiplying *//*
                                                                   * for (int i = 1; i <= 10; i++) {
                                                                   * System.out.println("Tabla de " + i);
                                                                   * for (int j = 1; j <= 10; j++) {
                                                                   * System.out.println(i + " * " + j + " = " + (i*j));
                                                                   * }
                                                                   * }
                                                                   * 
                                                                   *//* VIRTUAL ATM *//*
                                                                                       * String option;
                                                                                       * double balance = 1000;
                                                                                       * do {
                                                                                       * option =
                                                                                       * JOptionPane.showInputDialog(
                                                                                       * null, """
                                                                                       * Menu options:
                                                                                       * 1.Check balance.
                                                                                       * 2.Deposit money.
                                                                                       * 3.Get money.
                                                                                       * 4. EXIT.
                                                                                       * """
                                                                                       * );
                                                                                       * 
                                                                                       * switch (option){
                                                                                       * case "1":
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Your balance until now is: $"
                                                                                       * +balance);
                                                                                       * break;
                                                                                       * 
                                                                                       * case "2":
                                                                                       * String dMoney =
                                                                                       * JOptionPane.showInputDialog(
                                                                                       * null,"Put the amount you want to send\n"
                                                                                       * );
                                                                                       * try {
                                                                                       * double newBalance =
                                                                                       * Double.parseDouble(dMoney);
                                                                                       * if (newBalance <= 0){
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Please enter a valid field"
                                                                                       * );
                                                                                       * break;
                                                                                       * }
                                                                                       * balance += newBalance;
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Money send successfully:"
                                                                                       * + balance);
                                                                                       * } catch (Exception e){
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Please enter a valid field"
                                                                                       * );
                                                                                       * }
                                                                                       * break;
                                                                                       * case "3":
                                                                                       * String reduceBalance =
                                                                                       * JOptionPane.showInputDialog(
                                                                                       * null,"Put the money you want to get:"
                                                                                       * );
                                                                                       * try{
                                                                                       * double reduceBalanceN =
                                                                                       * Double.parseDouble(
                                                                                       * reduceBalance);
                                                                                       * if (reduceBalanceN <= 0){
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Please enter a valid field"
                                                                                       * );
                                                                                       * break;
                                                                                       * }
                                                                                       * 
                                                                                       * if (reduceBalanceN > balance){
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Insufficient , your actual balance is: "
                                                                                       * + balance);
                                                                                       * break;
                                                                                       * }
                                                                                       * balance -= reduceBalanceN;
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Your new balance is:" +
                                                                                       * balance);
                                                                                       * }
                                                                                       * 
                                                                                       * catch (Exception e){
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Please enter a valid field"
                                                                                       * );
                                                                                       * }
                                                                                       * break;
                                                                                       * default:
                                                                                       * JOptionPane.showMessageDialog(
                                                                                       * null,"Please enter a valid field"
                                                                                       * );
                                                                                       * break;
                                                                                       * }
                                                                                       * 
                                                                                       * } while (!option.equals("4"));
                                                                                       */

        /* compound interest calculator */
        String calculator;

        double initialCapitalN = 0;
        double annualInterestN = 0;
        double yearsN = 0;

        do {

            if (yearsN != 0 && annualInterestN != 0 && initialCapitalN != 0) {
                double v = initialCapitalN * Math.pow((1 + annualInterestN), yearsN);
                yearsN = 0;
                initialCapitalN = 0;
                annualInterestN = 0;
                JOptionPane.showMessageDialog(null, "The resul is:" + v);
            }

            calculator = JOptionPane.showInputDialog(null, """
                     Welcome to the compound interest calculator!, please complete the fields:
                    1.Initial capital.
                    2.annual interest.
                    3.Years.
                    4.EXIT.
                    """);
            switch (calculator) {
                case "1":
                    String initialCapital = JOptionPane.showInputDialog(null, "Enter the initial capital:");
                    try {
                        initialCapitalN = Double.parseDouble(initialCapital);
                        if (initialCapitalN <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid field");
                            initialCapitalN = 0;
                            break;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Field must be a number");
                    }
                    break;
                case "2":
                    String annualInterest = JOptionPane.showInputDialog(null, "Enter the current annual interest:");
                    try {
                        annualInterestN = Double.parseDouble(annualInterest);

                        if (annualInterestN <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid field");
                            annualInterestN = 0;
                            break;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Field must be a number");
                    }
                    break;
                case "3":
                    String years = JOptionPane.showInputDialog(null, "Enter the amount of years:");
                    try {
                        yearsN = Double.parseDouble(years);
                        if (yearsN <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid field");
                            yearsN = 0;
                            break;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Field must be a number");
                    }

                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Thanks four using the compound interest calculator.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please enter a valid field");
                    break;
            }
        } while (!calculator.equals("4") || calculator.equals(" "));

        /* Verify prime number */
        /*
         * String primeVerifier;
         * do {
         * int contador = 0;
         * 
         * primeVerifier = JOptionPane.showInputDialog(
         * null,"Welcome to the prime verifier \n Please type a number. \n type 0 to quit."
         * );;
         * int primeVerifierN = Integer.parseInt(primeVerifier);
         * for (int i = 1; i <= primeVerifierN; i++){
         * if (primeVerifierN % i == 0) {
         * contador++;
         * }
         * if (i == primeVerifierN) {
         * if (contador == 2) {
         * JOptionPane.showMessageDialog(null,"Your number is a prime number");
         * } else {
         * JOptionPane.showMessageDialog(null,"Your number is not a prime number");
         * }
         * }
         * }
         */

        /*
         * if (contador > 1){
         * JOptionPane.showMessageDialog(null,"Your number is not a prime number");
         * break;
         * } else {
         * JOptionPane.showMessageDialog(null,"Your number is a prime number");
         * break;
         * }
         */

        /*
         * try {
         * }catch (Exception e){
         * JOptionPane.showMessageDialog(null,"Please type a valid number");
         * }
         */
        /* } while (!primeVerifier.equals("0")); */

        /*
         * Random random = new Random();
         * int randomNum = random.nextInt(100) +1;
         * System.out.println(randomNum);
         * int option = 0;
         * 
         */
        /*
         * double randomNum = Math.floor(Math.random());
         * double option = 0;
         * JOptionPane.showMessageDialog(
         * null,"Guest the number between 1 and 100 \n Type 0 to Exit.");
         *//*
            * 
            * do {
            * try {
            * option =
            * Integer.parseInt(JOptionPane.showInputDialog("Type the number! (0 to EXIT.)")
            * );
            * 
            * if (option == randomNum){
            * JOptionPane.showMessageDialog(null,"Congratulations you won the game!");
            * option = 0;
            * } else {
            * JOptionPane.showMessageDialog(null,"Keep trying!");
            * }
            * }catch (Exception e){
            * JOptionPane.showMessageDialog(null,"Please type a valid number");
            * }
            * } while (option != 0);
            * 
            * int pairCOunter = 0;
            * System.out.println("Summing pair numbers.");
            * for (int i = 1; i < 101; i++){
            * if (i % 2 == 0){
            * System.out.println(i);
            * pairCOunter += i;
            * }
            * }
            * System.out.println("The result is: " + pairCOunter);
            */

    }
}