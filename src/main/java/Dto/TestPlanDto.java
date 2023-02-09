package Dto;

import Model.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class TestPlanDto implements Serializable {


    private final List<Project> projects;
    private final List<NewAppModule> newAppModules;
    private final List<DeviceModel> deviceModels;
    private final List<Application> applications;
    private final List<Binary> binaries;

}
