package Service;

import Model.AcceptedStatusType;
import Model.Binary;
import Model.BinaryStatusType;
import Payloads.BinaryRequestApp;
import Payloads.BinaryRequestDevice;
import Payloads.BinaryRequestNewAppModule;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Component
public interface BinaryService {
    Binary createBinaryApp(BinaryRequestApp binaryRequestApp);
    Binary createBinaryDevice(BinaryRequestDevice binaryRequestDevice);
    Binary createBinaryNewAppModule(BinaryRequestNewAppModule binaryRequestNewAppModule);

    Optional<Binary> updateBinaryApp(Integer idBinary, BinaryRequestApp binaryRequestApp);
    Optional<Binary> updateBinaryDevice(Integer idBinary, BinaryRequestDevice binaryRequestDevice);
    Optional<Binary> updateBinaryDevice(Integer idNewAppModule, BinaryRequestNewAppModule binaryRequestNewAppModule);

    Binary getBinaryByStatus(BinaryStatusType binaryStatusType);
    Binary getBinaryByAcceptedStatus(AcceptedStatusType acceptedStatusType);
    Binary getBinaryByIdApplication(Integer idApplication);
    Binary getBinaryByFkIdProjectBinary(Integer idProject);
    Binary getBinaryByFkIdDeviceModel(Integer idDeviceModel);
    Binary getBinaryByFkIdNewAppModule(Integer idNewAppModule);


}
