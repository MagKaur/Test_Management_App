package Controller;

import Repository.BinaryRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class BinaryController {

    private BinaryRepository binaryRepository;

    BinaryController(BinaryRepository binaryRepository){
        this.binaryRepository = binaryRepository;
    }

}
