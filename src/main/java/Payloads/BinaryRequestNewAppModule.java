package Payloads;

import Model.BinaryStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class BinaryRequestNewAppModule {

    @NotNull
    private String binaryName;
    @NotNull
    private String binaryDescription;
    @NotNull
    private String binaryLink;
    @NotNull
    private int idNewAppModule;
    @NotNull
    private BinaryStatusType binaryStatus;

}
