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

public class Passenger implements passengerInterface, Serializable{
    private String passengerName;
    int passengerCNIC;
    private String passengerEmail;
    private int passengerPhoneNumber;
    Passenger(){
        int passengerCNIC = 0;
        passengerName = "NULL";
        passengerEmail = "NULL";
        passengerPhoneNumber = 0;
    }
    Passenger(int cnic , String passName, String email, int num){
       this.passengerCNIC = cnic;
        this.passengerName = passName;
        this.passengerEmail = email;
        this.passengerPhoneNumber = num;
    }
    @Override
    public void addPassenger(ArrayList<Passenger> addP, Passenger p){
        addP.add(p);
    }
    @Override
    public void editPassenger(ArrayList<Passenger> editP, Passenger p, int id){
        int count = 0;
        for (int i = 0; i<editP.size(); i++){
        if (editP.get(i).passengerCNIC == id){
            editP.get(i).passengerCNIC = p.passengerCNIC;
            editP.get(i).passengerName = p.passengerName;
            editP.get(i).passengerPhoneNumber = p.passengerPhoneNumber;
            editP.get(i).passengerEmail = p.passengerEmail;
            count++;
        }
        }
        if (count == 0){
            System.out.println("ID not found!!");
        }
        else {
            p.viewPassenger(editP);
        }
    }
    @Override
    public String searchPassenger(ArrayList<Passenger> searchP, int id){
        int co = 0;
        String st = "";
        for (int i = 0; i<searchP.size(); i++){
            if (searchP.get(i).passengerCNIC == id){
                st = st + searchP.get(i).passengerName + " ";
                st = st + searchP.get(i).passengerPhoneNumber + " ";
                st = st + searchP.get(i).passengerEmail + " ";
                co++;
            }
        }
        if (co == 0){
            return "Passenger not found!!";
        }
        else {
            return st;
        }
    }
    @Override
    public void deletePassenger(ArrayList<Passenger> deleteP, int id){
        int count = 0;
        for (int i = 0; i<deleteP.size(); i++){
            if (deleteP.get(i).passengerCNIC == id){
                deleteP.remove(i);
                count++;
            }
        }
        if (count == 0){
            System.out.println("Passenger not found!! ");
        }
        else {
            Passenger.viewPassenger(deleteP);
        }
    }
    public static void viewPassenger(ArrayList<Passenger> viewP){
        if (viewP.get(0).passengerName == "NULL"){
            System.out.println("No records available!!");
            return;
        }
        for (int i = 0; i<viewP.size(); i++){
            System.out.println("ID    Name    Email    Phone No");
            System.out.println(viewP.get(i).passengerCNIC+ "\t" +viewP.get(i).passengerName+ "\t" +viewP.get(i).passengerEmail+ "\t" +viewP.get(i).passengerPhoneNumber);
            System.out.println();
        }
    }
    public boolean compareId(ArrayList<Passenger> compareID, int id){
        boolean b = false;
        for (int i = 0; i<compareID.size(); i++){
            if (compareID.get(i).passengerCNIC == id){
                b = true;
            }
        }
        return b;
    }
    @Override
     public String VP(ArrayList<Passenger> vP){
        String st ="";
            st+="ID\tName\tEmail\tPhoneNo"+"\n";
            for(int i = 0 ; i<vP.size() ; i++){
                st+=vP.get(i).getPassengerCNIC()+"\t";                
                st+=vP.get(i).getPassengerName()+"\t";
                st+=vP.get(i).getPassengerEmail()+"\t";
                st+=vP.get(i).getPassengerPhoneNo()+"\n";
            
        }
        return st;
    }
    int getPassengerCNIC(){
    return this.passengerCNIC;
    }
    String getPassengerName(){
    return  this.passengerName; 
    }
    String getPassengerEmail(){
   return this.passengerEmail;
    }
    int getPassengerPhoneNo(){
    return this.passengerPhoneNumber;
    }
    public boolean checkPassenger(int Cnic,ArrayList<Passenger> pss){
        for(int i = 0 ; i<pss.size() ; i++){
            if(Cnic==pss.get(i).getPassengerCNIC()){
                return true;
            }
        }
        return false;
}
}
