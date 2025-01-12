
package complimentary;

// Abstract class for ComplimentaryItems
public abstract class ComplimentaryItems {
    public abstract void provideComplimentaryItems();

    public void greetCustomer() {
        System.out.println("Hello valued customer! We hope you enjoy your complimentary items.");
    }

    public void provideComplimentaryStarters() {
        System.out.println("Complimentary starters are served!");
    }

    public void provideComplimentaryDesserts() {
        System.out.println("Complimentary desserts are served!");
    }
}






