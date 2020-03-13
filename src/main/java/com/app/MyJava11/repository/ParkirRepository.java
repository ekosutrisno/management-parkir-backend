package com.app.MyJava11.repository;

import java.util.List;

import com.app.MyJava11.model.Parkir;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkirRepository extends JpaRepository<Parkir, Long> {

  Parkir findByNama(String nama);

  String MY_QUERY = "SELECT * FROM parkir ORDER BY id ASC";

  @Query(value = MY_QUERY, nativeQuery = true)
  List<Parkir> findAllOrderByIdAsc();
}