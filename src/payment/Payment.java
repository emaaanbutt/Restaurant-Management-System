package payment;

import java.sql.Date;
// ENUM FOR PAYMENTSTATUS
enum PaymentStatus {
    UNPAID, PENDING, PAID, FAILED,DECLINED
}

public class Payment {
    private int paymentID;
    private double amount;
    private java.sql.Date creationDate;
    private String details;
    private double payedBy;

    public Payment(int paymentID, double amount, java.sql.Date creationDate, String details, double payedBy) {

        if (paymentID <= 0) {
            throw new IllegalArgumentException("Payment ID must be a positive value.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be a positive value.");
        }

        if (creationDate == null) {
            throw new IllegalArgumentException("Creation date cannot be null.");
        }

        if (details == null || details.isEmpty()) {
            throw new IllegalArgumentException("Details cannot be null or empty.");
        }



        this.paymentID = paymentID;
        this.amount = amount;
        this.creationDate = creationDate;
        this.details = details;
        this.payedBy = payedBy;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public java.sql.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.sql.Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPayedBy() {
        return payedBy;
    }

    public void setPayedBy(double payedBy) {
        this.payedBy = payedBy;
    }

    public void createPayment() {
        System.out.println("Payment created:");
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Amount: " + amount);
        System.out.println("Creation Date: " + creationDate);
        System.out.println("Details: " + details);
        System.out.println("Paid by: " + payedBy);

    }
}



