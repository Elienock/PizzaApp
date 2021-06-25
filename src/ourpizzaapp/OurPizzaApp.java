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
    
    
    public static int determineExtraPrice(){
        
    int extraPrice=0;    
        
        String extraChoiceStr = JOptionPane.showInputDialog(null,"Do you want to buy EXTRAs: "+"\n"+
                                                          "1 --> YES"+"\n"+
                                                          "2 --> NO","EXTRA CHOICE", JOptionPane.INFORMATION_MESSAGE);
int extraChoice = Integer.parseInt(extraChoiceStr);

if(extraChoice == 1){
    
    
String extraMenuStr = JOptionPane.showInputDialog(null,"1 --> COCA COLA: R10"+"\n"+
                                                    "2 --> FANTA:  R11"+"\n"+
                                                    "3 --> SPRITE: R13"+"\n"+
                                                    "4 --> SALADE: R19"+"\n"+
                                                    "5 --> PASTA:  R22","EXTRA MENU", JOptionPane.INFORMATION_MESSAGE);


String extraQtyStr = JOptionPane.showInputDialog(null,"Please Enter Qunatity","EXTRA Quantity", JOptionPane.INFORMATION_MESSAGE);
int extraQty = Integer.parseInt(extraQtyStr);

 int extraMenuOpt = Integer.parseInt(extraMenuStr);
 
 
 switch(extraMenuOpt){
     case 1:
         extraPrice = 10 * extraQty;
         break;
     case 2: 
         extraPrice = 11 * extraQty;
         break;
     case 3: 
         extraPrice = 13 * extraQty;
         break;
     case 4: 
         extraPrice = 19 * extraQty;
         break;
         
     case 5: 
         extraPrice = 22 * extraQty;
         break;
 }
 
 
    
}
        
        
        return extraPrice;
    }
       
    public static void main(String[] args) {
        
    List<Pizza> pizzaTypes = new ArrayList<Pizza>();
    
    List<Pizza> currentCleantOrders = new ArrayList<Pizza>();
    
    
    
    String choicestr;
    int choice;
    int extraPrice;
    boolean isValid = true;
      double currentClientpizzaPrice =0;
 
    
while(isValid){
    
    
        
    String pizzaTypeStr =JOptionPane.showInputDialog(null,"Please Choose Flavor: "+"\n"+                       
                                                          "1 --> PEPPERONI"+"\n"+
                                                          "2 --> SUPREME_PIZZA"+"\n"+
                                                          "3 --> HAWAIANPIZZA","FLAVOR MENU", JOptionPane.INFORMATION_MESSAGE);
    
    
    String sizeStr =JOptionPane.showInputDialog(null,"Please Choose The size: "+"\n"+
                                                          "1 --> LARGE"+"\n"+
                                                          "2 --> MEDIUM"+"\n"+
                                                          "3 --> SMALL","ENTER SIZE", JOptionPane.INFORMATION_MESSAGE);
    
    String quantitystr =JOptionPane.showInputDialog(null,"Please Enter Quantity", "QUANTIY", JOptionPane.INFORMATION_MESSAGE);
    
    
    int pizzaType = Integer.parseInt(pizzaTypeStr);
    int size = Integer.parseInt(sizeStr);
    int quantity = Integer.parseInt(quantitystr);
    
   
    
    if(pizzaType == 1){
        
        
        Pepperoni p = new Pepperoni();
        
        p.setSize(size);
        p.setQuantity(quantity);
        
        currentCleantOrders.add(p);
        pizzaTypes.add(p);
        
          
    }else if (pizzaType == 2){
        
        SupremePizza s = new SupremePizza();
        
        s.setSize(size);
        s.setQuantity(quantity);
        
      currentCleantOrders.add(s);
      pizzaTypes.add(s);
      
         
    }else{
        HawaianPizza h = new HawaianPizza();
        
        h.setSize(size);
        h.setQuantity(quantity);
        
        currentCleantOrders.add(h);
        pizzaTypes.add(h);
        
           
    }
    
    
        
    choicestr = JOptionPane.showInputDialog(null,"Do you want to buy another pizza flavor: "+"\n"+
                                                          "1 --> YES"+"\n"+
                                                          "2 --> NO","CHOICE", JOptionPane.INFORMATION_MESSAGE);
    
    
    choice = Integer.parseInt(choicestr);
    if(choice == 2){
        
        isValid = false;
    }
    
    
}

// increamenting current Clien tpizza Price
for(int i =0; i<  currentCleantOrders.size(); i++){
    
   currentClientpizzaPrice += currentCleantOrders.get(i).determinePizzaPrice();
}

//calling extra price method
extraPrice = determineExtraPrice();

double amountDue = extraPrice + currentClientpizzaPrice;


// reset current client orders list 
for(int i =0; i< currentCleantOrders.size(); i++){
      
    currentCleantOrders.set(i,null);
}





for(int i =0; i< pizzaTypes.size(); i++){
        JOptionPane.showMessageDialog(null,"Qunatity: "+ pizzaTypes.get(i).getQuantity()+"\n"+"size:"+pizzaTypes.get(i).getSize()+"\n"+
                                  "Price:"+ pizzaTypes.get(i).determinePizzaPrice()+"amount DUE R"+amountDue,"pizza",JOptionPane.INFORMATION_MESSAGE);
        
}
     
    }
    
}
