package com.app.MyJava11.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseByPlatNomor {
  private String platNomor;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
  private Date tanggal_masuk;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
  private Date tanggal_keluar;

  private String jumlahBayar;

  public String getPlatNomor() {
    return platNomor;
  }

  public void setPlatNomor(String platNomor) {
    this.platNomor = platNomor;
  }

  public Date getTanggal_masuk() {
    return tanggal_masuk;
  }

  public void setTanggal_masuk(Date tanggal_masuk) {
    this.tanggal_masuk = tanggal_masuk;
  }

  public Date getTanggal_keluar() {
    return tanggal_keluar;
  }

  public void setTanggal_keluar(Date tanggal_keluar) {
    this.tanggal_keluar = tanggal_keluar;
  }

  public String getJumlahBayar() {
    return jumlahBayar;
  }

  public void setJumlahBayar(String jumlahBayar) {
    this.jumlahBayar = jumlahBayar;
  }

}