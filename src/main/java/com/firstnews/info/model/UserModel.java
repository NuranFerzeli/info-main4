package com.firstnews.info.model;


import com.firstnews.info.entity.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserModel {
String username;
String password;
Long statusId;

    public UserModel(User userEntity) {
    }
}
