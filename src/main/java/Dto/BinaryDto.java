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

    private final String binaryDescription;


    private final String binaryLink;

    @NotNull
    private final String projectName;
    private final String deviceModelName;
    private final String newAppModule;

    @NotNull
    private final BinaryStatusType binaryStatus;
    private final AcceptedStatusType acceptedStatus;

}
