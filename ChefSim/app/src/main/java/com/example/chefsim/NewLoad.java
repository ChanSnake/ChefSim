package com.example.chefsim;

public class NewLoad {
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
}
