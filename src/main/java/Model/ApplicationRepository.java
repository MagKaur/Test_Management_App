package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Override
    @RestResource(exported = false)
    void delete (Application application);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

}
