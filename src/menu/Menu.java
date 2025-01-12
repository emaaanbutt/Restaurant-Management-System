package menu;

import java.io.Serializable;

public class Menu implements Serializable {
    private int foodID;
    private String foodName;
    private final String SMALL = "SMALL";
    private int smallPrice;
    private final String MEDIUM = "MEDIUM";
    private int mediumPrice;
    private final String LARGE = "LARGE";
    private int largePrice;
    private String description;

    public Menu(int foodID, String foodName, String SMALL, int smallPrice, String MEDIUM, int mediumPrice, String LARGE, int largePrice, String description) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
        this.description = description;
    }

    public Menu() {
    }

    public String getSMALL() {
        return SMALL;
    }

    public String getMEDIUM() {
        return MEDIUM;
    }

    public String getLARGE() {
        return LARGE;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getSmallPrice() {
        return smallPrice;
    }

    public void setSmallPrice(int smallPrice) {
        this.smallPrice = smallPrice;
    }

    public int getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(int mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public int getLargePrice() {
        return largePrice;
    }

    public void setLargePrice(int largePrice) {
        this.largePrice = largePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFoodID() {
        return foodID;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-25s %-10s %-5d %-10s %-5d %-10s %-5d %s\n", getFoodID(), getFoodName(),
                getSMALL(), getSmallPrice(), getMEDIUM(), getMediumPrice(), getLARGE(), getLargePrice(), getDescription());
    }
}
