package Repository;

import Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

   List <Application> findByAppName(@NonNull String appName);

}
