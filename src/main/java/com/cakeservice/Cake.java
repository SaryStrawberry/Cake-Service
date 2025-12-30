package com.cakeservice;

public class Cake {
    public String name;
    public String batter;
    public String frosting;
    public String topping;
    public int preparationTime;
    public double cost;

    public Cake(String name, String batter, String frosting, String topping, int preparationTime, double cost) {
        name = this.name;
        batter = this.batter;
        frosting = this.frosting;
        topping = this.topping;
        preparationTime = this.preparationTime;
        cost = this.cost;
    }

    public String getRecipeName() {
        return name;
    }

    public String getBatter() {
        return batter;
    }

    public String getFrosting() {
        return frosting;
    }

    public String getTopping() {
        return topping;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public double getCost() {
        return cost;
    }
}
