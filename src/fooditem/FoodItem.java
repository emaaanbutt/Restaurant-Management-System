package fooditem;
import portion.Portion;

import java.util.ArrayList;
import java.util.List;
// Base class for FoodItem



// Enum for FoodTypes
enum FoodType {
    STARTER, MAIN_COURSE, DESSERT;

    public Comparable<Object> getFoodItem() {
        return null;
    }
}
public class FoodItem  {
    private static String name;
    private static double price;
    private static  String foodType;
    private int foodItemID;
    private int quantity;
    private List<Portion> portions;
    public FoodItem(String name, int quantity) {
        this.name=name;
        this.quantity=quantity;
    }

    public FoodItem(String name, double price, String foodType, int quantity, List<Portion> portions) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        if (foodType == null) {
            throw new IllegalArgumentException("Food type cannot be null");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        if (portions == null) {
            throw new IllegalArgumentException("Portions cannot be null");
        }

        this.name = name;
        this.price = price;
        this.foodType = foodType;
        this.quantity = quantity;
        this.portions = portions;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public static String getFoodType() {
        return foodType;
    }

    public static void setFoodType(String foodType) {
        FoodItem.foodType = foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Portion> getPortions() {
        return portions;
    }

    public void setPortions(List<Portion> portions) {
        this.portions = portions;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public static String getName() {
        return name;
    }

    public static double getPrice() {
        return price;
    }


    public void addPortion(Portion portion){
        portions.add(portion);
    }

    public Portion getPortion() {
        return getPortion();
    }


    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", foodType=" + foodType +
                ", quantity=" + quantity +
                ", portions=" + portions +
                '}';
    }

}


// Class for managing FoodItems
class FoodItemManager {
    private static List<FoodItem> foodItems;

    public FoodItemManager() {
        this.foodItems = new ArrayList<>();
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }
}

// Subclass for Starter
class Starter extends FoodItem {
    public Starter(String name, double price, String foodType, int quantity, List<Portion> portions) {
        super(name, price, foodType, quantity, portions);
    }
}

// Subclass for MainCourse
class MainCourse extends FoodItem {
    public MainCourse(String name, double price, String foodType, int quantity, List<Portion> portions) {
        super(name, price, foodType, quantity, portions);
    }
}

// Subclass for Dessert
class Dessert extends FoodItem {
    public Dessert(String name, double price, String foodType, int quantity, List<Portion> portions) {
        super(name, price, foodType, quantity, portions);
    }
}