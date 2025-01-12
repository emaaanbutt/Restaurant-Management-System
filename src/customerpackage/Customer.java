package customerpackage;
// customer class
public class Customer {
    private int customerID;
    private String customerName;
    private String contactNumber;
    int counter=0;

    public Customer(int customerID,String customerName, String contactNumber) {
        if (customerID == -1 ) {
            throw new IllegalArgumentException("Customer ID  cannot be -1 ");
        }
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException(" Customer Name cannot be null or empty");
        }
        if (contactNumber == null || contactNumber.isEmpty()) {
            throw new IllegalArgumentException(" Customer Number cannot be null or empty");
        }
        this.customerID=++counter;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    // Getter methods for customerName and contactNumber
    public String getCustomerName() {
        return customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    public int getCounter() {
        return counter;
    }


}