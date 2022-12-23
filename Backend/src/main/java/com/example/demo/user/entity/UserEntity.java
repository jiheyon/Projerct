package com.example.demo.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.websocket.server.ServerEndpoint;

@Getter @Setter @ToString
@AllArgsConstructor
public class UserEntity {

    private String id;
    private String password;
    private String name;
    private int age;
    private String address;
}
