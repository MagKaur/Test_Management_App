package Test_Management_App.Repository;


import Test_Management_App.Model.UserEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserEmployeeRepository extends JpaRepository<UserEmployee, Integer> {

    UserEmployee findByUserName(String userName);
    UserEmployee findByUserSurname(String userSurname);
    UserEmployee findByUserLogin(String userLogin);

}
