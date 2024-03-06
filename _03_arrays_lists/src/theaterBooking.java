import java.util.Arrays;
import java.util.Scanner;

public class theaterBooking {
    public static void main(String[] args){
        boolean[][] theaterSeats = new boolean[5][10];

        Scanner scanner = new Scanner(System.in);
        int option;
        int row,seat;

        do {
            System.out.println("""
                    \nWelcome to the theater booking system.
                    1. Book a seat.
                    2. Cancel a book.
                    3. Show available seats.
                    4. Show all the available and void seats.
                    5. EXIT.
                    Please type an option.
                    """);

            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("Type the row (1-5)");
                     row = scanner.nextInt() -1;
                    System.out.println("Type the seat (1-10)");
                     seat = scanner.nextInt() -1;
                    if (!theaterSeats[row][seat]){
                        theaterSeats[row][seat] = true;
                        System.out.println("Seat booked successfully");
                    } else {
                        System.out.println("The seat you are trying to book its already occupied");
                    }
                    break;
                case 2:
                    System.out.println("Type the row (1-5)");
                    row = scanner.nextInt() -1;
                    System.out.println("Type the seat (1-10)");
                    seat = scanner.nextInt() -1;
                    if (!theaterSeats[row][seat]){
                        System.out.println("This seat is not booked.");
                    } else {
                        System.out.println("Booking cancelled successfully");
                        theaterSeats[row][seat] = false;
                    }
                    break;
                case 3:
                    System.out.println("Available seats:");
                    for (int i = 0; i < theaterSeats.length; i++){
                        System.out.print("\nRow #" + (i+1)+ ": ");
                        for (int j = 0; j < theaterSeats[i].length; j++){
                            if (theaterSeats[i][j]){
                                System.out.println("seat #" + (j+1) + "✅");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("All seats:");
                    int occupied = 0, available = 0;
                    for (int i = 0; i < theaterSeats.length; i++){
                        System.out.print("\nRow #" + (i+1) + ": ");
                        for (int j = 0; j < theaterSeats[i].length; j++){
                            if (theaterSeats[i][j]){
                                System.out.print("seat #" + (j+1) + "✅ ");
                                occupied++;
                            } else {
                                System.out.print("seat #" + (j+1) + "❌ ");
                                available++;
                            }
                        }
                    }
                    System.out.println("\nTotal of occupied seats:" + occupied);
                    System.out.println("Total of available seats:" + available);

                    break;
                case 5:
                    System.out.println("Thanks and have a nice day!");
                    break;
                default:
                    System.out.println("Please type a valid option.");
                    break;
            }
        } while (option != 5);

    }
}
