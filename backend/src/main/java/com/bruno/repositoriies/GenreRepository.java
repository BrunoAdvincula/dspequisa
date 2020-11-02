package com.bruno.repositoriies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.entidades.Genre;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
