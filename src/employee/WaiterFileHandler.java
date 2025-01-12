package employee;

import java.io.*;
import java.util.ArrayList;

public class WaiterFileHandler {
    public static ArrayList<Waiter> readWaitersFile() {
        ArrayList<Waiter> waiters = new ArrayList<>();
        File file = new File("waiters.txt");

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("waiters.txt"))) {
                waiters = (ArrayList<Waiter>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return waiters;
    }

    public static void writeWaitersToFile(ArrayList<Waiter> waiters) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("waiters.txt"))) {
            oos.writeObject(waiters);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
