package Test_Management_App.Model;
import javax.persistence.*;

@Entity
@Table(name = "user_employee")
public class UserEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserEmployee;
    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;
    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_password")
    private String userPassword;

    public UserEmployee(){}

    public int getId() {
        return idUserEmployee;
    }
    public void setId(int idUserEmployee) {this.idUserEmployee = idUserEmployee;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }




}
