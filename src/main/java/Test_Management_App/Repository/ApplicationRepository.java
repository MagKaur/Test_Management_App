package Test_Management_App.Repository;


import Test_Management_App.Model.Application;
import com.sun.xml.bind.v2.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByAppName(String appName);

}
