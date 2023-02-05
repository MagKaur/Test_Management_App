package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface NewAppModuleRepository extends JpaRepository<NewAppModule, Integer> {
    @Override
    @RestResource(exported = false)
    void delete (NewAppModule newAppModule);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);
}
