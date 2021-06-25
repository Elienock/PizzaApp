/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.pizzaprocessorinterface;

import java.util.List;
import za.ac.tut.pizza.Pizza;

/**
 *
 * @author tresorkl
 */
public interface PizzaProcessorInterface {
    
    public Pizza determinrBestPizzaType(List<Pizza> pizzaTypes);
    
    
     public Pizza determinrNumOfPizzaTypeBought(List<Pizza> pizzaTypes);
    
    

    
    
}
