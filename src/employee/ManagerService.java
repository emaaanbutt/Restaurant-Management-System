package employee;

import java.io.*;
import java.util.ArrayList;

public class ManagerService {

    public static ArrayList<Manager> readManagersFile() {
        ArrayList<Manager> managers = new ArrayList<>();
        File file = new File("managers.txt");

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("managers.txt"))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList<?>) {
                    ArrayList<?> list = (ArrayList<?>) obj;
                    for (Object o : list) {
                        if (o instanceof Manager) {
                            managers.add((Manager) o);
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return managers;
    }

    public static void writeManagersToFile(ArrayList<Manager> managers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("managers.txt"))) {
            oos.writeObject(managers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
