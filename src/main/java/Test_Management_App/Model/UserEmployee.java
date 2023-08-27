package Test_Management_App.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "idUserEmployee", cascade = CascadeType.ALL)
    private List<TestTask> userTestTasks = new ArrayList<>();
    public UserEmployee(){}

    public int getIdUserEmployee() {
        return idUserEmployee;
    }
    public void setIdUserEmployee(int idUserEmployee) {this.idUserEmployee = idUserEmployee;
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

    public List<TestTask> getUserTestTasks() {
        return userTestTasks;
    }

    public void setUserTestTasks(List<TestTask> userTestTasks) {
        this.userTestTasks = userTestTasks;
    }
}
