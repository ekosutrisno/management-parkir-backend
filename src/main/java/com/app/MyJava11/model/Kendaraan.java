package com.app.MyJava11.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = Kendaraan.TABLE_NAME)
public class Kendaraan {
	public static final String TABLE_NAME = "kendaraan";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String platNomor;
	private String tipe;
	private String warna;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
	private Date tanggal_masuk;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+07:00")
	private Date tanggal_keluar;

	private boolean isKeluar;

	@OneToOne
	@JoinColumn(name = "parkir", referencedColumnName = "id")
	private Parkir parkiLot;

	public Kendaraan() {
	}

	public Kendaraan(String tipe, String warna, Date tanggal_masuk, Date tanggal_keluar, boolean isKeluar,
			Parkir parkiLot, String platNomor) {
		this.tipe = tipe;
		this.warna = warna;
		this.tanggal_masuk = tanggal_masuk;
		this.tanggal_keluar = tanggal_keluar;
		this.isKeluar = isKeluar;
		this.parkiLot = parkiLot;
		this.platNomor = platNomor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipe() {
		return tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

	public String getWarna() {
		return warna;
	}

	public void setWarna(String warna) {
		this.warna = warna;
	}

	public Date getTanggal_masuk() {
		return tanggal_masuk;
	}

	public void setTanggal_masuk(Date tanggal_masuk) {
		this.tanggal_masuk = tanggal_masuk;
	}

	public boolean isKeluar() {
		return isKeluar;
	}

	public void setKeluar(boolean isKeluar) {
		this.isKeluar = isKeluar;
	}

	public Parkir getParkiLot() {
		return parkiLot;
	}

	public void setParkiLot(Parkir parkiLot) {
		this.parkiLot = parkiLot;
	}

	public String getPlatNomor() {
		return platNomor;
	}

	public void setPlatNomor(String platNomor) {
		this.platNomor = platNomor;
	}

	public Date getTanggal_keluar() {
		return tanggal_keluar;
	}

	public void setTanggal_keluar(Date tanggal_keluar) {
		this.tanggal_keluar = tanggal_keluar;
	}

}