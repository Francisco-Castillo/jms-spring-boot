package com.example.jms.service;

import com.example.jms.dto.PetDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import javax.jms.Queue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author fcastillo
 */
@Service
@Slf4j
public class ConsumerService {

  @Autowired
  private Queue queue;

  @Autowired
  private JmsTemplate jmsTemplate;

  public ResponseEntity<Object> consume() {
    Map<String, Object> response = new HashMap<>();
    try {
      PetDTO pet = new ObjectMapper()
              .readValue((String) jmsTemplate.receiveAndConvert(queue), PetDTO.class);
      return new ResponseEntity<>(pet, HttpStatus.OK);
    } catch (Exception e) {
      String msg = "Ocurrio un error al consumir mensaje. " + e.getLocalizedMessage();
      log.error(msg);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
