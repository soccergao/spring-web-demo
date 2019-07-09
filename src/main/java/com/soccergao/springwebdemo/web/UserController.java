package com.soccergao.springwebdemo.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.soccergao.springwebdemo.service.UserService;
import com.soccergao.springwebdemo.web.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User save(@Valid @RequestBody User user) {
        user.setId(1L);
        return user;
    }

    @JsonView(User.UserDetailView.class)
    @GetMapping("/{id:\\d+}")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

    @JsonView(User.UserSimpleView.class)
    @GetMapping
    public List<User> query() {
        return userService.query();
    }


}

@RestController
@RequestMapping("/v2/user")
class UserController2 {
    @PostMapping
    public User save(@Valid @RequestBody User user, BindingResult errors) {
        if (errors != null) {
            errors.getAllErrors()
                    .forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        user.setId(1L);
        return user;
    }
}