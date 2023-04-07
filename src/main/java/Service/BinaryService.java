package Service;

import Model.AcceptedStatusType;
import Model.Binary;
import Model.BinaryStatusType;
import Model.TESTS_ONGOINGview;
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
    Optional<Binary> updateBinaryNewAppModule(Integer idBinary, BinaryRequestNewAppModule binaryRequestNewAppModule);
    List<Binary> getBinaryByStatus(BinaryStatusType binaryStatusType);
    List<Binary> getBinaryByIdApplication(Integer idApplication);
    List<Binary> getBinaryByFkIdProjectBinary(Integer idProject);
    List<Binary> getBinaryByFkIdDeviceModel(Integer idDeviceModel);
    List<Binary> getBinaryByFkIdNewAppModule(Integer idNewAppModule);



}
