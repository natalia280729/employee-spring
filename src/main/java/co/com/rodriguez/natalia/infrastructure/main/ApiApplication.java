package co.com.rodriguez.natalia.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application initializer
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@SpringBootApplication(scanBasePackages = {"co.com.rodriguez.natalia.*"})
@EnableJpaRepositories("co.com.rodriguez.natalia.modules.employee.repositories")
@ComponentScan(basePackages = {"co.com.rodriguez.natalia.*"})
@EntityScan("co.com.rodriguez.natalia.modules.employee.entities")
public class ApiApplication extends SpringBootServletInitializer {

  public static void main(final String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }
}
