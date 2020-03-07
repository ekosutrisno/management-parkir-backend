package com.app.MyJava11.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.MyJava11.dto.CustomResponse;
import com.app.MyJava11.dto.KendaraanDto;
import com.app.MyJava11.model.Kendaraan;
import com.app.MyJava11.model.Parkir;
import com.app.MyJava11.model.PlatNomor;
import com.app.MyJava11.model.Response;
import com.app.MyJava11.model.ResponseByPlatNomor;
import com.app.MyJava11.model.ResponseByTipe;
import com.app.MyJava11.service.KendaraanService;
import com.app.MyJava11.service.ParkirService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/kendaraan", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class KendaraanController {

  @Autowired
  private KendaraanService kendaraanService;

  @Autowired
  private ParkirService parkirService;

  @GetMapping("all")
  public List<Kendaraan> getAllKendaraan() {
    return kendaraanService.getAll();
  }

  @GetMapping("response")
  public List<Response> getAllResponse() {
    return kendaraanService.getResponse();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getDataById(@PathVariable("id") Long id) {
    Optional<Kendaraan> kOptional = kendaraanService.getById(id);

    CustomResponse pPenuh = new CustomResponse();
    pPenuh.setStatus("Data dengan id: " + id + " tidak ditemukan.");

    List<CustomResponse> data = new ArrayList<>();
    data.add(pPenuh);

    if (kOptional.isPresent())
      return new ResponseEntity<>(kOptional.get(), HttpStatus.OK);
    return new ResponseEntity<>(data, HttpStatus.OK);
  }

  @GetMapping("plat")
  public ResponseEntity<?> getAllResponse(@RequestParam("noPlat") String platNomor) {
    Optional<Response> dataResponse = kendaraanService.getResponseByPlat(platNomor);

    CustomResponse pPenuh = new CustomResponse();
    pPenuh.setStatus("Plat " + platNomor + " tidak ditemukan.");

    List<CustomResponse> data = new ArrayList<>();
    data.add(pPenuh);

    if (dataResponse.isPresent())
      return new ResponseEntity<>(dataResponse.get(), HttpStatus.OK);
    return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);

  }

  @PostMapping(value = "add")
  public Kendaraan addKendaraan(@RequestBody Kendaraan kendaraan) {

    Parkir parkir = parkirService.getById(kendaraan.getParkiLot().getId()).get();
    parkirService.updateMasuk(parkir);

    return kendaraanService.save(kendaraan);
  }

  @PostMapping(value = "addResponse")
  public List<Response> addResponseKendaraan(@RequestBody KendaraanDto kendaraandDto) {
    Kendaraan kendaraan = kendaraandDto.getKendaraan();
    kendaraanService.saveKendaraan(kendaraan);
    return this.getAllResponse();
  }

  @GetMapping("search")
  public ResponseEntity<?> gResponseByPlatNomor(@RequestParam("plat") String plat) {
    Optional<Kendaraan> platNomor = kendaraanService.SearchByPlatNomor(plat);

    CustomResponse pPenuh = new CustomResponse();
    pPenuh.setStatus("Plat " + plat + " tidak ditemukan.");

    List<CustomResponse> data = new ArrayList<>();
    data.add(pPenuh);

    if (platNomor.isPresent())
      return new ResponseEntity<>(platNomor.get(), HttpStatus.OK);
    return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
  }

  @GetMapping("keluar")
  public ResponseByPlatNomor kendaraanKeluar(@RequestParam("platNomor") String platNomor) {
    return kendaraanService.keluar(platNomor);
  }

  @GetMapping("status")
  public ResponseEntity<?> kendaraanKeluarStatus(@RequestParam("platNomor") String platNomor) {
    return kendaraanService.keluarStatus(platNomor);
  }

  @GetMapping("jumlahByTipe")
  public ResponseByTipe jumlahKendaraanByTipe(@RequestParam("tipe") String tipe) {
    return kendaraanService.jumlahKendaraanByTipe(tipe);
  }

  @GetMapping("warna")
  public List<PlatNomor> getPlatByWarnaMobil(@RequestParam("warna") String warna) {
    return kendaraanService.getResponseByWarna(warna);
  }

  @GetMapping("warnaArray")
  public ResponseEntity<?> getArrayPlat(@RequestParam("warna") String warna) {
    Map<String, String[]> data = kendaraanService.getResponseByWarnaArray(warna);
    return new ResponseEntity<>(data, HttpStatus.OK);
  }

}