package com.app.MyJava11.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.app.MyJava11.model.Parkir;
import com.app.MyJava11.repository.ParkirRepository;
import com.app.MyJava11.service.ParkirService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkirServiceImpl implements ParkirService {

  @Autowired
  private ParkirRepository parkirRepo;

  @Override
  public List<Parkir> getAll() {
    List<Parkir> parkirs = new ArrayList<>();
    for (Parkir parkir : parkirRepo.findAllOrderByIdAsc()) {
      if (parkir.isAvailable())
        parkirs.add(parkir);
    }
    return parkirs;
  }

  @Override
  public Optional<Parkir> getById(Long id) {
    return parkirRepo.findById(id);
  }

  @Override
  public Parkir save(Parkir parkir) {
    parkir.setAvailable(true);
    return parkirRepo.save(parkir);
  }

  @Override
  public Parkir updateMasuk(Parkir parkir) {
    parkir.setAvailable(false);
    return parkirRepo.save(parkir);
  }

  @Override
  public Parkir updateKeluar(Parkir parkir) {
    parkir.setAvailable(true);
    return parkirRepo.save(parkir);
  }

  @Override
  public Parkir findByNama(String nama) {
    return parkirRepo.findByNama(nama);
  }

}