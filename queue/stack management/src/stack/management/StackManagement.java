/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.management;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1405086
 */

public class StackManagement{
    
   public static void main(String[] args) {
        Operations ob=new Operations("1st line");
        Operations ob1=new Operations("2nd line");
           
            int choice,dec = 0,dec1 = 0;//dec1 and dec are used to calculate the total time in each queue
            Scanner sc=new Scanner(System.in);
        do
        {
            System.out.println("Welcome to Queue Management System!!");
            System.out.println("Enter 1 to get your queue no:");
            System.out.println("Enter 2 to check queue 1 status:");
            System.out.println("Enter 3 to check queue 2 status:");
           choice=sc.nextInt();
           if(choice==1)
           {
               if(ob.queue.peek()==null && ob1.queue.peek()==null)//checks if both the queue are empty
               {
                   ob.begin();//starts with the first thread 
                   System.out.println("1st queue!!");
               }
               dec+=ob.totaltime;//increments the total time of the first object after adding the object(car)
               dec1+=ob1.totaltime;//increments the total time of the second object after adding the new car
               if(dec>dec1)//checks if first queue has line then second queue
               {
                   if(ob1.queue.peek()==null)//checks if second queue is empty 
                     ob1.begin();//starts the second queue
                   else
                   ob1.initiate();//enter the new object1
                    System.out.println("2nd queue!!");
               }
               else if(dec<dec1)
               { 
                    if(ob.queue.peek()==null)
                       ob.begin();
                    else
                   ob.initiate();
                     System.out.println("1st queue!!");
               }

               else if(dec==dec1 && dec!=0 && dec1!=0)
               { 
                   ob.initiate();
                    System.out.println("1st queue!!");
               }
               //System.out.println("Total Value:"+dec+" "+dec1);
               }
           if(choice==2)
               ob.showstatus();
           if(choice==3)
               ob1.showstatus();
             }while(true);
   }
        // TODO code application logic here
    }

    

   

