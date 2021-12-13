package com.thaiitwork.dto;


import lombok.Data;

import java.io.Serializable;
@Data
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String userName;
    private String password;
    //need default constructor for JSON Parsing
    public JwtRequest() {
    }
}