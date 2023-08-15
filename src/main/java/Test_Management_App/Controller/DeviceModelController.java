package Test_Management_App.Controller;

import Test_Management_App.Model.Application;
import Test_Management_App.Model.DeviceModel;
import Test_Management_App.Payloads.DeviceModelCreatePayload;
import Test_Management_App.Payloads.DeviceModelUpdatePayload;
import Test_Management_App.Repository.DeviceModelRepository;
import Test_Management_App.Service.DeviceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/deviceModel")
public class DeviceModelController {

    private DeviceModelService deviceModelService;
    private DeviceModelRepository deviceModelRepository;

    @Autowired
    public DeviceModelController(DeviceModelService deviceModelService, DeviceModelRepository deviceModelRepository) {
        this.deviceModelService = deviceModelService;
        this.deviceModelRepository = deviceModelRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<DeviceModel> createDeviceModel(@RequestBody DeviceModelCreatePayload deviceModelCreatePayload) {
        DeviceModel createdDeviceModel = deviceModelService.createDeviceModel(deviceModelCreatePayload);
        return ResponseEntity.ok(createdDeviceModel);
    }

    @PatchMapping("/update/id/{id}")
    public ResponseEntity<DeviceModel> updateDeviceModel(
            @PathVariable("id") int idDevice,
            @RequestBody DeviceModelUpdatePayload partialUpdate) {

        DeviceModel updatedDeviceModel = deviceModelService.partialUpdateDeviceModel(idDevice, partialUpdate);
        return ResponseEntity.ok(updatedDeviceModel);
    }

    @GetMapping("/allDeviceModel")
    public ResponseEntity<List<DeviceModel>> getAllDeviceModel() {
        List<DeviceModel> deviceModels = deviceModelService.getAllDeviceModels();
        if (!deviceModels.isEmpty()) {
            return ResponseEntity.ok(deviceModels);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<DeviceModel> getDeviceModelById(@PathVariable int id) {
        DeviceModel deviceModel = deviceModelService.getDeviceModelById(id);
        return ResponseEntity.ok(deviceModel);
    }

    @GetMapping("/find/model/{deviceModelName}")
    public ResponseEntity<DeviceModel> getDeviceModelByModelName(@PathVariable String modelName) {
        Optional<DeviceModel> optionalDeviceModel = Optional.ofNullable(deviceModelService.getDeviceModelByModelName(modelName));

        return ResponseEntity.of(optionalDeviceModel);
    }

    @GetMapping("/find/producer/{producerName}")
    public ResponseEntity<List<DeviceModel>> getDeviceModelByProducerName(@PathVariable String producerName) {
        List<DeviceModel> deviceModels = deviceModelService.getDeviceModelByProducerName(producerName);
        if (deviceModels.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(deviceModels);
        }
    }
}

