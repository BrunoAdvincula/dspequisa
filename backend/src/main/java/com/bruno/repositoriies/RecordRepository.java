package com.bruno.repositoriies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.entidades.Record;
@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

}
