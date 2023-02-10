package Dto;

import Model.Application;
import Model.Binary;
import Model.NewAppModule;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class NewAppModuleDto implements Serializable {

    @NotNull
    private final String moduleName;

    private final String moduleDescription;

    private final List<Binary> binaries;

}
