package com.example.devops.repository;

import com.example.devops.model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, UUID> {
}
