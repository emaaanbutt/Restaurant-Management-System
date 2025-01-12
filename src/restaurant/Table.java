

package restaurant;

// Table class
enum TableStatus {
    FREE, RESERVED, OCCUPIED
}
public class Table {
    private int tableNumber;
    private int capacity;
    private TableStatus tableStatus;

    public Table(int tableNumber, int capacity) {
        if (tableNumber <= 0 || capacity <= 0) {
            throw new IllegalArgumentException("Table number and capacity must be positive values.");
        }

        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.tableStatus = TableStatus.RESERVED;
    }



    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        if (tableStatus == null) {
            throw new IllegalArgumentException("Table status cannot be null.");
        }
        this.tableStatus = tableStatus;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", capacity=" + capacity +
                ", tableStatus=" + tableStatus +
                '}';
    }
}