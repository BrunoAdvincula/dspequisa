package com.bruno.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.dto.RecordDTO;
import com.bruno.dto.RecordInsertDTO;
import com.bruno.services.RecordService;

@RestController
@RequestMapping(value="/records")
public class RecordResource {
	@Autowired
	private RecordService recordService;
	@PostMapping
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto){
		RecordDTO recordDTO = recordService.inser(dto);
		return ResponseEntity.ok().body(recordDTO);
	}

}
