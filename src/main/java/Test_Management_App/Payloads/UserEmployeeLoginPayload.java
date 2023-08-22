package Test_Management_App.Payloads;

public class UserEmployeeLoginPayload {

    private String userLogin;
    private String userPassword;

    public UserEmployeeLoginPayload(){};

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
