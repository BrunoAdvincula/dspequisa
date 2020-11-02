package com.bruno.repositoriies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.entidades.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
