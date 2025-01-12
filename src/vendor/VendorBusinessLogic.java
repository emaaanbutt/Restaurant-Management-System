package vendor;

import java.io.*;
import java.util.ArrayList;

public class VendorBusinessLogic {
    public static ArrayList<Vendor> readVendorsFromFile() {
        ArrayList<Vendor> vendors = new ArrayList<>();
        File file = new File("vendors.txt");

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vendors.txt"))) {
                vendors = (ArrayList<Vendor>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return vendors;
    }

    public static void writeVendorsToFile(ArrayList<Vendor> vendors) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vendors.txt"))) {
            oos.writeObject(vendors);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
