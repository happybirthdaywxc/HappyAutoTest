package com.happy.model;

import lombok.Data;

@Data
public class LoginCase {
    private int id;
    private String userName;
    private String password;
    private String expected;
}
