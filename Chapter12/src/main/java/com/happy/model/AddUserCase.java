package com.happy.model;

import lombok.Data;

@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String expected;
}
