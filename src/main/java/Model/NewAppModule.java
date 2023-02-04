package Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "new_app_modules", schema = "mango")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//TODO wykorzystac widok test_plan w kodzie, Read only? czy nie
public class NewAppModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_app_module")
    @NotNull
    private int id_app_module;
    @Column(name = "module_name")
    @NotNull
    private String module_name;
    @Column(name = "module_description")
    @NotNull
    private String module_description;
    @ManyToOne
    @JoinColumn(name = "id_application")
    @Column(name = "id_application")
    @JsonManagedReference
    @NotNull
    private Application fk_id_applicationNewAppModule;

    protected NewAppModule(){};

    NewAppModule(int id_app_module, String module_name, String module_description, Application fk_id_applicationNewAppModule) {

        this.id_app_module = id_app_module;
        this.module_name = module_name;
        this.module_description = module_description;
        this.fk_id_applicationNewAppModule = fk_id_applicationNewAppModule;
    }

    public int getId_app_module(){
        return id_app_module;
    }
    public void setId_app_module(int id_app_module){
        this.id_app_module = id_app_module;
    }

    public String getModule_name(){
        return module_name;
    }
    public void setModule_name(String module_name){
        this.module_name = module_name;
    }

    public String getModule_description(){
        return module_description;
    }
    public void setModule_destription(String module_destription){
        this.module_description = module_destription;
    }

    public Application getFk_id_applicationNewAppModule(){
        return fk_id_applicationNewAppModule;
    }
    public void setFk_id_applicationNewAppModule(Application fk_id_applicationNewAppModule){
        this.fk_id_applicationNewAppModule = fk_id_applicationNewAppModule;
    }
}
