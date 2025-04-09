package com.examen.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario")
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ci")
    private Integer ci;

    @Column(name = "name")
    private String name;

    @Column(name = "telefono")
    private int telefono;
}
