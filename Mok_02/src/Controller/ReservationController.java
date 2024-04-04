package Controller;

import Model.ReservationModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {
    ReservationModel reservationModel = new ReservationModel();

    public boolean isEmpty(){
        if (reservationModel.read().isEmpty()){
            JOptionPane.showMessageDialog(null,"There is no reservations to show!");
            return true;
        }
        return false;
    }
    public void addReservation(){

    }
    public List<String> showReservations(){
        List<String> list = new ArrayList<>();

        return list;
    }
    public void deleteReservation(){

    }
    public void filterById(){

    }
    public void updateReservation(){

    }
}
