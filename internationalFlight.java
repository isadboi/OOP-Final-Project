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
public class internationalFlight extends Reservation{
    static String type;
    internationalFlight(){
        type = null;
    }
    public static String getInternational(){
        type = "international";
        return type;
    }
}

