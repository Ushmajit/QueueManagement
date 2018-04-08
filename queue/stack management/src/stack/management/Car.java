/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.management;

import java.util.Scanner;

/**
 *
 * @author 1405086
 */
public class Car {
    String UID;
    String model;
    String owner;
    int quantity; //price of petrol in rs.
    
public int quantotime(int priceperlitre,int outflowtime)
 {
    
        return (quantity/priceperlitre)*outflowtime;
     
 }
public void initialise()
{
    Scanner sc=new Scanner(System.in);
     System.out.println("<--Enter Car Details-->");
         System.out.println("Car Unique No(Number Plate):");
         UID=sc.nextLine();
          System.out.println("Car Model:");
         model=sc.nextLine();
          System.out.println("Car owner name:");
          owner=sc.nextLine();
           System.out.println("Quantity of petrol(in Rs):");
         quantity=sc.nextInt();
}
 }
    

