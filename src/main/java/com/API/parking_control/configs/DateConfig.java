package com.API.parking_control.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateConfig {

    public static final String DATETIME_FORMAT ="yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static LocalDateSerializer LOCAL_DATETIME_SERIALLIZER = new LocalDateSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATETIME_SERIALLIZER);
        return new ObjectMapper().registerModule(module);
    }
}
