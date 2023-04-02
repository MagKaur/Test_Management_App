package Repository;

import Model.Project;
import Model.ProjectStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;

@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<Project, Integer> {


    Project findByProjectName(@NonNull String projectName);
    List<Project>findByProjectStatus(@NonNull ProjectStatusType projectStatus);
}
