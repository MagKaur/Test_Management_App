package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Override
    @RestResource(exported = false)
    void delete (Project project);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

}
