package Test_Management_App.Repository;


import Test_Management_App.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
