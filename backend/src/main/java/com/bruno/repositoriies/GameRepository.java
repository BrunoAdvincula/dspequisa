package com.bruno.repositoriies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.entidades.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	
}
