//package notifications;

import customerpackage.Customer;

import java.sql.Date;

// Exception handling in Notification class
public class Notification  {
    private int notificationId;
    private java.sql.Date notificationDate;
    private String message;
    private int targetCustomerId;


    public Notification(int notificationId, Date notificationDate, String message, Customer c) {
        if (notificationId <= 0) {
            throw new IllegalArgumentException("Notification ID must be a positive value.");
        }

        if (notificationDate == null) {
            throw new IllegalArgumentException("Notification date cannot be null.");
        }

        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }

        if (c == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.notificationId = notificationId;
        this.notificationDate = notificationDate;
        this.message = message;
        this.targetCustomerId=c.getCustomerID();

    }

    public void sendNotification() {
        try {
            // Code for sending notification
            System.out.println("Notification sent:");
            System.out.println("Customer ID:"+ targetCustomerId);
            System.out.println("Date: " + notificationDate);
            System.out.println("Message: " + message);
        } catch (Exception e) {
            System.out.println("An error occurred while sending the notification: " + e.getMessage());
        }
    }
}
