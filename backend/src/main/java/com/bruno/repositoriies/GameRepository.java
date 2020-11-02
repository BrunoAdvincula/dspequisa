package com.bruno.repositoriies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.entidades.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
}
