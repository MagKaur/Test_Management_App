package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
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
    List<Binary> findByAcceptedStatusIsTrue();
    List<Binary> findByAcceptedStatusIsFalse();
    List<Binary> findByAcceptedStatusIsTrueAndAcceptedStatusIsFalse();
}