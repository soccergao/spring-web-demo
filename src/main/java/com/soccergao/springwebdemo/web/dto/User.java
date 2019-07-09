package com.soccergao.springwebdemo.web.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.soccergao.springwebdemo.web.validator.PasswordCheck;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Data
@Builder
public class User {

    @JsonView(UserSimpleView.class)
    private Long id;

    @JsonView(UserSimpleView.class)
    @NotBlank(message = "用户名不能为空")
    private String username;

    @JsonView(UserDetailView.class)
    @PasswordCheck
    private String password;

    @JsonView(UserDetailView.class)
    @Past(message = "生日必须是过去的时间")
    private LocalDateTime birthday;

//    @JsonView使用方法:
//    1. 使用接口来声明多个视图
//    2. 在pojo的get方法上指定视图
//    3. 在Controller方法上指定视图
    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView {}
}
