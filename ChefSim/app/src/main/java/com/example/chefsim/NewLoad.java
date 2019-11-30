package com.example.chefsim;

import java.util.ArrayList;

public class NewLoad {

    enum ingredients
    {
        BUN, PATTY, BACON, CHEESE, KETCHUP, MUSTARD, LETTUCE, PICKLES, TOMATO
    }

    ingredients burger;

    private int speed;
    private int customers;
    private int ingredients;
    private int orderItems;
    private int round;

    public void set(int speed,  int customers, int ingredients, int orderItems, int round)
    {
        this.speed = speed;
        this.customers = customers;
        this.ingredients = ingredients;
        this.orderItems = orderItems;
        this.round = round;
    }

    public int getSpeed() {
        return speed;
    }
    public int getCustomers() {
        return customers;
    }
    public int getIngredients() {
        return ingredients;
    }
    public int getOrderItems() {
        return orderItems;
    }
    public int getRound() {
        return round;
    }

    public int time()
    {
        if(speed == 1)
        {
            return 9;
        }
        else if(speed == 2)
        {
            return 8;
        }
        else if(speed == 3)
        {
            return 7;
        }
        else if(speed == 4)
        {
            return 6;
        }
        else if(speed == 5)
        {
            return 5;
        }
        else if(speed == 6)
        {
            return 4;
        }
        else if(speed == 7)
        {
            return 3;
        }
        else if(speed == 8)
        {
            return 2;
        }
        else
        {
            return 1;
        }
    }
}
