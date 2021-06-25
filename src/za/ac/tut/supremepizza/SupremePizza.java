/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.supremepizza;

import za.ac.tut.pizza.Pizza;

/**
 *
 * @author user
 */
public class SupremePizza extends Pizza {
    
    public SupremePizza(){
    }

    
    
    public SupremePizza(int size, int quantity){
    }  
    
    
    @Override
    public double determinePizzaPrice() {
        
        double pizzaPrice =0;
        
        if(getSize()==1){
            
            pizzaPrice = (SIZE_LARGE_PRICE + SUPREME_UNIT_PRICE) * getQuantity();
        }else if(getSize()==2){
            
            pizzaPrice = (SIZE_MEDIUM_PRICE + SUPREME_UNIT_PRICE) * getQuantity();
            
        }else{
             pizzaPrice = (SIZE_SMALL_PRICE +SUPREME_UNIT_PRICE)* getQuantity();
        }
        
        return pizzaPrice;
    }

   
    
}
