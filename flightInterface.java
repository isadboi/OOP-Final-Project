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
public interface flightInterface {
    public void addFlightRecord(ArrayList<Flight> addRecord , Flight f1 );
    public String viewFlightRecord(ArrayList<Flight> viewRecord);
    public String searchFlightRecord(ArrayList<Flight> searchRecord, int id);
    public void editFlightRecord(ArrayList<Flight> editRecord , Flight f1, int id);
    public void deleteFlightRecord(ArrayList<Flight> deleteRecord , int id);
}

