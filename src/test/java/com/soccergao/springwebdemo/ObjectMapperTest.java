package com.soccergao.springwebdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soccergao.springwebdemo.entity.UserEntity;
import com.soccergao.springwebdemo.web.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ObjectMapperTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void userToUserEntity() throws JsonProcessingException {
        User user = User.builder().id(1L).username("sa").password("sa")
                .birthday(LocalDate.now()).build();
        UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);
        System.out.println(userEntity);
        System.out.println(objectMapper.writeValueAsString(userEntity));
    }

    @Test
    public void userEntityToUser() throws JsonProcessingException {
        UserEntity userEntity = UserEntity.builder().id(1L)._username("sa").password("sa")
                .birthday(LocalDate.now()).createTime(Optional.of(LocalDateTime.now()))
                .updateTime(Optional.of(LocalDateTime.now())).build();
        User user = objectMapper.convertValue(userEntity, User.class);
        System.out.println(user);
        System.out.println(objectMapper.writeValueAsString(user));
    }

    @Test
    public void stringToUser() throws IOException {
        String userString = "{\"id\":1,\"username\":\"sa\",\"password\":\"sa\"," +
                "\"birthday\":\"2019-07-12\",\"createTime\":\"2019-07-12 14:37:55\"," +
                "\"updateTime\":\"2019-07-12 14:37:55\"}";
        User user = objectMapper.readValue(userString, User.class);
        System.out.println(user);
        System.out.println(objectMapper.writeValueAsString(user));
    }

    @Test
    public void stringToUserEntity() throws IOException {
        String userEntityString = "{\"id\":1,\"username\":\"sa\",\"password\":\"sa\"," +
                "\"birthday\":\"2019-07-12\"}";
        UserEntity userEntity = objectMapper.readValue(userEntityString, UserEntity.class);
        System.out.println(userEntity);
        System.out.println(objectMapper.writeValueAsString(userEntity));
    }
}
