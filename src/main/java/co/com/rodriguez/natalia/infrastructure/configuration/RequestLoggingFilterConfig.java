package co.com.rodriguez.natalia.infrastructure.configuration;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.log4j.Log4j2;
/**
 * LogginFilterConfig
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@Configuration
@Log4j2
public class RequestLoggingFilterConfig {

  @Bean
  public HttpTraceRepository httpTraceRepository() {
    return new InMemoryHttpTraceRepository() {
      ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

      @Override
      public void add(HttpTrace trace) {
        try {
          log.info(objectMapper.writeValueAsString(trace));
        } catch (JsonProcessingException e) {
          log.error(e.getMessage(), e);
        }
        super.add(trace);
      }
    };
  }
}
