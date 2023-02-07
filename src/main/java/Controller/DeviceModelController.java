package Controller;

import Model.DeviceModelRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class DeviceModelController {

    private DeviceModelRepository deviceModelRepository;

    DeviceModelController(DeviceModelRepository deviceModelRepository){
        this.deviceModelRepository = deviceModelRepository;
    }
}
