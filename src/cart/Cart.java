package cart;

import java.io.Serializable;
//Cart class
public class Cart implements Serializable
{
    private int foodItemID;
    private String foodItemName;
    private String size;
    private int quantity;
    private int totalPrice;
    private int priceOfOne;

    public Cart(int foodItemID, String foodItemName, String size, int quantity, int totalPrice) {
        this.foodItemID = foodItemID;
        this.foodItemName = foodItemName;
        this.size = size;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Cart() {

    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    public int calculateTotalPrice(int price, int quantity)
    {
        totalPrice=price*quantity;
        return totalPrice;
    }

    public int getPriceOfOne() {
        return priceOfOne;
    }
    public void setPriceOfOne(int priceOfOne) {
        this.priceOfOne = priceOfOne;
    }

    @Override
    public String toString() {
        int totalPrice = getPriceOfOne() * getQuantity();
        System.out.printf("%-4d %-25s %-7s Quantity %-5d Rs.%-10d",getFoodItemID(),getFoodItemName(),getSize(),
                getQuantity(),totalPrice);
        return "\n";
    }
}


