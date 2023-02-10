package Repository;

import Model.Application;
import Model.NewAppModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;

public interface NewAppModuleRepository extends JpaRepository<NewAppModule, Integer> {
    @Override
    @RestResource(exported = false)
    void delete (NewAppModule newAppModule);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);



    NewAppModule findByModuleName(@NonNull String moduleName);
    List<NewAppModule>findByFkIdApplicationNewAppModule(@NonNull Integer idApplication);

}
