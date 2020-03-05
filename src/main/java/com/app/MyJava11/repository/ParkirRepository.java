package com.app.MyJava11.repository;

import com.app.MyJava11.model.Parkir;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkirRepository extends JpaRepository<Parkir, Long> {

  Parkir findByNama(String nama);
}