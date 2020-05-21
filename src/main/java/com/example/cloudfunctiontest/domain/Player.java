package com.example.cloudfunctiontest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {

    @Id
    private String id;

    private String name;

    public Player() {}

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
