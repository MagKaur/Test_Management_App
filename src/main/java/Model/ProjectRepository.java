package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;

@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Override
    @RestResource(exported = false)
    void delete (Project project);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);


    List<Project>findByProjectName(@NonNull String projectName);
    List<Project>findByProjectStatus(@NonNull ProjectStatusType projectStatus);
}
