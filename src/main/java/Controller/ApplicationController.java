package Controller;

import Dto.ApplicationDto;
import Exceptions.BlankOrEmptyFieldException;
import Model.Application;
import Payloads.ApplicationRequest;
import Payloads.Response;
import Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/app")
public class ApplicationController {

    @Autowired
    private ApplicationService appService;

    @PostMapping("/add")
    public ResponseEntity<Response> addApplication(@RequestBody ApplicationRequest appRequest){

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Collections.singletonMap("created", appService.createApplication(appRequest)))
                        .message("Application created")
                        .httpStatus(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value()) //sam status wyrzuca dużo rzeczy, .value, zeby wyciągnąć tylko nnumer kodu
                        .build()
        );
        //TODO ogarnąć mapping dla nie ok create
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateApplication(@PathVariable("id") Integer id, @RequestBody ApplicationRequest appRequest){

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Collections.singletonMap("update", appService.updateApplication(id, appRequest)))
                        .message("Update succesfull")
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value()) //sam status wyrzuca dużo rzeczy, .value, zeby wyciągnąć tylko nnumer kodu
                        .build()
        );
        //TODO ogarnąć mapping dla nie ok update
    }

    @GetMapping("/ListAll")
    public ResponseEntity<List<Application>> getAllApplications() {

        List<Application> applicationDtoList = appService.getAllApplications();
        return new ResponseEntity<>(applicationDtoList, HttpStatus.OK);
    }

    @GetMapping("/find/idDTO/{id}")
    public ResponseEntity<ApplicationDto> getAppById(@PathVariable("id") Integer id) throws BlankOrEmptyFieldException {

        ApplicationDto applicationDto = appService.getSingleApplicationByIdDTO(id);
        return new ResponseEntity<>(applicationDto, HttpStatus.OK);
    }

    @GetMapping("/find/nameDTO/{name}")
    public ResponseEntity<List<ApplicationDto>> getAppByName(@PathVariable("name") String name) {
        List<ApplicationDto> applicationDtoList = appService.getApplicationByNameDTO(name);
        return new ResponseEntity<>(applicationDtoList, HttpStatus.OK);
    }

}
