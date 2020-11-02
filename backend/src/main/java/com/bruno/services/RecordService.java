package com.bruno.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.dto.RecordDTO;
import com.bruno.dto.RecordInsertDTO;
import com.bruno.entidades.Game;
import com.bruno.entidades.Record;
import com.bruno.repositoriies.GameRepository;
import com.bruno.repositoriies.RecordRepository;

@Service
public class RecordService {
	@Autowired
	private RecordRepository recordRepository;
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO inser(RecordInsertDTO recordInsertDTO) {
		Record record = new Record();
		record.setName(recordInsertDTO.getName());
		record.setAge(recordInsertDTO.getAge());
		record.setMoment(Instant.now());
		Game game = gameRepository.getOne(recordInsertDTO.getGameId());
		record.setGame(game);
		record = recordRepository.save(record);
		
		return new RecordDTO(record);
	}
	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		
		return recordRepository.findByMoments(minDate, maxDate, pageRequest).map(x->new RecordDTO(x));
	}
	
}
