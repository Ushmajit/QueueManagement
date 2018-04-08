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
 * 
 */
public class Operations implements Runnable {
 String name;
    Thread t;
    int realtime;
    int totaltime;
    Queue<Car> queue = new LinkedList<Car>();
    Operations(String threadname)
    {
         name=threadname;
        t=new Thread(this,name);
        System.out.println("queue: "+t);
    }
    
     public void begin()
    {
        Car ob=new Car();
        ob.initialise();
        queue.add(ob);
    System.out.println("Queue:"+name+ "operation started!!");        
    t.start();
    }
    public void suspend()
    {
        System.out.println("Queue:"+name+ " suspended!!");
       System.out.println("Top Value before suspending:"+realtime);
         System.out.println("Total Value before suspending:"+totaltime);
        t.suspend();
    }
    public void resume()
    {
        System.out.println("Queue:"+name+ " resumed!!");
        t.resume();
    }
     @Override
    public void run() {//start using perol
         while(!queue.isEmpty())
         {
         Car ob=new Car();
         ob=queue.peek();
         int data;
         data=ob.quantity; //outflow time
         realtime=ob.quantotime(100,data);//time needed to fill
         totaltime+=realtime;//total time is the entire time in  the queue, realtime is the time required for each car
        while(realtime!=0)
        {
            realtime--;
            totaltime--;
            try {
                Thread.sleep(1000);// we put the thread to sleep so that realtime and totaltime is decreased by 1 sec basis and not by processor speed
            } catch (InterruptedException ex) {
                Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(realtime==0)
         {
          Car obtemp=queue.remove();
          System.out.println("Car No:"+obtemp.UID+" Done and Removed!!");
         }
         }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void initiate()
     {
           suspend();
        Car ob = new Car();
     
       ob.initialise();
       queue.add(ob);
       System.out.print("Car No:"+ob.UID+" "+"added to "+name);
       resume();
        
     }
    public void showstatus()
    {
        suspend();
        
    }
   
}
