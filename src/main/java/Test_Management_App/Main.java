package Test_Management_App;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EntityScan("Test_Management_App.Model")
@EnableJpaRepositories("Test_Management_App.Repository")
public class Main extends SpringBootServletInitializer implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Main.class);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }


    //TODO change path to ojdbc from C:/ to variable

}
