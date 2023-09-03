package Test_Management_App.Controller;

import Test_Management_App.Model.TestCase;
import Test_Management_App.Model.UserEmployee;
import Test_Management_App.Payloads.TestCaseCreatePayload;
import Test_Management_App.Payloads.TestCaseUpdatePayload;
import Test_Management_App.Payloads.UserEmployeeCreatePayload;
import Test_Management_App.Payloads.UserEmployeeUpdatePayload;
import Test_Management_App.Repository.TestCaseRepository;
import Test_Management_App.Repository.UserEmployeeRepository;
import Test_Management_App.Service.TestCaseService;
import Test_Management_App.Service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userEmployee")
public class UserEmployeeController {

    private UserEmployeeService userEmployeeService;
    private UserEmployeeRepository userEmployeeRepository;

    @Autowired
    public UserEmployeeController(UserEmployeeService userEmployeeService, UserEmployeeRepository userEmployeeRepository) {
        this.userEmployeeService = userEmployeeService;
        this.userEmployeeRepository = userEmployeeRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUserEmployee(@RequestBody UserEmployeeCreatePayload userEmployeeCreatePayload) {
        UserEmployee createdUserEmployee = userEmployeeService.createUserEmployee(userEmployeeCreatePayload);
        return ResponseEntity.ok("User Employee created");
    }

    @PatchMapping("/update/id/{id}")
    public ResponseEntity<String> updateTestCase(
            @PathVariable("id") int idUserEmployee,
            @RequestBody UserEmployeeUpdatePayload partialUpdate) {

        UserEmployee updatedUserEmployee = userEmployeeService.partialUpdateUserEmployee(idUserEmployee, partialUpdate);
        return ResponseEntity.ok("User Employee updated");
    }

    @GetMapping("/allUserEmployee")
    public ResponseEntity<List<UserEmployee>> getAllUserEmployee() {
        List<UserEmployee> userEmployee = userEmployeeService.getAllUserEmployee();
        if (!userEmployee.isEmpty()) {
            return ResponseEntity.ok(userEmployee);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<UserEmployee> getUserEmployeeByIdUserEmployee(@PathVariable int id) {
        UserEmployee userEmployee = userEmployeeService.getUserEmployeeByIdUserEmployee(id);
        return ResponseEntity.ok(userEmployee);
    }

    @GetMapping("/find/name/{userName}")
    public ResponseEntity<UserEmployee> getUserEmployeeByUserName(@PathVariable String userName) {
        Optional<UserEmployee> optionalUserEmployee = Optional.ofNullable(userEmployeeService.getUserEmployeeByUserName(userName));
        return ResponseEntity.of(optionalUserEmployee);
    }

    @GetMapping("/find/surname/{userSurname}")
    public ResponseEntity<UserEmployee> getUserEmployeeByUserSurname(@PathVariable String userSurname) {
        Optional<UserEmployee> optionalUserEmployee = Optional.ofNullable(userEmployeeService.getUserEmployeeByUserSurname(userSurname));
        return ResponseEntity.of(optionalUserEmployee);
    }

    @GetMapping("/find/login/{userLogin}")
    public ResponseEntity<UserEmployee> getUserEmployeeByUserLogin(@PathVariable String userLogin) {
        Optional<UserEmployee> optionalUserEmployee = Optional.ofNullable(userEmployeeService.getUserEmployeeByUserLogin(userLogin));
        return ResponseEntity.of(optionalUserEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserEmployee(@PathVariable int id) {

        UserEmployee userEmployee = userEmployeeService.deleteUserEmployee(id);
        if (userEmployee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok("UserEmployee with ID " + id + " deleted");
        }
    }

}
