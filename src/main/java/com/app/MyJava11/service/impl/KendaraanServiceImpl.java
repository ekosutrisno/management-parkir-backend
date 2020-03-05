package com.app.MyJava11.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.app.MyJava11.model.Kendaraan;
import com.app.MyJava11.model.PlatNomor;
import com.app.MyJava11.model.Response;
import com.app.MyJava11.model.ResponseByPlatNomor;
import com.app.MyJava11.model.ResponseByTipe;
import com.app.MyJava11.repository.KendaraanRepository;
import com.app.MyJava11.service.KendaraanService;
import com.app.MyJava11.service.ParkirService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class KendaraanServiceImpl implements KendaraanService {

  @Autowired
  private KendaraanRepository kendaraanRepository;

  @Autowired
  private ParkirService parkirService;

  @Override
  public List<Kendaraan> getAll() {
    List<Kendaraan> dataKendaraan = new ArrayList<>();
    for (Kendaraan kendaraan : kendaraanRepository.findAll()) {
      if (!kendaraan.isKeluar())
        dataKendaraan.add(kendaraan);
    }
    return dataKendaraan;
  }

  @Override
  public List<Response> getResponse() {
    return kendaraanRepository.getRed();
  }

  @Override
  public Optional<Kendaraan> SearchByPlatNomor(String nomorPlat) {
    return kendaraanRepository.findByPlatNomorIgnoreCase(nomorPlat);
  }

  @Override
  public List<PlatNomor> getResponseByWarna(String warna) {
    return kendaraanRepository.getPlatNomor(warna);
  }

  @Override
  public Map<String, String[]> getResponseByWarnaArray(String warna) {
    List<PlatNomor> plat = kendaraanRepository.getPlatNomor(warna);

    String[] data = new String[plat.size()];
    Map<String, String[]> output = new HashMap<>();

    for (PlatNomor string : plat) {
      for (int i = 0; i < data.length; i++) {
        data[i] = string.getPlat_nomor();
      }
    }
    output.put("plat_nomor", data);
    return output;

  }

  @Override
  public ResponseByTipe jumlahKendaraanByTipe(String tipe) {
    List<Kendaraan> kendaraans = kendaraanRepository.findByTipeIgnoreCase(tipe);

    ResponseByTipe banyakByTipe = new ResponseByTipe();
    banyakByTipe.setJumlahKendaraan(kendaraans.size());
    return banyakByTipe;
  }

  @Override
  public Kendaraan save(Kendaraan kendaraan) {
    kendaraan.setKeluar(false);
    kendaraan.setTanggal_masuk(new Date());
    return kendaraanRepository.save(kendaraan);
  }

  @Override
  public Kendaraan update(Kendaraan kendaraan) {
    kendaraan.setKeluar(true);
    kendaraan.setTanggal_keluar(new Date());
    return kendaraanRepository.save(kendaraan);
  }

  @Override
  public Optional<Kendaraan> getById(Long id) {
    return kendaraanRepository.findById(id);
  }

  @Override
  public Kendaraan delete(Long id) {
    Kendaraan kendaraan = this.getById(id).get();
    return update(kendaraan);
  }

  @Override
  public List<Response> saveKendaraan(Kendaraan kendaraan) {
    kendaraan.setKeluar(false);
    kendaraan.setTanggal_masuk(new Date());
    kendaraanRepository.save(kendaraan);
    return getResponse();
  }

  @Override
  public Optional<Response> getResponseByPlat(String platNomor) {
    return kendaraanRepository.getResponsebyPlatNomor(platNomor);
  }

  @Override
  public ResponseByPlatNomor keluar(String platNomor) {
    Kendaraan data = kendaraanRepository.findByPlatNomorIgnoreCase(platNomor).get();
    ResponseByPlatNomor res = new ResponseByPlatNomor();

    Date masuk = data.getTanggal_masuk();
    Date keluar = new Date();
    int banyakJam = getSelisihJam(keluar, masuk);
    String jumlahBayar = Integer.toString(jumlahBayar(banyakJam, data));

    if (!data.isKeluar()) {
      res.setPlatNomor(data.getPlatNomor());
      res.setTanggal_masuk(masuk);
      res.setTanggal_keluar(keluar);
      res.setJumlahBayar(jumlahBayar);

      delete(data.getId());
      parkirService.updateKeluar(data.getParkiLot());

      return res;
    }
    return null;
  }

  private static int getSelisihJam(Date jamMasuk, Date jamKeluar) {

    long selisih = jamKeluar.getTime() - (jamMasuk.getTime());

    int hari = (int) TimeUnit.MILLISECONDS.toDays(selisih);
    selisih -= TimeUnit.DAYS.toMillis(hari);

    int jam = (int) TimeUnit.MILLISECONDS.toHours(selisih);
    selisih -= TimeUnit.HOURS.toMillis(jam);
    return jam;
  }

  private static int jumlahBayar(int banyakJam, Kendaraan kendaraan) {
    String tipeMobil = kendaraan.getTipe();
    int bayaranPokok = 0;
    int bayarJamSelanjutnya = 0;

    if (banyakJam < 0)
      banyakJam *= -1;

    if (tipeMobil.equalsIgnoreCase("SUV")) {
      bayaranPokok = 25000;
      bayarJamSelanjutnya = bayaranPokok * 25 / 100;
    } else {
      bayaranPokok = 30000;
      bayarJamSelanjutnya = bayaranPokok * 25 / 100;
    }

    int bayaranLanjutan = bayarJamSelanjutnya * banyakJam;
    int totalBayar = bayaranPokok + bayaranLanjutan;
    return totalBayar;
  }

  @Override
  public ResponseEntity<?> keluarStatus(String platNomor) throws ResourceAccessException {
    Optional<Kendaraan> data = kendaraanRepository.findByPlatNomorIgnoreCase(platNomor);
    ResponseByPlatNomor res = new ResponseByPlatNomor();

    Map<String, Boolean> response = new HashMap<>();

    Date masuk = data.get().getTanggal_masuk();
    Date keluar = new Date();
    int banyakJam = getSelisihJam(keluar, masuk);
    String jumlahBayar = Integer.toString(jumlahBayar(banyakJam, data.get()));

    if (data.isPresent()) {
      Kendaraan kendaraan = data.get();
      if (!kendaraan.isKeluar()) {
        res.setPlatNomor(kendaraan.getPlatNomor());
        res.setTanggal_masuk(masuk);
        res.setTanggal_keluar(keluar);
        res.setJumlahBayar(jumlahBayar);

        delete(kendaraan.getId());
        parkirService.updateKeluar(kendaraan.getParkiLot());

        response.put("Keluar", Boolean.TRUE);
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
    }
    if (!data.isPresent()) {
      response.put("Keluar", Boolean.TRUE);
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    response.put("Keluar", Boolean.TRUE);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}