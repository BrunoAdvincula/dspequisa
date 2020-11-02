package com.bruno.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.dto.GameDTO;
import com.bruno.entidades.Game;
import com.bruno.repositoriies.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	public GameService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll(){
		List<Game> list = gameRepository.findAll();
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}
	
}
