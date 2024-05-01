package com.example.devops.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String nomeFilme;

    @Column
    private String genero;

    @Column
    private float duracao;

}
