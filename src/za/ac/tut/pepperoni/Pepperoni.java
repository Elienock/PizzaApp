/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.pepperoni;

import za.ac.tut.pizza.Pizza;

/**
 *
 * @author user
 */
public class Pepperoni extends Pizza {
  
    
   public Pepperoni(){
        
   }
   
    public Pepperoni(int quantity, int size){
        
        
   }

  
    @Override
    public double determinePizzaPrice() {
        double pizzaPrice =0;
        
        if(getSize()==1){
            
            pizzaPrice = (SIZE_LARGE_PRICE + PEPPERONI_UNIT_PRICE) * getQuantity();
            
        }else if(getSize()==2){
            
            pizzaPrice = (SIZE_MEDIUM_PRICE + PEPPERONI_UNIT_PRICE) * getQuantity();
            
        }else{
             pizzaPrice = (SIZE_SMALL_PRICE + PEPPERONI_UNIT_PRICE) * getQuantity();
        }
        
        return pizzaPrice;
    }

    @Override
    public String toString() {
        return "Pepperoni{" + '}';
    }


    
    
    

  
}
