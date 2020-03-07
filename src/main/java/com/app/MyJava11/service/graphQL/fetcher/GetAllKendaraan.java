package com.app.MyJava11.service.graphQL.fetcher;

import java.util.List;

import com.app.MyJava11.model.Kendaraan;
import com.app.MyJava11.repository.KendaraanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetAllKendaraan implements DataFetcher<List<Kendaraan>> {

  @Autowired
  private KendaraanRepository kendaraanRepository;

  @Override
  public List<Kendaraan> get(DataFetchingEnvironment arg0) {
    return kendaraanRepository.findAll();
  }

}