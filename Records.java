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
public class Records extends Reservation{
    ArrayList<Flight> flightArray ;
   ArrayList<Passenger> passengerArray ;
    ArrayList<Reservation> reservationArray;
    
    Records(){
        this.flightArray  = null;
        this.passengerArray = null;
        this.reservationArray = null;
    }
    Records(ArrayList<Flight> f, ArrayList<Passenger> p,ArrayList<Reservation> r){
        this.flightArray  = f;
        this.passengerArray = p;
        this.reservationArray = r;
    }
   public String ViewAllRecords(ArrayList<Flight> fli , ArrayList<Passenger> pss , ArrayList<Reservation> rs){
       String st = "";
       st+="Flight No"+"\t"+"Flight Name"+"\t"+"Flight Arrival"+"\t"+"Fight Departure"+"\t"+"Flight Source"+"\t"+"Flight Destination"+"\t"+"Total Tickets";
       st+="\n";
       for(int i = 0 ; i<fli.size(); i++){
           st+=fli.get(i).getFlightNo()+"\t\t";
           st+=fli.get(i).getFlightName()+"\t\t";
           st+=fli.get(i).getFlightArrival()+"\t\t";
           st+=fli.get(i).getFlightDeparture()+"\t\t";
           st+=fli.get(i).getFlightSource()+"\t\t";
           st+=fli.get(i).getFlightDestination()+"\t\t";
           st+=fli.get(i).getTotalTickets()+"\n";
           
           
       }
       st+="\n";
      st+="Passenger CNIC"+"\t"+"Passenger Name"+"\t"+"Passenger Email"+"\t"+"Passenger phone NO"+"\n";
      for(int i = 0 ; i<pss.size() ; i++){
          st+=pss.get(i).getPassengerCNIC()+"\t\t";
          st+=pss.get(i).getPassengerName()+"\t\t";
          st+=pss.get(i).getPassengerEmail()+"\t\t";
          st+=pss.get(i).getPassengerPhoneNo()+"\n";
      }
      st+="\n";
      st+="Flight No"+"\t"+"Passenger CNIC"+"\t"+"Reservation ID"+"\t"+"Tickets";
      st+="\n";
      for(int i = 0 ; i<rs.size() ; i++){
          st+=rs.get(i).getFlight().getFlightNo()+"\t\t";
          st+=rs.get(i).getPassenger().getPassengerCNIC()+"\t\t";
          st+=rs.get(i).getreservationID()+"\t\t";
          st+=rs.get(i).getbookedTickets()+"\n";
      }
     return st; 
   }
   void clearAllrecords(ArrayList<Reservation> res , ArrayList<Flight> fli , ArrayList<Passenger> pss){
       res.clear();
       pss.clear();
       fli.clear();
       
   }
   
    
}

