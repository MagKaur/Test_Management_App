package Dto;

import Model.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ProjectDto implements Serializable {

    @NotNull
    private final String projectName;

    private final String projectDescription;
    @NotNull
    private final ProjectStatusType projectStatus;

    private final AcceptedStatusType acceptedStatus;
    private final List<DeviceModel> deviceModels;
    private final List<Application> applications;
    private final List<NewAppModule> newAppModules;
    private final List<Binary> binaries;


}
