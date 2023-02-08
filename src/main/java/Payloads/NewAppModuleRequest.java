package Payloads;

import Model.Application;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class NewAppModuleRequest {

    @NotNull
    private String moduleName;
    @NotNull
    private String moduleDescription;
    @NotNull
    private int idApplication;

}
