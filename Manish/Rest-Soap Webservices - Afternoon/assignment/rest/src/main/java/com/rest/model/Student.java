package com.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {

    private UUID id;
    @NotBlank
    @NotNull
    private String name;
    private int age;

    public Student(@JsonProperty("name") String name, @JsonProperty("age") int age) {
        id = UUID.randomUUID();
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
