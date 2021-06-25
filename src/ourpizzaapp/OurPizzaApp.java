/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourpizzaapp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import za.ac.tut.hawaianpizza.HawaianPizza;
import za.ac.tut.pepperoni.Pepperoni;
import za.ac.tut.pizza.Pizza;
import za.ac.tut.supremepizza.SupremePizza;



/**
 *
 * @author user
 */
public class OurPizzaApp {

    /**
     * @param args the command line arguments
     */
    public static int getUserToppings(){
         int pizzaType =Integer.parseInt(JOptionPane.showInputDialog(null,"Please Choose Toppings: "+"\n"+                       
                                                          "1 ---> PEPPERONI "+"\n"+
                                                          "--------------------" + "\n" +
                                                                 "LARGE  =R102" + "\n" +
                                                                 "MEDUIM=R82" + "\n" +
                                                                 "SMALL=R67 " + "\n\n" +
                                                          "2 --> SUPREME_PIZZA"+"\n"+
                                                             "---------------" + "\n" +
                                                                 "LARGE  =R110" + "\n" +
                                                                 "MEDUIM=R90" + "\n" +
                                                                 "SMALL=R75 " + "\n\n" +
                                                          "3 --> HAWAIAN_PIZZA" + "\n" +
                                                               "---------------" + "\n" +
                                                                 "LARGE  =R110" + "\n" +
                                                                 "MEDUIM=R90" +  "\n" +
                                                                 "SMALL=R75 " + "\n" + 
                                                                "-1--> End application","FLAVOR MENU", JOptionPane.INFORMATION_MESSAGE));
    return pizzaType;
    }
    public static int  getUserSize(){
         int size =Integer.parseInt(JOptionPane.showInputDialog(null,"Please Choose The size: "+"\n"+
                                                          "1 --> LARGE"+"\n"+
                                                          "2 --> MEDIUM"+"\n"+
                                                          "3 --> SMALL","ENTER SIZE", JOptionPane.INFORMATION_MESSAGE));
         return size;
    }
    public static void displayPizzaPrice(List<Pizza> pizzas){
        //Declare Variables
        String data="";
        Pepperoni pepperoni;
        HawaianPizza hawaiian;
        SupremePizza supremePizza;
        
        
         for(int i = 0;i<pizzas.size();i++){
             
            if(pizzas.get(i) instanceof Pepperoni){
                
                pepperoni=(Pepperoni) pizzas.get(i);
                data= data + "The current amount Due is R" + pepperoni.determinePizzaPrice();
            }else if (pizzas.get(i) instanceof HawaianPizza){
                hawaiian=(HawaianPizza) pizzas.get(i);
                data= data + "The current amount Due is R" + hawaiian.determinePizzaPrice();
            }else{
                supremePizza=(SupremePizza) pizzas.get(i);
                data= data + "The current amount Due is R" + supremePizza.determinePizzaPrice();
            }
        
            JOptionPane.showMessageDialog(null, data);
    }
    }
    public static int extraServiceMenu(){
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null,"1 --> COCA COLA: R10"+"\n"+
                                                    "2 --> FANTA:  R11"+"\n"+
                                                    "3 --> SPRITE: R13"+"\n"+
                                                    "4 --> SALADE: R19"+"\n"+
                                                    "5 --> PASTA:  R22","EXTRA MENU", JOptionPane.INFORMATION_MESSAGE));
        return choice;
    }
    public static int AskUserForExtraService(){
      int choice=  Integer.parseInt(JOptionPane.showInputDialog(null,"Do you want an extra food?" + "\n" +
                    "1 --> YES " + "\n" +
                    "2 --> NO " + "\n" +
                    "Your choice :","INFORMATION",JOptionPane.INFORMATION_MESSAGE));
      return choice;
    }
    

       
    public static void main(String[] args) {  
    List<Pizza> pizzas = new ArrayList<Pizza>();
    List<Pizza> currentCleantOrders = new ArrayList<Pizza>();
    Boolean doItAgain=true;
    int extraPrice = 0,xChoice,choice1,payment,change;
    boolean sizeCode=true,isValid = true,runApp=true,extra=true;
     double currentClientpizzaPrice =0,dailyAmountDue = 0;
     
     do{
 try{
      //display the menu
    int toppings=getUserToppings();
    
    do{
        
        if (toppings>0 && toppings <4){
              do{
                //allow user to pick size
                 int size= getUserSize();
                 
                 
                 //user have to pick the quantity
    int quantity =Integer.parseInt(JOptionPane.showInputDialog(null,"Please Enter Quantity", "QUANTIY", JOptionPane.INFORMATION_MESSAGE));
                
    if(toppings == 1){
        
        //Instatiation
        Pepperoni p = new Pepperoni();
        
        p.setSize(size);
        p.setQuantity(quantity);
        
        currentCleantOrders.add(p);
        pizzas.add(p);
        
    }else if (toppings == 2){
        
        SupremePizza s = new SupremePizza();
        
        s.setSize(size);
        s.setQuantity(quantity);
        
      currentCleantOrders.add(s);
      pizzas.add(s);
      
         
    }else{
        HawaianPizza h = new HawaianPizza();
        
        h.setSize(size);
        h.setQuantity(quantity);
        
        currentCleantOrders.add(h);
        pizzas.add(h);
        
           
    }
    if(size==1 || size==2 || size==3){
                     sizeCode=true;
                 }else{
                     sizeCode=false;
                     JOptionPane.showMessageDialog(null, "Invalid choice, Enter either 1,2 or 3 ","ERROR",JOptionPane.ERROR_MESSAGE);
                 }
            }while(!sizeCode);
    doItAgain=false;
        
            //Display the current price
        displayPizzaPrice(pizzas);
        do{
            xChoice=AskUserForExtraService();
            
            if(xChoice ==1){
                extra= true;
                    do{
                        choice1=extraServiceMenu();
                        
                         if(choice1 == 1 || choice1==2){
                             
                              if(choice1 ==1){
                                  int extraQty=Integer.parseInt( JOptionPane.showInputDialog(null,"Please Enter Quantity","EXTRA Quantity", JOptionPane.INFORMATION_MESSAGE));
 
 
 switch(choice1){
     case 1:
         extraPrice = 10 * extraQty;
         JOptionPane.showMessageDialog(null,"The extra price is R" + extraPrice);
         break;
     case 2: 
         extraPrice = 11 * extraQty;
         JOptionPane.showMessageDialog(null,"The extra price is R" + extraPrice);
         break;
     case 3: 
         extraPrice = 13 * extraQty;
         JOptionPane.showMessageDialog(null,"The extra price is R" + extraPrice);
         break;
     case 4: 
         extraPrice = 19 * extraQty;
         JOptionPane.showMessageDialog(null,"The extra price is R" + extraPrice);
         break;
         
     case 5: 
         extraPrice = 22 * extraQty;
         JOptionPane.showMessageDialog(null,"The extra price is R" + extraPrice);
         break;
 }
 
                              }else if(choice1 ==2){
                                  
                              }
                              extra=true;
                         }else {
                    JOptionPane.showMessageDialog(null,"Invalid choice","ERROR",JOptionPane.ERROR_MESSAGE);
                    extra=false;
                }
                        
                    }while(!extra);
                // increamenting current Client pizza Price
for(int i =0; i<  currentCleantOrders.size(); i++){
    
   currentClientpizzaPrice += currentCleantOrders.get(i).determinePizzaPrice();
}


double amountDue = extraPrice + currentClientpizzaPrice;


// reset current client orders list 
for(int i =0; i< currentCleantOrders.size(); i++){
      
    currentCleantOrders.set(i,null);
}





for(int i =0; i< pizzas.size(); i++){
        JOptionPane.showMessageDialog(null,"Quantytity: "+ pizzas.get(i).getQuantity()+"\n"+
                "size:"+pizzas.get(i).getSize()+"\n"+
                "Price:"+ pizzas.get(i).determinePizzaPrice()+"\n" +
                "Extra Service price: R" + extraPrice +
                "amount due  R"+amountDue,"pizza",JOptionPane.INFORMATION_MESSAGE);
        
}
do{
                 //asking the user for payment
           payment=Integer.parseInt( JOptionPane.showInputDialog(null,"Please make payment R"));
        
        if(payment >= amountDue){
            isValid=true;
            change = (int) (payment - amountDue);
            JOptionPane.showMessageDialog(null, "Your change is R" + change);
            dailyAmountDue += amountDue;
            JOptionPane.showMessageDialog(null, "The daily amount made is R"+dailyAmountDue);
             
            
        }else{
         isValid=false;
          JOptionPane.showMessageDialog(null,"Invalid Payment","ERROR",JOptionPane.ERROR_MESSAGE);
           dailyAmountDue += amountDue;
            JOptionPane.showMessageDialog(null, "The daily amount made is R"+dailyAmountDue);
             
        }
             
         
        }while(!isValid);
            
            }else if(xChoice ==2){
                extra=true;
                extraPrice=0;
            }else{
                 extra = false;
                    JOptionPane.showMessageDialog(null,"Invalid choice. choose either 1 or 2","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            
        }while(!extra);
        
       
        }else if(toppings==-1){
                isValid=true; 
                //display the daily amount made
                JOptionPane.showMessageDialog(null,"The daily amount is R"+dailyAmountDue);
        }else{
            isValid=false;
            JOptionPane.showMessageDialog(null,"Next Customer");
            toppings=getUserToppings();
        }
                  
    }while(!runApp);
    }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Wrong input","Wrong input",JOptionPane.ERROR_MESSAGE);
        }
     
        }while(!doItAgain);
     
     
     
     }
     }
