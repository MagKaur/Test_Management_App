package Payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ApplicationRequest {

    @NotNull
    private String appName;
    @NotNull
    private String technologyDescription;
    @NotNull
    private String functionalityDescription;

}
