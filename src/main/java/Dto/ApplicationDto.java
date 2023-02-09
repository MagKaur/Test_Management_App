package Dto;

import Model.Binary;
import Model.NewAppModule;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ApplicationDto implements Serializable {

    @NotNull
    private final String appName;
    @NotNull
    private final String technologyDescription;
    @NotNull
    private final String functionalityDescription;

    private List<NewAppModule> newAppModules;

    private List<Binary> binaries;


}
