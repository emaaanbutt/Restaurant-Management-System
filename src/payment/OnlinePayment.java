package payment;

import java.sql.Date;

public class OnlinePayment extends Payment {
    private double discountPercentage;

    public OnlinePayment(int paymentID, double amount, Date creationDate, String details, double payedBy, double discountPercentage) {
        super(paymentID, amount, creationDate, details, payedBy);
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        this.discountPercentage = 5.0;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

}
