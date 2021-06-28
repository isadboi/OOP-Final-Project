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
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionClass {
    Scanner input = new Scanner(System.in);
    ExceptionClass(){
    }
    public int check_exception(){
        int n = 0;
        boolean bool = true;
        do{
            bool = true;
            try{
               n = input.nextInt();
               bool = false;
            }
            catch (InputMismatchException e){
                System.out.println("Enter correct integer: ");
                input.nextLine();
                
            }
        } 
        while (bool);
        return n;
    }
}

