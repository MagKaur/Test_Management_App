package Repository;

import Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;

public interface BinaryRepository extends JpaRepository<Binary, Integer> {


    List<Binary> findByBinaryStatus(@NonNull BinaryStatusType binaryStatus);
    List<Binary> findByBinaryName(@NonNull String binaryName);

    List<Binary>findByFkIdApplicationBinary(@NonNull Integer idApplication);
    List<Binary>findByFkIdNewAppModuleBinary(@NonNull Integer idNewAppModule);
    List<Binary>findByFkIdProjectBinary(@NonNull Integer idProject);
    List<Binary>findByFkIdDeviceModelBinary (@NonNull Integer idDeviceModel);


}