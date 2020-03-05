package com.app.MyJava11.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Response {
  private String platNomor;
  private String parkirLot;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private Date tanggalMasuk;

  public String getPlatNomor() {
    return platNomor;
  }

  public void setPlatNomor(String platNomor) {
    this.platNomor = platNomor;
  }

  public String getParkirLot() {
    return parkirLot;
  }

  public void setParkirLot(String parkirLot) {
    this.parkirLot = parkirLot;
  }

  public Date getTanggalMasuk() {
    return tanggalMasuk;
  }

  public void setTanggalMasuk(Date tanggalMasuk) {
    this.tanggalMasuk = tanggalMasuk;
  }

  public Response() {
  }

  public Response(String platNomor, String parkirLot, Date tanggalMasuk) {
    this.platNomor = platNomor;
    this.parkirLot = parkirLot;
    this.tanggalMasuk = tanggalMasuk;
  }

}