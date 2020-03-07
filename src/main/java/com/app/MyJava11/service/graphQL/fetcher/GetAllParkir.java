package com.app.MyJava11.service.graphQL.fetcher;

import java.util.List;

import com.app.MyJava11.model.Parkir;
import com.app.MyJava11.repository.ParkirRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetAllParkir implements DataFetcher<List<Parkir>> {

  @Autowired
  private ParkirRepository parkirRepository;

  @Override
  public List<Parkir> get(DataFetchingEnvironment arg0) {
    return parkirRepository.findAll();
  }

}