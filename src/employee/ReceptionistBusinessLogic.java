package employee;

import java.io.*;
import java.util.ArrayList;

public class ReceptionistBusinessLogic {
    public static ArrayList<Receptionist> readReceptionistsFile() {
        ArrayList<Receptionist> receptionists = new ArrayList<>();
        File file = new File("receptionists.txt");

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("receptionists.txt"))) {
                receptionists = (ArrayList<Receptionist>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return receptionists;
    }

    public static void writeReceptionistsToFile(ArrayList<Receptionist> receptionists) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("receptionists.txt"))) {
            oos.writeObject(receptionists);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

