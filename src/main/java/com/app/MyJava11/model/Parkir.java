package com.app.MyJava11.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Parkir.NAMA_TABLE)
public class Parkir implements Serializable {
  private static final long serialVersionUID = -6912411612177774336L;

  public static final String NAMA_TABLE = "parkir";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nama;
  private boolean isAvailable;

  public Parkir(Long id, String nama, boolean isAvailable) {
    this.id = id;
    this.nama = nama;
    this.isAvailable = isAvailable;
  }

  public Parkir() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

}
