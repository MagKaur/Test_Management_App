package Dto;

import Model.Binary;
import Model.DeviceModel;
import Model.DeviceModelFeaturesStatus;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@NotNull
@AllArgsConstructor
public class DeviceModelDto implements Serializable {

    @NotNull
    private final String producerName;
    @NotNull
    private final String modelName;
    @NotNull
    private final String premiereQuarter;
    @NotNull
    private final DeviceModelFeaturesStatus volte;
    @NotNull
    private final DeviceModelFeaturesStatus vowifi;
    @NotNull
    private final DeviceModelFeaturesStatus saNsa5g;
    @NotNull
    private final DeviceModelFeaturesStatus eSim;
    @NotNull
    private final DeviceModelFeaturesStatus rcs;

    private final List<Binary> binaries;


}
