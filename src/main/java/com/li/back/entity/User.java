package com.li.back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long id ;
    private long password;
    private String admin ;
}

