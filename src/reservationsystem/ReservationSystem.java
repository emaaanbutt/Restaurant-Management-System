

package reservationsystem;

import java.io.*;
import java.util.ArrayList;

public class ReservationSystem implements Serializable {
    private static ArrayList<Reservation> reservations;

    public ReservationSystem() {
        this.reservations = new ArrayList<>();
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }


    public Reservation addReservation(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }


    public static ArrayList<Reservation> readReservationsFromFile(String files) {
        ArrayList<Reservation> reservations = new ArrayList<>();
        File file = new File("reservations.txt");

        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("reservations.txt"))) {
                reservations = (ArrayList<Reservation>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return reservations;
    }

    public static void writeReservationsToFile(ArrayList<Reservation> reservations) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("reservations.txt"))) {
            oos.writeObject(reservations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






}
