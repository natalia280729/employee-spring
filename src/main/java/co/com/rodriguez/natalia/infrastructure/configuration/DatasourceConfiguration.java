package co.com.rodriguez.natalia.infrastructure.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring boot configuration for Datasource runtime
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@Configuration
public class DatasourceConfiguration {

  public static final String JPA_DATASOURCE = "datasource-employees";

  @Bean(name = JPA_DATASOURCE)
  @ConfigurationProperties(prefix = "spring.datasource.db")
  public DataSource dataSourceEmployees() {
    return DataSourceBuilder.create().build();
  }
}
