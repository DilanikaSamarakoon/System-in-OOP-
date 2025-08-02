import java.util.ArrayList;
import java.util.List;
import java.awt.*;



public class Manager extends User {
    private List<Bag> bags;

    public void setBags(List<Bag> bags){
        this.bags = bags;
    }

    public Manager(String username, String password, List<Bag> bags) {
        super(username, password);
        this.bags = bags;
    }

    public List<Bag> getBags() {
        return bags;
    }

    public void viewBags() {
        if (bags.isEmpty()) {
            System.out.println("No bags available.");
        } else {
            System.out.println("Bags:");
            for (Bag bag : bags) {
                System.out.println(bag);
            }
        }
    }

    public void addBag(Bag bag) {
        bags.add(bag);
        System.out.println("Bag added successfully.");
    }

    public void searchBags(String category) {
        boolean found = false;
        for (Bag bag : bags) {
            if (bag.getCategory().equalsIgnoreCase(category)) {
                System.out.println(bag);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bags found in category: " + category);
        }
    }


    public void createCashierAccount(String cashierUsername, String cashierPassword, List<Bag> bags) {
        Cashier newCashier = new Cashier(cashierUsername, cashierPassword, bags);
        // Save the cashier details to a file or a list
    }
}
