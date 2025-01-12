package employee;

import java.io.*;
import java.util.ArrayList;

public class ChefBusinessLogic {
    public static ArrayList<Chef> readChefsFile() {
        ArrayList<Chef> chefs = new ArrayList<>();
        File file = new File("chefs.txt");

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                chefs = (ArrayList<Chef>) ois.readObject(); // Read the entire list
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return chefs;
    }

    public static void writeChefsToFile(ArrayList<Chef> chefs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("chefs.txt"))) {
            oos.writeObject(chefs); // Write the entire list
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
