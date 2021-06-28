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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class Reservation extends Flight implements reservationInterface, Serializable{
 private Flight fl;
 private Passenger pa;
 private int reservationID;
 private int bookedTickets;
 private String reservationType;
  
  Reservation(){
      this.fl = null;
      this.pa = null;
      this.reservationID=0;
      this.bookedTickets = 0;
      this.reservationType = null;
  }
  Reservation(Flight fl , Passenger pa , int resID , int bookT, String type){
      this.fl = fl;
      this.pa = pa;
      this.reservationID = resID;
      this.bookedTickets = bookT;
      if (type.equals("domestic") || type.equals("Domestic")){
          this.reservationType = domesticFlight.getDomestic();
      }
      else {
          this.reservationType = internationalFlight.getInternational();
      }
  }
  public String addReservation(ArrayList<Reservation> res ,Reservation r, ArrayList<Flight> fli ,int fID, ArrayList<Passenger> pss, int pCNIC){
      String st = "";
      int availableTickets =0;
      int left=0;
      boolean cF = false;
      boolean cP = false;
      boolean enoughTickets = false;
          for(int i = 0 ; i<fli.size() ; i++){
              if(fID==fli.get(i).getFlightNo()){
                  cF=true;
                  for(int j = 0 ; j<pss.size() ; j++){
                      if(pCNIC==pss.get(j).getPassengerCNIC()){
                        cP=true;
                        availableTickets = fli.get(i).getTotalTickets();
                        if(r.getbookedTickets()<=availableTickets){
                        left = availableTickets - r.getbookedTickets();
                        fli.get(i).totalTickets=left;
                        res.add(r);
                        enoughTickets = true;
                        }
                        }
                      }
          }
       }
          if(cF && cP){
              st+="The tickets have been successfully booked";
          }
          else{
              if(!enoughTickets){
                  st+="Sorry this flight has no"+r.getbookedTickets()+" tickets";
              }
              else{
              st+="Sorry such flight and booked passengers doesnot exist";
              }
          }
          return st;
  }
  public void storeDataInFile(ArrayList<Reservation> res){
      File flightData = new File("D:\\Flight.txt");
      try {
          try ( 
                  ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(flightData))) {
              for (int i = 0; i<res.size(); i++){
                  ob.writeObject(res.get(i));
              }
          }
      }
      catch (FileNotFoundException e){
          e.printStackTrace();
      }
      catch (IOException e){
          e.printStackTrace();
      }
      readFile(flightData, res);
  }
  public void readFile(File f, ArrayList<Reservation> res){
      try {
          ObjectInputStream ob = new ObjectInputStream(new FileInputStream(f));
          Reservation r = (Reservation)ob.readObject();
          System.out.println(" Flight: " +r.fl+ " Passenger : " +r.pa+ " Reservation id: " +r.reservationID+ " Booked Tickets: " +r.bookedTickets+ " Reservation Type: " +r.reservationType);
      }
      catch (ClassNotFoundException e){
          e.printStackTrace();
      }
      catch (FileNotFoundException e){
          e.printStackTrace();
      }
      catch (IOException e){
          e.printStackTrace();
      }
  }
 @Override
  public String viewReservation(ArrayList<Reservation> res){
      String st = "";
      st+="Flight No"+"\t"+"Passenger CNIC"+"\t"+"Reservation ID"+"\t"+"Tickets"+"\t"+"Reservation Type";
      st+="\n";
      for(int i = 0 ; i<res.size() ; i++){
          st+=res.get(i).getFlight().getFlightNo()+"\t\t";
          st+=res.get(i).getPassenger().getPassengerCNIC()+"\t\t";
          st+=res.get(i).getreservationID()+"\t\t";
          st+=res.get(i).getbookedTickets()+"\t\t";
          st+=res.get(i).reservationType+"\t\t";
          System.out.println("\n");
      }
      return st;
  }
  public void cancelReservation(ArrayList<Reservation> res,int id){
      for(int i = 0 ; i<res.size() ; i++){
          if(res.get(i).getreservationID()==id){
              res.remove(i);
          }
      }
  }
  public boolean checkReservation(ArrayList<Reservation> res,int id){
      for(int i = 0 ; i<res.size() ; i++){
          if(res.get(i).getreservationID()==id){
              return true;
          }
      }
      return false;
  }
  int getreservationID(){
      return this.reservationID;
  }
  int getbookedTickets(){
      return this.bookedTickets;
  }
  Flight getFlight(){
      return this.fl;
  }
  Passenger getPassenger(){
      return this.pa;
  }
  int getFlightTickets(){
      return super.getTotalTickets();
  }
}

