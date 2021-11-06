package com.example.jms.controllers;

import com.example.jms.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fcastillo
 */
@RestController
@RequestMapping(value = "/consumer")
@CrossOrigin(origins = "*")
public class ConsumerController {

  @Autowired
  private ConsumerService consumerService;

  @GetMapping
  public ResponseEntity<Object> consume() {
    return consumerService.consume();
  }

}
