package Dto;

import Model.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class BinaryDto implements Serializable {

    @NotNull
    private final String binaryName;
    @NotNull
    private final String binaryDescription;
    @NotNull
    private final String binaryLink;

    private final String projectName;
    private final String deviceModelName;
    private final String newAppModule;

    @NotNull
    private final BinaryStatusType binaryStatus;
    private final AcceptedStatusType acceptedStatus;

}
