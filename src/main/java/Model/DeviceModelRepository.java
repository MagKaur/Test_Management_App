package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface DeviceModelRepository extends JpaRepository<DeviceModel, Integer> {

    @Override
    @RestResource(exported = false)
    void delete (DeviceModel deviceModel);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);
}
