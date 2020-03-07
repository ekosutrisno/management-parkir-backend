package com.app.MyJava11.controller;

import com.app.MyJava11.service.graphQL.GraphQlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;

@RestController
@RequestMapping("api/v1/kendaraan")
public class GraphQlController {

  @Autowired
  private GraphQlService graphQlService;

  @PostMapping
  public ResponseEntity<Object> getAll(@RequestBody String query) {
    ExecutionResult execute = graphQlService.getGraphQL().execute(query);
    return new ResponseEntity<>(execute, HttpStatus.OK);
  }

}