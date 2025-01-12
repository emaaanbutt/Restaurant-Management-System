package portion;
public class Portion {
    private static String size;
    private static String description;

    public Portion(String size, String description) {
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null ");
        }

        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        this.size = size;
        this.description = description;
    }

    public Portion() {

    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getSize() {
        return size;
    }

    public static String getDescription() {
        return description;
    }
}
