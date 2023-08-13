package Test_Management_App.Repository;


import Test_Management_App.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Application findByAppName(String appName);

}
