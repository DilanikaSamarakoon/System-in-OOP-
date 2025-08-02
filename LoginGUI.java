import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginGUI() {
        setTitle("Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for the central content
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15); // Smaller text field
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15); // Smaller text field

        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;contentPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        contentPanel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(loginButton, gbc);

        // "Welcome" text in the middle
        JLabel welcomeLabel = new JLabel("Welcome to the Little Bag Shop", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(welcomeLabel, BorderLayout.NORTH);

        add(contentPanel, BorderLayout.CENTER);

        // Panel for images at the bottom
        JPanel imagePanel = new JPanel(new GridLayout(1, 5, 5, 5));
        String[] imagePaths = {
                "E:/Little Bag Shop 01/src/bag1.jpeg",
                "E:/Little Bag Shop 01/src/bag2.jpeg",
                "E:/Little Bag Shop 01/src/bag3.jpg",
                "E:/Little Bag Shop 01/src/bag4.jpg",
                "E:/Little Bag Shop 01/src/bag5.jpg",
                "E:/Little Bag Shop 01/src/bag6.png"
        };
        int imageWidth = 200;
        int imageHeight = 200;

        for (String path : imagePaths) {
            ImageIcon originalIcon = new ImageIcon(path);
            Image img = originalIcon.getImage();
            Image resizedImg = img.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            JLabel imageLabel = new JLabel(resizedIcon);
            imagePanel.add(imageLabel);
        }

        add(imagePanel, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Perform authentication using the UserHandler
            User user = UserHandler.authenticate(username, password);

            if (user != null && user instanceof Manager) {
                // If authentication is successful and user is a manager, open ManagerGUI
                Manager manager = (Manager) user;
                SwingUtilities.invokeLater(() -> {
                    new ManagerGUI(manager).setVisible(true);
                    dispose(); // Close the login window
                });
            } else {
                // Show error message if authentication fails
                JOptionPane.showMessageDialog(LoginGUI.this, "Invalid username or password.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
            loginGUI.setVisible(true);
        });
    }
}
