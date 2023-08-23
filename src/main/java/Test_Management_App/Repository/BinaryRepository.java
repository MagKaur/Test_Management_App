package Test_Management_App.Repository;

import Test_Management_App.Model.Application;
import Test_Management_App.Model.Binary;
import Test_Management_App.Model.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BinaryRepository extends JpaRepository<Binary, Integer> {

    Binary findByBinaryName(String binaryName);
    List<Binary> findByIdApplication(Application idApplication);
    List<Binary> findByIdDevice(DeviceModel idDevice);
}
