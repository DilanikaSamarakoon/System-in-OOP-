import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Method to load bags from a .dat file in CSV format
    public static List<Bag> loadBagsFromDatFile(String filename) {
        List<Bag> bags = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split the line into values
                if (values.length == 6) { // Ensure there are exactly 6 values
                    String id = values[0];
                    String name = values[1];
                    String category = values[2];
                    int size = Integer.parseInt(values[3]);
                    String colour = values[4];
                    double price = Double.parseDouble(values[5]);
                    Bag bag = new Bag(id, name, category, size, colour, price);
                    bags.add(bag); // Add the bag to the list
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + filename);
            e.printStackTrace();
        }
        return bags;
    }

    // Method to save bags to a .dat file in CSV format
    public static void saveBagsToDatFile(List<Bag> bags, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Bag bag : bags) {
                bw.write(bag.getId() + "," + bag.getName() + "," + bag.getCategory() + ","
                        + bag.getSize() + "," + bag.getColour() + "," + bag.getPrice());
                bw.newLine(); // Move to the next line after each bag
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
            e.printStackTrace();
        }
    }

    public static List<Cashier> loadCashiersFromDatFile(String filename) {
        List<Cashier> cashiers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split the line into values
                if (values.length == 2) { // Ensure there are exactly 2 values (username and password)
                    String username = values[0];
                    String password = values[1];
                    Cashier cashier = new Cashier(username, password); // Assuming Cashier class has a constructor
                    cashiers.add(cashier); // Add the cashier to the list
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + filename);
            e.printStackTrace();
        }
        return cashiers;
    }

    // Method to save cashiers to a .dat file in CSV format
    public static void saveCashiersToDatFile(List<Cashier> cashiers, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Cashier cashier : cashiers) {
                bw.write(cashier.getUsername() + "," + cashier.getPassword()); // Assuming Cashier class has getter methods
                bw.newLine(); // Move to the next line after each cashier
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
            e.printStackTrace();
        }
    }
}