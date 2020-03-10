package com.app.MyJava11.service.graphQL.fetcher;

import java.util.Optional;

import com.app.MyJava11.model.Kendaraan;
import com.app.MyJava11.repository.KendaraanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetKendaraanById implements DataFetcher<Kendaraan> {

  @Autowired
  private KendaraanRepository kendRepo;

  @Override
  public Kendaraan get(DataFetchingEnvironment data) {
    String dt = data.getArgument("id");
    Long id = Long.parseLong(dt);
    Kendaraan kendTemp = new Kendaraan();
    kendTemp.setId(0L);
    kendTemp.setKeluar(true);
    kendTemp.setParkiLot(null);
    kendTemp.setPlatNomor("");
    kendTemp.setWarna("");
    kendTemp.setTanggal_keluar(null);
    kendTemp.setTanggal_masuk(null);
    kendTemp.setTipe("");

    Optional<Kendaraan> kendaraan = kendRepo.findById(id);

    if (kendaraan.isPresent()) {
      kendTemp = kendaraan.get();
      return kendTemp;
    }
    return kendTemp;

  }

}