package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence-generator")
    private int id;


    @Column(unique = true)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID uuid;

    private String mssg;
}
