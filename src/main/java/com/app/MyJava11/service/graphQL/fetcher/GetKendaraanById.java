package com.app.MyJava11.service.graphQL.fetcher;

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
    Long id = data.getArgument("id");
    Kendaraan kendaraan = kendRepo.findById(id).get();
    return kendaraan;
  }

}