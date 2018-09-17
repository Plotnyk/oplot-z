package app.model.entity.person;

import app.model.entity.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity that encapsulates user of the application
 * @author Plotnyk
 */
@Table(name = "USER")
@Entity
public class User extends AbstractEntity {
    /**Unique user name vithit the system*/
    private String userName;
    /**User password*/
    private String password;

    @Column(name = "NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
