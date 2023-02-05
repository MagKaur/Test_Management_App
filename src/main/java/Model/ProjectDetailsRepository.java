package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Integer> {

    @Override
    @RestResource(exported = false)
    void delete (ProjectDetails projectDetails);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);
}
