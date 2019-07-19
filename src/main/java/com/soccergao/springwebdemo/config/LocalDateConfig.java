package com.soccergao.springwebdemo.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class LocalDateConfig {

    @Value("${spring.jackson.datetime-format:yyyy-MM-dd HH:mm:ss}")
    private String dateTimePattern;

    @Value("${spring.jackson.date-format:yyyy-MM-dd}")
    private String datePattern;

    // 未测
    @Value("${spring.jackson.time-format:HH:mm:ss}")
    private String timePattern;

    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimePattern));
    }

    @Bean
    public LocalDateSerializer localDateSerializer() {
        return new LocalDateSerializer(DateTimeFormatter.ofPattern(datePattern));
    }

    @Bean
    public LocalTimeSerializer localTimeSerializer() {
        return new LocalTimeSerializer(DateTimeFormatter.ofPattern(timePattern));
    }

    @Bean
    public LocalDateTimeDeserializer localDateTimeDeserializer() {
        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimePattern));
    }

    @Bean
    public LocalDateDeserializer localDateDeserializer() {
        return new LocalDateDeserializer(DateTimeFormatter.ofPattern(datePattern));
    }

    @Bean
    public LocalTimeDeserializer localTimeDeserializer() {
        return new LocalTimeDeserializer(DateTimeFormatter.ofPattern(timePattern));
    }


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder
                .serializerByType(LocalDateTime.class, localDateTimeSerializer())
                .serializerByType(LocalDate.class, localDateSerializer())
                .serializerByType(LocalTime.class, localTimeSerializer())
                .deserializerByType(LocalDateTime.class, localDateTimeDeserializer())
                .deserializerByType(LocalDate.class, localDateDeserializer())
                .deserializerByType(LocalTime.class, localTimeDeserializer());
    }

}
