package Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;

import java.util.List;

public interface DeviceModelRepository extends JpaRepository<DeviceModel, Integer> {

    @Override
    @RestResource(exported = false)
    void delete (DeviceModel deviceModel);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);


    List<DeviceModel>findByIdDevice(@NonNull int idDevice);
    List<DeviceModel>findByProducerName(@NonNull String producerName);
    List<DeviceModel>findByModelName(@NonNull String modelName);
    List<DeviceModel>findByPremiereQuarter(@NonNull String premiereQuarter);
    //TODO dodać gdzieś przy mapowaniu format wpisywania QN'RR
    List<DeviceModel>findByVolte(@NonNull VoLTEstatus volte);
    List<DeviceModel>findByVowifi(@NonNull VoWiFistatus vowifi);
    List<DeviceModel>findBySaNsa5g(@NonNull SaNsa5gStatus saNsa5g);
    List<DeviceModel>findByEsim(@NonNull EsimStatus esim);
    List<DeviceModel>findByRcs(@NonNull RcsStatus rcs);


    //TODO jak szukać po tych co mam dodane w array? I czy w ogole szukac po tym.
    List<DeviceModel>findByProjectDetails(@NonNull ProjectDetails projectDetails);

}
