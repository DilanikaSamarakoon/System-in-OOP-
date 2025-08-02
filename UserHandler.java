import java.util.ArrayList;
import java.util.List;

public class UserHandler {
    private static List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
    }

    public static User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.validatePassword(password)) {
                return user;
            }
        }
        return null;
    }

    public static void loadUsers() {
        // Implement loading users from a file
        // For now, let's just add a default manager account
        addUser(new Manager("Dila", "Apple123", new ArrayList<>()));
        //addUser(new Manager("Casier", "Pass", new ArrayList<>()));
    }

    public static void saveUsers() {
        // Implement saving users to a file
    }
}
