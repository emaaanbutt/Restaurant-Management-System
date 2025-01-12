package reservationsystem;

import customerpackage.Customer;
import restaurant.Table;
import java.io.Serializable;
import java.sql.Date;

// ENUM FOR RESERVATION :
enum ReservationStatus {
    REQUESTED, PENDING, CONFIRMED, CHECKED_IN, CANCELLED
}

// reservation class
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    private int reservationID;
    private Date reservationDate;
    private Table reservedTable;
    private static Customer customer;
    private ReservationStatus status;

    public Reservation(int reservationID, String reservationDate, Table reservedTable) {
        this.reservationID = reservationID;
        this.reservationDate = Date.valueOf(reservationDate);
        this.reservedTable = reservedTable;
        this.status = ReservationStatus.REQUESTED;
    }


    public int getReservationID() {
        return reservationID;
    }



    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Table getReservedTable() {
        return reservedTable;
    }

    public void setReservedTable(Table reservedTable) {
        this.reservedTable = reservedTable;
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        Reservation.customer = customer;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
    @Override
    public String toString() {
        System.out.printf("Reservation ID: %3d Date: %12s  Table no.%3d Table capacity: %3d ", getReservationID(), getReservationDate(), getReservedTable().getTableNumber(),getReservedTable().getCapacity());
        return " ";

    }
}
