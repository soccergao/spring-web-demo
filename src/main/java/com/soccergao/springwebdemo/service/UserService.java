package com.soccergao.springwebdemo.service;

import com.soccergao.springwebdemo.web.dto.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    public List<User> query() {
        return Stream
                .of(User.builder().id(1L).username("root").password("root").birthday(LocalDateTime.now()).build(),
                        User.builder().id(2L).username("root").password("root").birthday(LocalDateTime.now()).build())
                .collect(Collectors.toList());

    }

    public User get(Long userId) {
        return User.builder()
                .id(userId)
                .username("root")
                .password("root")
                .birthday(LocalDateTime.now())
                .build();
    }

}
