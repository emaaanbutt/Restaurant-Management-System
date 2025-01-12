
package complimentary;


public class ReservationComplimentaryItems extends ComplimentaryItems {
    @Override
    public void provideComplimentaryItems() {
        System.out.println("Complimentary drinks, appetizers, starters, and desserts provided for reservation customers.");
    }

    public void thankCustomer() {
        System.out.println("Thank you for choosing our restaurant!");
    }
}
