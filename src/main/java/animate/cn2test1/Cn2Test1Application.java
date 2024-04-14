package animate.cn2test1;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.util.TimeZone;

@SpringBootApplication
public class Cn2Test1Application {

    public static void main(String[] args) {
        SpringApplication.run(Cn2Test1Application.class, args);
    }

}
