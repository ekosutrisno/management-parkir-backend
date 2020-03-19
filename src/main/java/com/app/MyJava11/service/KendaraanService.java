package com.app.MyJava11.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.MyJava11.model.Kendaraan;
import com.app.MyJava11.model.PlatNomor;
import com.app.MyJava11.model.Response;
import com.app.MyJava11.model.ResponseByPlatNomor;
import com.app.MyJava11.model.ResponseByTipe;

import org.springframework.http.ResponseEntity;

public interface KendaraanService {

  List<Kendaraan> getAll();

  List<Response> getResponse();

  List<Kendaraan> SearchByPlatNomor(String nomorPlat);

  Optional<Response> getResponseByPlat(String platNomor);

  List<PlatNomor> getResponseByWarna(String warna);

  List<Kendaraan> searchByWarna(String warna);

  Map<String, String[]> getResponseByWarnaArray(String warna);

  ResponseByTipe jumlahKendaraanByTipe(String tipe);

  Kendaraan save(Kendaraan kendaraan);

  List<Response> saveKendaraan(Kendaraan kendaraan);

  Kendaraan update(Kendaraan kendaraan);

  Optional<Kendaraan> getById(Long id);

  Kendaraan delete(Long id);

  ResponseByPlatNomor keluar(String platNomor);

  ResponseEntity<?> keluarStatus(String platNomor);

}