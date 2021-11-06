package com.example.jms.controllers;

import com.example.jms.dto.PetDTO;
import com.example.jms.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fcastillo
 */
@RestController
@RequestMapping(value = "/producer")
@CrossOrigin(origins = "*")
public class ProducerController {

  @Autowired
  private ProducerService producerService;

  @PostMapping(value = "/send")
  public ResponseEntity<Object> send(@RequestBody PetDTO pet) {
    return producerService.send(pet);
  }

}
