package Service;

import Model.NewAppModule;
import Payloads.NewAppModuleRequest;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public interface NewAppModuleService {

    NewAppModule createNewAppModule(NewAppModuleRequest newAppModuleRequest);
    Optional<NewAppModule> updateNewAppModule(Integer idNewAppModule);
    NewAppModule getSingleNewAppModuleByID(Integer idNewAppModule);
    NewAppModule getSingleNewAppModuleByName(String appName);
    List<NewAppModule> getListNewAppModuleByAppId(Integer idApplication);
//TODO metody z dto.
}
