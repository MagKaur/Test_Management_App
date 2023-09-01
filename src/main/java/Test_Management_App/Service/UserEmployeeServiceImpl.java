package Test_Management_App.Service;


import Test_Management_App.Model.TestCase;
import Test_Management_App.Model.UserEmployee;

import Test_Management_App.Payloads.UserEmployeeCreatePayload;
import Test_Management_App.Payloads.UserEmployeeUpdatePayload;
import Test_Management_App.Repository.UserEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserEmployeeServiceImpl implements UserEmployeeService {

    private final UserEmployeeRepository userEmployeeRepository;

    @Autowired
    public UserEmployeeServiceImpl(UserEmployeeRepository userEmployeeRepository) {
        this.userEmployeeRepository = userEmployeeRepository;
    }

    public UserEmployee createUserEmployee(UserEmployeeCreatePayload userEmployeeCreatePayload) {
        if (isEmptyOrBlank(userEmployeeCreatePayload.getUserName()) || userEmployeeCreatePayload.getUserName() == null
                || isEmptyOrBlank(userEmployeeCreatePayload.getUserSurname()) || userEmployeeCreatePayload.getUserSurname() == null
                || isEmptyOrBlank(userEmployeeCreatePayload.getUserLogin()) || userEmployeeCreatePayload.getUserLogin() == null
                || isEmptyOrBlank(userEmployeeCreatePayload.getUserPassword()) ||userEmployeeCreatePayload.getUserPassword() == null)
        {
            throw new IllegalArgumentException("One or more fields are empty or blank");
        } else {
        UserEmployee userEmployee = new UserEmployee();
        userEmployee.setUserName(userEmployeeCreatePayload.getUserName());
        userEmployee.setUserSurname(userEmployeeCreatePayload.getUserSurname());
        userEmployee.setUserLogin(userEmployeeCreatePayload.getUserLogin());
        userEmployee.setUserPassword(userEmployeeCreatePayload.getUserPassword());


        return userEmployeeRepository.save(userEmployee);}
    }

    private boolean isEmptyOrBlank(String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public UserEmployee partialUpdateUserEmployee(int idUserEmployee, UserEmployeeUpdatePayload userEmployeeUpdatePayload) {
        Optional<UserEmployee> userEmployee = userEmployeeRepository.findById(idUserEmployee);
        if (!userEmployee.isPresent()) {
            throw new ResourceNotFoundException("User not found with this id ::" + idUserEmployee);
        } else {

            if (userEmployeeUpdatePayload.getUserName() != null) {
                userEmployee.get().setUserName(userEmployeeUpdatePayload.getUserName());
            }
            if (userEmployeeUpdatePayload.getUserSurname() != null) {
                userEmployee.get().setUserSurname(userEmployeeUpdatePayload.getUserSurname());
            }
            if (userEmployeeUpdatePayload.getUserLogin() != null) {
                userEmployee.get().setUserLogin(userEmployeeUpdatePayload.getUserLogin());
            }
            if (userEmployeeUpdatePayload.getUserPassword() != null) {
                userEmployee.get().setUserPassword(userEmployeeUpdatePayload.getUserPassword());
            }


            return userEmployeeRepository.save(userEmployee.get());
        }

    }

    @Override
    public UserEmployee getUserEmployeeByIdUserEmployee(int idUserEmployee) {
        return userEmployeeRepository.findById(idUserEmployee)
                .orElseThrow(() -> new EntityNotFoundException("DeviceModel with id " + idUserEmployee + " not found"));
    }

    @Override
    public UserEmployee getUserEmployeeByUserName(String userName) {
        return userEmployeeRepository.findByUserName(userName);
    }

    @Override
    public UserEmployee getUserEmployeeByUserSurname(String userSurname) {
        return userEmployeeRepository.findByUserSurname(userSurname);
    }

    @Override
    public UserEmployee getUserEmployeeByUserLogin(String userLogin) {
        return userEmployeeRepository.findByUserLogin(userLogin);
    }

    @Override
    public List<UserEmployee> getAllUserEmployee() {
        return userEmployeeRepository.findAll();
    }

}
