package com.app.MyJava11.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.app.MyJava11.dto.CustomResponse;
import com.app.MyJava11.model.Parkir;
import com.app.MyJava11.service.ParkirService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/parkir", produces = "application/json")
@CrossOrigin(origins = "*")
public class ParkirController {

  @Autowired
  private ParkirService parkirService;

  @GetMapping("all")
  public ResponseEntity<?> getAllData() {
    List<Parkir> newData = parkirService.getAll();

    CustomResponse pPenuh = new CustomResponse();
    pPenuh.setStatus("Slot Parkir Telah Penuh!");

    List<CustomResponse> data = new ArrayList<>();
    data.add(pPenuh);

    if (newData.size() <= 0)
      return new ResponseEntity<>(pPenuh, HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(newData, HttpStatus.OK);
  }

  @GetMapping("get-bynama")
  public Parkir getByNama(@RequestParam("nama") String nama) {
    return parkirService.findByNama(nama);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Long id) {
    Optional<Parkir> data = parkirService.getById(id);
    if (data.isPresent())
      return new ResponseEntity<>(data.get(), HttpStatus.OK);
    return new ResponseEntity<>(null, HttpStatus.OK);
  }

  @PostMapping("add")
  public Parkir addData(@RequestBody Parkir parkir) {
    return parkirService.save(parkir);
  }
}