package Repository;

import Model.DeviceModel;
import Model.DeviceModelFeaturesStatus;
import Model.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface DeviceModelRepository extends JpaRepository<DeviceModel, Integer> {

    @Override
    @RestResource(exported = false)
    void delete (DeviceModel deviceModel);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);



    DeviceModel findByProducerName(@NonNull String producerName);
    DeviceModel findByModelName(@NonNull String modelName);
    List<DeviceModel>findByPremiereQuarter(@NonNull String premiereQuarter);
    //TODO dodać gdzieś przy mapowaniu format wpisywania QN'RR

    //TODO testy jednostkowe
    List<DeviceModel>findByVolte(@NonNull DeviceModelFeaturesStatus volte);
    List<DeviceModel>findByVowifi(@NonNull DeviceModelFeaturesStatus vowifi);
    List<DeviceModel>findBySaNsa5g(@NonNull DeviceModelFeaturesStatus saNsa5g);
    List<DeviceModel>findByeSim(@NonNull DeviceModelFeaturesStatus eSim);
    List<DeviceModel>findByRcs(@NonNull DeviceModelFeaturesStatus rcs);


}
