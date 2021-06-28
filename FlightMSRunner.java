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
import java.io.File;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class FlightMSRunner implements Serializable{
   static  ArrayList<Flight> flightArray = new ArrayList<>();
   static  ArrayList<Passenger> passengerArray = new ArrayList<>();
   static ArrayList<Reservation> reservationArray = new ArrayList<>();
   static Flight f = null;
   static Passenger p = new Passenger();
   static Reservation r =null;
   static Records re = null;
   static int co = 0;
   static File pass = new File("D:\\FlightMS.txt");
    public static void main(String[] args) throws NotSerializableException {
    Scanner input = new Scanner(System.in);
    ExceptionClass Ex = new ExceptionClass();
     while(true){
         System.out.println(" ----------------------------------- ");
         System.out.println(" Welcome to Flight Management System ");
         System.out.println(" ----------------------------------- ");
         System.out.println("Press 1)Flight 2)Passenger 3)Reservation 4)ViewAllRecords 5)Reset Records 6)Exit: ");
         int data = Ex.check_exception();
         if(data==1){
            FlightRecords(flightArray);
         }
         else if(data==2){
            PassengerRecords(passengerArray);
         }
         else if(data==3){
             Reservations(flightArray,passengerArray,reservationArray);
         }
         else if(data==4){
             viewAllRecords(flightArray,passengerArray,reservationArray);
         }
        else if(data==5){
             clearAllData();
         }
         else if(data==6){
             break;
         }
         else{
             System.out.println("Please Enter a Valid Number");
         }
     }
     
    
}
    private static void FlightRecords(ArrayList<Flight> flightArray) {
        Scanner input = new Scanner(System.in);
        ExceptionClass Ex = new ExceptionClass();
        try{
      while(true){
          System.out.println("Press 1)Add Flight Record 2)View Flight Record  3)Search Flight Record 4)Edit Flight Record 5)Delete Flight Record 6)Exit: ");
          int data = Ex.check_exception();
          if(data==1){
              while(true){
              boolean uniqueId = true;
              System.out.println("Enter the flight id:");
              int id = Ex.check_exception();
              for(int i = 0 ; i<flightArray.size() ; i++){
                  if(flightArray.get(i).getFlightNo()==id){
                      uniqueId = false;
                  }
              }
              if(uniqueId){
              System.out.println("Enter Flight Name: ");
              String name = input.next();
              System.out.println("Enter Flight Arrival: ");
              String arrival = input.next();
              System.out.println("Enter Flight Departure: ");
              String departure = input.next();
              System.out.println("Enter Flight origin: ");
              String origin = input.next();
              System.out.println("Enter Flight destination: ");
              String destination = input.next();
              System.out.println("Enter the total number of tickets of flight: ");
              int tickets = input.nextInt();
              f= new Flight(id,name,arrival,departure,origin,destination,tickets);
              f.addFlightRecord(flightArray, f);
              break;
              }
              else{
                  System.out.println("Please enter the valid and unique flight id:"); 
              }
              }
              
          }
          else if(data==2){
              String Fr = f.viewFlightRecord(flightArray);
              System.out.println(Fr);
          }
          else if(data==3){
              System.out.println("Enter Flight ID to search Records: ");
              int id = Ex.check_exception();
              System.out.println(f.searchFlightRecord(flightArray, id));
          }
          else if(data==4){
              System.out.println("Enter flight id to edit records: ");
              int id = Ex.check_exception();
              if(f.checkFlight(id, flightArray)){
              System.out.println("Enter new Flight ID: ");
              int ID = Ex.check_exception();
              System.out.println("Enter new Flight Name: ");
              String name = input.next();
              System.out.println("Enter new Flight Arrival: ");
              String arrival = input.next();
              System.out.println("Enter new Flight Departure: ");
              String departure = input.next();
              System.out.println("Enter new Flight origin: ");
              String origin = input.next();
              System.out.println("Enter new Flight destination: ");
              String destination = input.next();
              System.out.println("Enter new total no of tickets of flight: ");
              int tickets = input.nextInt();
              f= new Flight(ID,name,arrival,departure,origin,destination,tickets);
                  f.editFlightRecord(flightArray, f, id);
                  System.out.println("The Record has successfully changed");
                  System.out.println(f.viewFlightRecord(flightArray));
              }
              
          }
          else if(data==5){
              System.out.println("Enter Flight ID to delete record: ");
              int id = Ex.check_exception();
              
             if(f.checkFlight(id, flightArray)){
                 f.deleteFlightRecord(flightArray, id);
                 System.out.println("The Record has successfully deleted");
                  System.out.println(f.viewFlightRecord(flightArray));
              }
             else{
                 System.out.println("Enter correct ID for deleting records:");
             }
          }
          else if(data==6){
              break;
          }
          else{
              System.out.println("Invalid input given");
          }
      }
        }
        catch(NullPointerException ex){
            System.out.println("There is nothing in records");
        }
       
    }

    private static void PassengerRecords(ArrayList<Passenger> passengerArray) {
        ExceptionClass Ex = new ExceptionClass();
         Scanner input = new Scanner(System.in);
         while(true){
             System.out.println("Press 1)Add Passenger Record 2)View Passenger Record  3)Search Passenger Record 4)Edit Passenger Record 5)Delete Passenger Record 6)Exit: ");
             int data = Ex.check_exception();
             if(data==1){
              System.out.println("Enter Passenger CNIC: ");
              int CNIC = Ex.check_exception();
              if (co > 0){
              boolean unique_CNIC = p.compareId(passengerArray, CNIC);
              while (unique_CNIC == true){
                  System.out.println("CNIC exists, enter unique CNIC");
                  CNIC = Ex.check_exception();
                  unique_CNIC = p.compareId(passengerArray, CNIC);
              }}
                 System.out.println("Enter Passenger Name: ");
                 String name = input.next();
                 System.out.println("Enter Passenger Email: ");
                 String Email = input.next();
                 System.out.println("Enter Passenger phone no: ");
                 int phoneNO = Ex.check_exception();
                 p = new Passenger(CNIC,name,Email,phoneNO);
                 p.addPassenger(passengerArray, p);
                 co++;
              }
             else if(data==2){
                 String Pr = p.VP(passengerArray);
                 System.out.println(Pr);
             }
             else if(data==3){
                System.out.println("Enter Passenger ID to search Records: ");
                int id = Ex.check_exception();
                System.out.println(p.searchPassenger(passengerArray, id));  
             }
             else if(data==4){
                 System.out.println("Enter Passenger ID to edit Records: ");
                 int pCNIC = Ex.check_exception();
                 if(p.checkPassenger(pCNIC, passengerArray)){
                    System.out.println("Enter Passenger CNIC: ");
                    int CNIC = input.nextInt();
                    System.out.println("Enter Passenger Name: ");
                    String name = input.next();
                    System.out.println("Enter Passenger Email: ");
                    String Email = input.next();
                    System.out.println("Enter Passenger phone no: ");
                    int phoneNO = Ex.check_exception();
                    p = new Passenger(CNIC,name,Email,phoneNO);
                    p.editPassenger(passengerArray,p, pCNIC);
                     System.out.println("The record has successfully changed");
                    p.viewPassenger(passengerArray);
                    }
                 else{
                     System.out.println("Passenger CNIC not found!");
                 }
             }
             else if(data==5){
                 System.out.println("Enter CNIC to delete Passenger records: ");
                 int cnic = Ex.check_exception();
                 if(p.checkPassenger(cnic, passengerArray)){
                     p.deletePassenger(passengerArray, cnic);
                     System.out.println("The record has been successfully deleted");
                     p.viewPassenger(passengerArray);
                 }
                 else{
                     System.out.println("Enter correct id for deleting records");
                 }
             }
             else if(data==6){
                break;
             } 
             else{
                 System.out.println("Invalid input enter from above choices");
             }
         }}
    private static void Reservations(ArrayList<Flight> flightArray, ArrayList<Passenger> passengerArray,ArrayList<Reservation> reservationArray) throws NotSerializableException{
      Scanner input = new Scanner(System.in);
      ExceptionClass Ex = new ExceptionClass();
      try{
      while(true){
          System.out.println("Press 1)Add Reservation 2)View Reservation 3)Cancel Reservations 4)Exit: ");
          int data = Ex.check_exception();
          if(data==1){
              boolean checkFl = false;
              boolean checkPs = false;
              System.out.println("Enter the Flight id to choose your flight: ");
              System.out.println("\n");
              for(int i = 0 ; i<flightArray.size(); i++){
                  System.out.print(flightArray.get(i).getFlightNo()+"\t");
                  System.out.print(flightArray.get(i).getFlightName()+"\t");
                  System.out.print(flightArray.get(i).getFlightArrival()+"\t");
                  System.out.print(flightArray.get(i).getFlightDeparture()+"\t");
                  System.out.print(flightArray.get(i).getFlightSource()+"\t");
                  System.out.print(flightArray.get(i).getFlightDestination()+"\t");
                  System.out.println(flightArray.get(i).getTotalTickets());
                  System.out.println("\n");
              }
              System.out.println();
              int fID = Ex.check_exception();
              int CNIC= 0;
              for(int i = 0 ; i<flightArray.size() ; i++){
                  if(flightArray.get(i).getFlightNo()==fID){
                      checkFl = true;
                      f = flightArray.get(i);
                      System.out.println("Enter your correct CNIC to book tickets");
                      int cnic = Ex.check_exception();
                      for(int j = 0 ; j<passengerArray.size() ; j++){
                          if(passengerArray.get(j).getPassengerCNIC()==cnic){
                              p = passengerArray.get(i);
                              CNIC = cnic;
                              checkPs=true;
                              }
                      }
                  }   
              }
              if(checkFl && checkPs){
                              System.out.println("Enter reservation id to book tickets: ");
                              int rID = Ex.check_exception();
                              System.out.println("Enter  number of tickets you wanna book: ");
                              int bT = Ex.check_exception();
                              System.out.println("Enter reservation type : DOMESTIC or INTERNATIONAL?");
                              String type = input.next();
                              r= new Reservation(f,p,rID,bT,type);
                              String s = r.addReservation(reservationArray, r, flightArray, fID, passengerArray, CNIC);
                              System.out.println(s);
                              r.storeDataInFile(reservationArray);
              }
              else{
                  System.out.println("Flight and Passenger not found");
              }
          }
          
          else if(data==2){
              String vR = r.viewReservation(reservationArray);
              System.out.println(vR);
              r.readFile(pass, reservationArray);
          }
          else if(data==3){
              System.out.println("Enter the Reservation id to cancel Reservations: ");
              int ID = Ex.check_exception();
              if(r.checkReservation(reservationArray,ID )){
                  r.checkReservation(reservationArray, ID);
              }
          }
          else if(data==4){
              break;
          }
          else{
              System.out.println("Please enter a valid digit");
          }
      }
      }
      catch(NullPointerException ex){
          System.out.println("There are no reservation records");
      }
     
    }

    private static void viewAllRecords(ArrayList<Flight> flightArray, ArrayList<Passenger> passengerArray,ArrayList<Reservation> reservationArray) {
      re = new Records(flightArray,passengerArray,reservationArray);
      String s = re.ViewAllRecords(flightArray, passengerArray, reservationArray);
        System.out.println(s);
    }
     private static void clearAllData() {
       re.clearAllrecords(reservationArray,flightArray, passengerArray);
    }

}

