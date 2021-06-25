/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.pizza;

import za.ac.tut.datainterface.DataInterface;
import za.ac.tut.pizzainterface.PizzaInterface;

/**
 *
 * @author user
 */
public abstract class Pizza implements PizzaInterface, DataInterface  {
    
    public int size;
    private int quantity;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public  abstract double determinePizzaPrice();
    
}
