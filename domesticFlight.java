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
 * @author M Hammmad
 */
public class domesticFlight extends Reservation{
    static String type;
    domesticFlight(){
        type = null;
    }
    public static String getDomestic(){
        type = "domestic";
        return type;
    }
}

