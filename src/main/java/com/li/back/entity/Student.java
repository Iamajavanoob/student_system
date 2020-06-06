package com.li.back.entity;

import lombok.Data;


import javax.persistence.*;
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private int age;

    public boolean equals(Student student){
        if (student instanceof Student){
            return (name == student.getName());
        }
        return false;
    }


}
