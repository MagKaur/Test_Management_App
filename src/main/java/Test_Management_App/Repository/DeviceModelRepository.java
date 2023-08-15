package Test_Management_App.Repository;


import Test_Management_App.Model.DeviceModel;
import com.sun.xml.bind.v2.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DeviceModelRepository extends JpaRepository<DeviceModel, Integer>{

    public DeviceModel findByModelName(String modelName);
    public List<DeviceModel> findByProducerName(String producerName);

}
