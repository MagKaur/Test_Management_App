package Java;

public class NewAppModule {

    private int id_app_module;
    private String module_name;
    private String module_description;
    private Application fk_id_applicationNewAppModule;

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
