package Model;

import org.springframework.data.jpa.repository.JpaRepository;
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

    List<Binary> findByBinary_status(@NonNull String binary_status); //TODO czy to na pewno tak?
    List<Binary> findByAccepted_statusIsTrue();
    List<Binary> findByAccepted_statusIsFalse();
    List<Binary> findByAccepted_statusIsTrueAndAccepted_statusIsFalse(); //TODO czy to tak się robi?
}