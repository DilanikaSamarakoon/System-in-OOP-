public class User {
    private String username;

    public String getPassword() {
        return password;
    }

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }



    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }
}
