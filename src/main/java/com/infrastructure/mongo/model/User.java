package com.infrastructure.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User{
    @Id
    private String id;
    //自动创建索引
    @Indexed
    private String name;
    @Indexed
    private int age;
    private List<Address> addresses;
}