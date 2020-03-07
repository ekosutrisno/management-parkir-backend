package com.app.MyJava11.service.graphQL.fetcher;

import com.app.MyJava11.model.Parkir;
import com.app.MyJava11.repository.ParkirRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetParkirById implements DataFetcher<Parkir> {

  @Autowired
  private ParkirRepository kendRepo;

  @Override
  public Parkir get(DataFetchingEnvironment data) {
    Long id = data.getArgument("id");
    Parkir parkir = kendRepo.findById(id).get();
    return parkir;
  }

}