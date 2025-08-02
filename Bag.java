import java.io.Serializable;

public class Bag implements Serializable{

   // private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }

    private String category;
    private int size;
    private String colour;
    private double price;

    public Bag(String id, String name, String category, int size, String colour, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.size = size;
        this.colour = colour;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + category + "size: "+size + ", Colour: "+colour + ", Price: $" + price;
    }
}