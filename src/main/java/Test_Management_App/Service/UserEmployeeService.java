package Test_Management_App.Service;


import Test_Management_App.Model.TestCase;
import Test_Management_App.Model.UserEmployee;
import Test_Management_App.Payloads.UserEmployeeCreatePayload;
import Test_Management_App.Payloads.UserEmployeeUpdatePayload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserEmployeeService {

    UserEmployee createUserEmployee(UserEmployeeCreatePayload userEmployeeCreatePayload);
    UserEmployee partialUpdateUserEmployee(int idUserEmployee, UserEmployeeUpdatePayload userEmployeeUpdatePayload);
    UserEmployee getUserEmployeeByIdUserEmployee(int idUserEmployee);
    UserEmployee getUserEmployeeByUserName(String userName);
    UserEmployee getUserEmployeeByUserSurname(String userSurname);
    UserEmployee getUserEmployeeByUserLogin(String userLogin);
    List<UserEmployee> getAllUserEmployee();

}
