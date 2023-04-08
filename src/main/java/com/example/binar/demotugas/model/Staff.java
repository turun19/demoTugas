package com.example.binar.demotugas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "staff_list")
@Data
public class Staff {
    @Id
    @Getter
    @Setter
    private int staff_id;
    @Getter
    @Setter
    private String first_name;
    @Getter
    @Setter
    private String last_name;
    @Getter
    @Setter
    private int address_id;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private int store_id;
    @Getter
    @Setter
    private int active;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
}
