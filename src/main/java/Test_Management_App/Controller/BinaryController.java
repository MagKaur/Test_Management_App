package Test_Management_App.Controller;

import Test_Management_App.Model.Application;
import Test_Management_App.Model.Binary;
import Test_Management_App.Model.BinaryStatusType;
import Test_Management_App.Model.DeviceModel;

import Test_Management_App.Payloads.BinaryCreatePayloadApp;
import Test_Management_App.Payloads.BinaryCreatePayloadDeviceModel;
import Test_Management_App.Payloads.BinaryUpdatePayload;

import Test_Management_App.Repository.BinaryRepository;

import Test_Management_App.Service.BinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/binary")
public class BinaryController {

    private BinaryService binaryService;
    private BinaryRepository binaryRepository;

    @Autowired
    public BinaryController(BinaryService binaryService, BinaryRepository binaryRepository) {
        this.binaryService = binaryService;
        this.binaryRepository = binaryRepository;
    }

    @PostMapping("/createBinaryApp")
    public ResponseEntity<String> createBinaryApp(@RequestBody BinaryCreatePayloadApp binaryCreatePayloadApp) {
        Binary createdBinary = binaryService.createBinaryApp(binaryCreatePayloadApp);
        return ResponseEntity.ok("Binary created");
    }

    @PostMapping("/createBinaryDevice")
    public ResponseEntity<String> createBinaryDeviceModel(@RequestBody BinaryCreatePayloadDeviceModel binaryCreatePayloadDeviceModel) {
        Binary createdBinary = binaryService.createBinaryDeviceModel(binaryCreatePayloadDeviceModel);
        return ResponseEntity.ok("Binary created");
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> UpdateBinary(
            @PathVariable("id") int idBinary,
            @RequestBody BinaryUpdatePayload partialUpdate) {

        Binary updatedBinary = binaryService.partialUpdateBinary(idBinary, partialUpdate);
        return ResponseEntity.ok("Binary updated");
    }

    @GetMapping("/allBinary")
    public ResponseEntity<List<Binary>> getAllBinary() {
        List<Binary> binaryList = binaryService.getAllBinary();
        if (!binaryList.isEmpty()) {
            return ResponseEntity.ok().body(binaryList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<Binary> getBinaryByIdBinary(@PathVariable int id) {
        Optional<Binary> optionalBinary = Optional.ofNullable(binaryService.getBinaryByIdBinary(id));
        return optionalBinary.map(binary -> ResponseEntity.ok().body(binary)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/name/{binaryName}")
    public ResponseEntity<Binary> getBinaryByAppName(@PathVariable String binaryName) {
        Binary binary = binaryService.getBinaryByBinaryName(binaryName);
        if (binary == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(binary);
        }
    }

    @GetMapping("/Binary/ByApplication/{idApplication}")
    public ResponseEntity<List<Binary>> getBinaryByIdApplication(@PathVariable Application idApplication) {
        List<Binary> binaryList = binaryService.getBinaryByIdApplication(idApplication);
        if (!binaryList.isEmpty()) {
            return ResponseEntity.ok().body(binaryList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/Binary/ByDeviceModel/{idDevice}")
    public ResponseEntity<List<Binary>> getBinaryByIdDevice(@PathVariable DeviceModel idDevice) {
        List<Binary> binaryList = binaryService.getBinaryByIdDevice(idDevice);
        if (!binaryList.isEmpty()) {
            return ResponseEntity.ok().body(binaryList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/Binary/ByBinaryStatus/{binaryStatusType}")
    public ResponseEntity<List<Binary>> getBinaryByBinaryStatusType(@PathVariable BinaryStatusType binaryStatusType) {
        List<Binary> binaryList = binaryService.getBinaryByBinaryStatusType(binaryStatusType);
        if (!binaryList.isEmpty()) {
            return ResponseEntity.ok().body(binaryList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
