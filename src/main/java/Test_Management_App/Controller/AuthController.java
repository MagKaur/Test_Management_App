package Test_Management_App.Controller;

import Test_Management_App.Model.UserEmployee;
import Test_Management_App.Payloads.UserEmployeeLoginPayload;
import Test_Management_App.Service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserEmployeeService userEmployeeService;

    @Autowired
    public AuthController(UserEmployeeService userEmployeeService) {
        this.userEmployeeService = userEmployeeService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEmployeeLoginPayload loginPayload, HttpSession session) {
        UserEmployee userEmployee = userEmployeeService.getUserEmployeeByUserLogin(loginPayload.getUserLogin());

        if (userEmployee != null && userEmployee.getUserPassword().equals(loginPayload.getUserPassword())) {
            // Jeśli logowanie się powiodło, ustaw informację o zalogowanym użytkowniku w sesji
            session.setAttribute("loggedInUser", userEmployee);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
}
