package Model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import java.util.Map;

@SpringBootApplication
public class Main {

    //TODO change path to ojdbc from C:/ to variable
    //TODO if table "test_task_statuses" is needed? or status row placed in

    public static void main (String[] Args){
        SpringApplication.run(Main.class, Args);
        /*Project project = new Project(1,"blalASKJDSA", "PISLANDIA");
        System.out.println(project.getProject_description());
        DeviceModel deviceModel = new DeviceModel(1,"Xiaomi","11 PRO","Q3 2022",'Y','Y','Y','N');*/
    }
}



//    private static final SessionFactory ourSessionFactory;

  //  static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();

//            ourSessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
/*public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
} */