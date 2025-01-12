package order;
import fooditem.FoodItem;
import java.util.ArrayList;
import java.util.List;

// ENUM FOR ORDERSTATUS:
enum OrderStatus {
    RECEIVED, PREPARING, COMPLETED, CANCELED
}

public class Order {
    private int orderId;
    private List<FoodItem> foodItems;
    private OrderStatus orderStatus;

    public Order(int orderId) {
        if (orderId < 0) {
            throw new IllegalArgumentException("Order ID must  not  be non-negative");
        }
        this.orderId = orderId;
        this.foodItems = new ArrayList<FoodItem>();
        this.orderStatus = OrderStatus.RECEIVED;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

}



