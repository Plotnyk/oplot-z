package app.model.entity.person;

/**
 * Entity that encapsulates user of the application
 * @author Plotnyk
 */
public class User {
    /**Unique user name vithit the system*/
    private String userName;
    /**User password*/
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
