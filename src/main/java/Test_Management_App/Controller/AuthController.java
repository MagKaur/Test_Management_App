package Test_Management_App.Controller;

import Test_Management_App.Model.UserEmployee;
import Test_Management_App.Payloads.UserEmployeeLoginPayload;
import Test_Management_App.Service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserEmployeeService userEmployeeService;




    @Autowired
    public AuthController(UserEmployeeService userEmployeeService) {
        this.userEmployeeService = userEmployeeService;

    }
/*
    @PostMapping ("/login")
    public ResponseEntity<String> login(@RequestBody UserEmployeeLoginPayload loginPayload) {
        UserEmployee userEmployee = userEmployeeService.getUserEmployeeByUserLogin(loginPayload.getUserLogin());
        if (userEmployee.getUserPassword().equals(loginPayload.getUserPassword())) {
            return ResponseEntity.ok("User logged in");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }*/
}






