package com.app.MyJava11.repository;

import java.util.List;
import java.util.Optional;

import com.app.MyJava11.model.Kendaraan;
import com.app.MyJava11.model.PlatNomor;
import com.app.MyJava11.model.Response;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, Long> {

  @Query("SELECT new com.app.MyJava11.model.Response(k.platNomor, p.nama, k.tanggal_masuk) FROM Kendaraan k JOIN k.parkiLot p")
  List<Response> getRed();

  @Query("SELECT new com.app.MyJava11.model.Response(k.platNomor, p.nama, k.tanggal_masuk) FROM Kendaraan k JOIN k.parkiLot p WHERE UPPER(k.platNomor)= UPPER(:plat)")
  Optional<Response> getResponsebyPlatNomor(@Param("plat") String platNomor);

  @Query("SELECT new com.app.MyJava11.model.PlatNomor(k.platNomor) FROM Kendaraan k WHERE UPPER(k.warna)= UPPER(:warna)")
  List<PlatNomor> getPlatNomor(@Param("warna") String warna);

  Optional<Kendaraan> findByPlatNomorIgnoreCase(String platNomor);

  List<Kendaraan> findByTipeIgnoreCase(String tipe);

  List<Kendaraan> findByWarnaIgnoreCase(String warna);

  @Query(value = "SELECT * FROM kendaraan WHERE UPPER(plat_nomor) LIKE UPPER(?)", nativeQuery = true)
  List<Kendaraan> searchByPlat(String platNomor);

}