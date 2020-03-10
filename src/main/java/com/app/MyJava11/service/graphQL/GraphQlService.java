package com.app.MyJava11.service.graphQL;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import com.app.MyJava11.service.graphQL.fetcher.GetAllKendaraan;
import com.app.MyJava11.service.graphQL.fetcher.GetAllParkir;
import com.app.MyJava11.service.graphQL.fetcher.GetKendaraanById;
import com.app.MyJava11.service.graphQL.fetcher.GetParkirById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQlService {

  @Value("classpath:kendaraan.graphqls")
  Resource resouce;

  private GraphQL graphQL;

  @Autowired
  private GetAllKendaraan getAllKendaraan;

  @Autowired
  private GetKendaraanById getKendaraanById;

  @Autowired
  private GetAllParkir getAllParkir;

  @Autowired
  private GetParkirById getParkirById;

  @PostConstruct
  private void loadSchema() throws IOException {

    File schemaFile = resouce.getFile();

    TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
    RuntimeWiring wiring = buildRuntimeWiring();

    GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
    graphQL = GraphQL.newGraphQL(schema).build();

  }

  private RuntimeWiring buildRuntimeWiring() {
    return RuntimeWiring.newRuntimeWiring()
        .type("Query",
            typeWiring -> typeWiring.dataFetcher("getAllKendaraan", getAllKendaraan)
                .dataFetcher("getKendaraanById", getKendaraanById).dataFetcher("getAllParkir", getAllParkir)
                .dataFetcher("getParkirById", getParkirById))
        .build();
  }

  @Bean
  public GraphQL getGraphQL() {
    return graphQL;
  }

}