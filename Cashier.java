import java.util.List;

public class Cashier extends User {
    private List<Bag> bags;

    public Cashier(String username, String password, List<Bag> bags) {
        super(username, password);
        this.bags = bags;
    }

    public Cashier(String username, String password) {
        super(username, password);
    }

    // Add methods specific to Cashier's operations
}
