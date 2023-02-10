package Repository;

import Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;

public interface BinaryRepository extends JpaRepository<Binary, Integer> {

    @Override
    @RestResource(exported = false)
    void delete(Binary binary);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    List<Binary> findByBinaryStatus(@NonNull BinaryStatusType binaryStatus);
    List<Binary> findByAcceptedStatus(@Param("state") AcceptedStatusType acceptedStatusType);

    List<Binary>findByFkIdApplicationBinary(@NonNull Integer idApplication);
    List<Binary>findByFkIdNewAppModuleBinary(@NonNull Integer idNewAppModule);
    List<Binary>findByFkIdProjectBinary(@NonNull Integer idProject);
    List<Binary>findByFkIdDeviceModelBinary (@NonNull Integer idDeviceModel);

    @Query(nativeQuery = true, value = "SELECT * FROM tests_ongoing ORDER BY Project_Name")
    List<TESTS_ONGOINGview> getTESTS_ONGOING();

}