package com.example.devops.controller.Request;

import lombok.Data;

import java.util.UUID;

@Data
public class FilmesRequest {

    private UUID id;

    private String nomeFilme;

    private String genero;

    private float duracao;
}
