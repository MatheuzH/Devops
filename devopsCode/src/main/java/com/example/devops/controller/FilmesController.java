package com.example.devops.controller;

import com.example.devops.controller.Request.FilmesRequest;
import com.example.devops.model.Filmes;
import com.example.devops.repository.FilmesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private FilmesRepository repository;

    @PostMapping
    public ResponseEntity<Filmes> criar(@Valid @RequestBody FilmesRequest request) {

        Filmes filmes = new Filmes();
        filmes.setId(UUID.randomUUID());
        filmes.setNomeFilme(request.getNomeFilme());
        filmes.setGenero(request.getGenero());
        filmes.setDuracao(request.getDuracao());


        this.repository.save(filmes);

        return new ResponseEntity<>(filmes, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Filmes>> obterTodos(){
        List<Filmes> filmes = this.repository.findAll();
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Filmes> obter(@PathVariable("id") UUID id) {
        return this.repository.findById(id).map(item -> {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Filmes> excluirFilmes(@PathVariable("id") UUID id) {
        Optional<Filmes> optFilmes = this.repository.findById(id);

        if (optFilmes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Filmes filmes = optFilmes.get();

        this.repository.deleteById(id);

        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Filmes> atualizarFilmes(@PathVariable("id") UUID id,@Valid @RequestBody FilmesRequest request) {
        Optional<Filmes> optFilmes = this.repository.findById(id);

        if (optFilmes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Filmes filmes = optFilmes.get();

        filmes.setNomeFilme(request.getNomeFilme());
        filmes.setGenero(request.getGenero());
        filmes.setDuracao(request.getDuracao());

        this.repository.save(filmes);

        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }
}
