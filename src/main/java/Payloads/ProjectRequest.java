package Payloads;

import Model.ProjectStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ProjectRequest {

    @NotNull
    private String projectDescription;

    @NotNull
    private String projectName;

    @Enumerated
    private ProjectStatusType projectStatus;

}
