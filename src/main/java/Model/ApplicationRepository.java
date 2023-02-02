package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface ApplicationRepository extends JpaRepository<Application, Integer> {
    //TODO zobaczyć jak w stacji kosmicznej

}
