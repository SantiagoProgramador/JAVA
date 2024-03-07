import javax.swing.*;
import java.util.ArrayList;

public class travelPlanner {
    public static void main(String[] args) {
        ArrayList<String> travel_list = new ArrayList<>();
        int option = 0;



        do {
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog("""
                        Welcome to the travel planner!
                        Type a number according to the following options:
                        1. Add a city.
                        2. Remove a city.
                        3. Show the cities in the travel.
                        4. Calculate total distance.
                        5. EXIT.
                        """));

                switch (option){
                    case 5:
                        JOptionPane.showMessageDialog(null,"Thanks for using the travel panel!");
                        break;
                    case 1:
                        String city = JOptionPane.showInputDialog("Type the city :D");
                        if (travel_list.contains(city)){
                            JOptionPane.showMessageDialog(null,"The city is already in the list!");
                            break;
                        }
                        if (city.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Please type a city.");
                            break;
                        }
                        travel_list.add(city);
                        JOptionPane.showMessageDialog(null,"City added successfully!");
                        break;
                    case 2:
                        String removeCity = JOptionPane.showInputDialog("Type the city you want to remove");
                        if (travel_list.remove(removeCity)){
                            JOptionPane.showMessageDialog(null, removeCity + " Removed successfully.");
                        }
                        break;
                    case 3:
                        if (travel_list.isEmpty()){
                            JOptionPane.showMessageDialog(null,"There is not cities to show!");
                        } else {
                            JOptionPane.showMessageDialog(null,"Cities in your travel: " + travel_list.toString());
                        }

                        break;
                    case 4:
                        double cityDistances = 0;
                        if (travel_list.isEmpty()){
                            JOptionPane.showMessageDialog(null,"The list does not have any city!");
                            break;
                        }
                        for (String s : travel_list) {
                            cityDistances += Double.parseDouble(JOptionPane.showInputDialog("Type the distance of the " + s + " city"));
                        }
                        JOptionPane.showMessageDialog(null,"The total distance is: " + cityDistances);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Please type a number between 1 and 5.");
                        break;
                }

            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Please type a valid option!" + e);
            }

        } while (option != 5);
    }
}
