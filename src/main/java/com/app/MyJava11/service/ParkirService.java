package com.app.MyJava11.service;

import java.util.List;
import java.util.Optional;

import com.app.MyJava11.model.Parkir;

public interface ParkirService {

  List<Parkir> getAll();

  Optional<Parkir> getById(Long id);

  Parkir save(Parkir parkir);

  Parkir updateMasuk(Parkir parkir);

  Parkir updateKeluar(Parkir parkir);

}