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
import java.io.Serializable;
import java.util.ArrayList;

public class Flight implements flightInterface , Serializable{ 
  private int flightNum;
  private String flightName;
  private String flightArrival;
  private String flightDeparture;
  private String flightSource;
  private String flightDestination;
  int totalTickets;
    Flight(){
    flightNum=0;
    flightName="None";
    flightArrival="None";
    flightArrival="None";
    flightSource="None";
    flightDestination="None";
    totalTickets=0;
    }
    Flight(int fNo, String fName, String fArrival, String fDeparture,String fSource, String fDestination , int tt){
     this.flightNum=fNo;
     this.flightName=fName;
     this.flightArrival=fArrival;
     this.flightDeparture=fDeparture;
     this.flightSource=fSource;
     this.flightDestination=fDestination;
     this.totalTickets=tt;
    }
@Override
    public void addFlightRecord(ArrayList<Flight> addRecord , Flight f1 ){
    addRecord.add(f1);
    }
@Override
    public String viewFlightRecord(ArrayList<Flight> viewRecord){
         String st="";
         for(int i=0 ; i< viewRecord.size(); i++){
         st+=viewRecord.get(i).flightNum+"  ";
         st+=viewRecord.get(i).flightName+"  ";
         st+=viewRecord.get(i).flightArrival+"  ";
         st+=viewRecord.get(i).flightDeparture+"  ";
         st+=viewRecord.get(i).flightSource+"  ";
         st+=viewRecord.get(i).flightDestination+"\n";
        }
        return st;
    }
@Override
    public String searchFlightRecord(ArrayList<Flight> searchRecord, int id){
        String st="";
        boolean b=false;
        for(int i=0; i<searchRecord.size(); i++){
        if(searchRecord.get(i).flightNum ==id){
           
         st+= searchRecord.get(i).flightNum+"  ";
         st+=searchRecord.get(i).flightName+"  ";
         st+=searchRecord.get(i).flightArrival+"  ";
         st+=searchRecord.get(i).flightDeparture+"  ";
         st+=searchRecord.get(i).flightSource+"  ";
         st+=searchRecord.get(i).flightDestination+"\n";
         b=true;
        }  }
         if(b){
         return st;}
         else{
         st+="ID not found! ";}
         return st;
    }
@Override
    public void deleteFlightRecord(ArrayList<Flight> deleteRecord , int id){
    for(int i=0; i<deleteRecord.size(); i++){
    if(deleteRecord.get(i).flightNum==id){
    deleteRecord.remove(i);
    } }
    }
@Override
    public void editFlightRecord(ArrayList<Flight> editRecord , Flight f1, int id){
    for(int i=0 ;i<editRecord.size(); i++){
    if(editRecord.get(i).flightNum==id){
       editRecord.get(i).flightNum=f1.flightNum;
       editRecord.get(i).flightName=f1.flightName;
       editRecord.get(i).flightArrival=f1.flightArrival;
       editRecord.get(i).flightDeparture=f1.flightDeparture;
       editRecord.get(i).flightSource=f1.flightSource;
       editRecord.get(i).flightDestination=f1.flightDestination;
    }
    }    
    }
    int getFlightNo(){
    return this.flightNum;
    }
    String getFlightName(){
    return  this.flightName; 
    }
    String getFlightArrival(){
    return this.flightArrival;
    }
    String getFlightDeparture(){
    return this.flightDeparture;
    }
    String getFlightSource(){
    return this.flightSource;
    }
    String getFlightDestination(){
        return this.flightDestination;
    }
    int getTotalTickets(){
    return this.totalTickets;
    }
    public boolean checkFlight(int ID , ArrayList<Flight> fli){
      for(int i = 0; i<fli.size() ; i++){
          if(ID==fli.get(i).getFlightNo()){
              return true;
          }
      }
      return false;
  }
}

