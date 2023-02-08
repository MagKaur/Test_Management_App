package Model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

@Entity
@Table(name = "new_app_modules", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")


public class NewAppModule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_app_module")
    private int idAppModule;
    @Column(name = "module_name")
    @NotNull(message = "Module Name must not be null")
    @NotBlank(message = "Module Name must not be empty")
    private String moduleName;
    @Column(name = "module_description")
    @NotNull(message = "Module Description must not be null")
    @NotBlank(message = "Module Description must not be empty")
    private String moduleDescription;
    @ManyToOne
    @JoinColumn(name = "id_application")
    @JsonManagedReference
    @NotNull(message = "Application indication must not be null")
    private Application fkIdApplicationNewAppModule;

    protected NewAppModule(){};

    NewAppModule(int idAppModule, String moduleName, String moduleDescription, Application fkIdApplicationNewAppModule) {

        this.idAppModule = idAppModule;
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
        this.fkIdApplicationNewAppModule = fkIdApplicationNewAppModule;
    }

    public int getIdAppModule(){
        return idAppModule;
    }
    public void setIdAppModule(int idAppModule){
        this.idAppModule = idAppModule;
    }

    public String getModuleName(){
        return moduleName;
    }
    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }

    public String getModuleDescription(){
        return moduleDescription;
    }
    public void setModuleDescription(String moduleDescription){
        this.moduleDescription = moduleDescription;
    }

    public Application getFkIdApplicationNewAppModule(){
        return fkIdApplicationNewAppModule;
    }
    public void setFkIdApplicationNewAppModule(Application fkIdApplicationNewAppModule){
        this.fkIdApplicationNewAppModule = fkIdApplicationNewAppModule;
    }
}
