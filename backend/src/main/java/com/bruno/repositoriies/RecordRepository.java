package com.bruno.repositoriies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.entidades.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
