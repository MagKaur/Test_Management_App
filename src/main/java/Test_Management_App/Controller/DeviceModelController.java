package Test_Management_App.Controller;

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

    @PatchMapping("/update/{id}")
    public ResponseEntity<DeviceModel> updateDeviceModel(
            @PathVariable("id") int idDeviceModel,
            @RequestBody DeviceModelUpdatePayload partialUpdate) {

        DeviceModel updatedDeviceModel = deviceModelService.partialUpdateDeviceModel(idDeviceModel, partialUpdate);
        return ResponseEntity.ok(updatedDeviceModel);
    }

    @GetMapping("/allApplication")
    public ResponseEntity<List<DeviceModel>> getAllDeviceModel() {
        List<DeviceModel> deviceModel = deviceModelRepository.findAll();
        if (!deviceModel.isEmpty()) {
            return ResponseEntity.ok().body(deviceModel);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/model/{deviceModelName}")
    public ResponseEntity<DeviceModel> getSingleDeviceModelByModelName(@PathVariable String deviceModelName) {
        Optional<DeviceModel> optionalDeviceModel = Optional.ofNullable(deviceModelRepository.findByDeviceModelName(deviceModelName));

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

