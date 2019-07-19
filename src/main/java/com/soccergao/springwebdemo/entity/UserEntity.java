package com.soccergao.springwebdemo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
/**
 * @JsonInclude: 忽略null
 */
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class UserEntity {
    private Long id;
    /**
     * READ_ONLY: 与WRITE_ONLY相反
     * WRITE_ONLY: 转字符串或其他对象是过滤
     */
    @JsonProperty(value = "username", access = JsonProperty.Access.WRITE_ONLY)
    private String _username;
    private String password;
    /**
     *
     */
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDate birthday;

    private Optional<LocalDateTime> createTime;
    private Optional<LocalDateTime> updateTime;
}
