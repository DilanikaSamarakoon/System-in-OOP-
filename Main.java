
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Load existing users
        UserHandler.loadUsers();

        // Launch the login GUI
        SwingUtilities.invokeLater(() -> new LoginGUI().setVisible(true));
    }
}
