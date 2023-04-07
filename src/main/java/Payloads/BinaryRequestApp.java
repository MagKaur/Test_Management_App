package Payloads;

import Model.AcceptedStatusType;
import Model.BinaryStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class BinaryRequestApp {

@NotNull
private String binaryName;
@NotNull
private String binaryDescription;
@NotNull
private String binaryLink;
@NotNull
private int idProject;
@NotNull
private int idApplication;
@Enumerated
private BinaryStatusType binaryStatus;

}
