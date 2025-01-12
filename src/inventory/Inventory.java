package inventory;

import java.io.Serializable;

// Inventory class

public class Inventory implements Serializable
{
    private String foodItemName;
    private int foodItemQuantity;

    public Inventory()
    {

    }

    public Inventory(String foodItemName, int foodItemQuantity) {
        this.foodItemName = foodItemName;
        this.foodItemQuantity = foodItemQuantity;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public int getFoodItemQuantity() {
        return foodItemQuantity;
    }

    public void setFoodItemQuantity(int foodItemQuantity) {
        this.foodItemQuantity = foodItemQuantity;
    }

    @Override
    public String toString() {
        System.out.printf("%-25s %s %-5d", foodItemName,"Quantity: ",foodItemQuantity);
        return "\n";
    }
}