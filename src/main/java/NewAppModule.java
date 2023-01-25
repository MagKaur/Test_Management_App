public class NewAppModule extends Application {

    private int id_app_module;
    private String module_name;
    private String module_destription;
    private Application fk_id_applicationNewAppModule;

    NewAppModule(int id_application, String app_name, String technology_description, String functionality_description,
                    int id_app_module, String module_name, String module_destription, Application fk_id_applicationNewAppModule) {
        super(id_application, app_name, technology_description, functionality_description);
        this.id_app_module = id_app_module;
        this.module_name = module_name;
        this.module_destription = module_destription;
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
        return module_destription;
    }
    public void setModule_destription(String module_destription){
        this.module_destription = module_destription;
    }

    public Application getFk_id_applicationNewAppModule(){
        return fk_id_applicationNewAppModule;
    }
    public void setFk_id_applicationNewAppModule(Application fk_id_applicationNewAppModule){
        this.fk_id_applicationNewAppModule = fk_id_applicationNewAppModule;
    }
}
