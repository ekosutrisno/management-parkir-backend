package com.app.MyJava11.dto;

import com.app.MyJava11.model.Kendaraan;

public class KendaraanDto {

  private Kendaraan kendaraan;

  public KendaraanDto() {
  }

  public KendaraanDto(Kendaraan kendaraan) {
    this.kendaraan = kendaraan;
  }

  public Kendaraan getKendaraan() {
    return kendaraan;
  }

  public void setKendaraan(Kendaraan kendaraan) {
    this.kendaraan = kendaraan;
  }

}