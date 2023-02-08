package Payloads;

import Model.DeviceModelFeaturesStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class DeviceModelRequest {

@NotNull
private String producer_name;
@NotNull
private String modelName;
@NotNull
private String premiereQuarter;
@NotNull
@Enumerated
private DeviceModelFeaturesStatus volte;
@NotNull
@Enumerated
private DeviceModelFeaturesStatus vowifi;
@NotNull
@Enumerated
private DeviceModelFeaturesStatus saNsa5g;
@NotNull
@Enumerated
private DeviceModelFeaturesStatus eSim;
@NotNull
@Enumerated
private DeviceModelFeaturesStatus rcs;
}
