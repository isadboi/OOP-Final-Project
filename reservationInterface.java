/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Ibrhaim
 * @author M Abdullah
 * @author M Hammad
 */
import java.util.ArrayList;
public interface reservationInterface {
    public String addReservation(ArrayList<Reservation> res ,Reservation r, ArrayList<Flight> fli ,int fID, ArrayList<Passenger> pss, int pCNIC);
    public String viewReservation(ArrayList<Reservation> res);
    public void cancelReservation(ArrayList<Reservation> res,int id);
}

