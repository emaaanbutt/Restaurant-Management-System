package billing;

import java.io.Serializable;

public class Bill implements Serializable {
    private int billID;
    private double totalBill;
    private double serviceCharges;
    private int counter = 0;

    public Bill() {
    }

    public Bill(double serviceCharges, double totalBill) {
        this.billID = ++counter;
        this.totalBill = totalBill;
        this.serviceCharges = serviceCharges;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getServiceCharges() {
        return serviceCharges;
    }

    public void setServiceCharges(double serviceCharges) {
        this.serviceCharges = serviceCharges;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billID=" + billID +
                ", totalBill=" + totalBill +
                ", serviceCharges=" + serviceCharges + "}";
    }
}

