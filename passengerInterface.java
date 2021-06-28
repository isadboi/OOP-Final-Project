/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Ibrahim
 * @author M Abdullah
 * @author M Hammad
 */
import java.util.ArrayList;
public interface passengerInterface {
    public void addPassenger(ArrayList<Passenger> addP, Passenger p);
    public String VP(ArrayList<Passenger> vP);
    public String searchPassenger(ArrayList<Passenger> searchP, int id);
    public void editPassenger(ArrayList<Passenger> editP, Passenger p, int id);
    public void deletePassenger(ArrayList<Passenger> delP, int id);
}

