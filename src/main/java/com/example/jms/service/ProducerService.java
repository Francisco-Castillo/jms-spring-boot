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
public class ProducerService {

  @Autowired
  private Queue queue;

  @Autowired
  private JmsTemplate jmsTemplate;

  public ResponseEntity<Object> send(PetDTO pet) {
    Map<String, Object> response = new HashMap<>();
    try {
      
      ObjectMapper objectMapper = new ObjectMapper();
      
      // Convertir a String
      String sPet = objectMapper.writeValueAsString(pet);
      
      jmsTemplate.convertAndSend(queue, sPet);
      
      response.put("message", "Mensaje enviado exitosamente");
      
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      String msg = "Ocurrio un error al enviar mensaje. Excepcion: " + e.getLocalizedMessage();
      log.error(msg);
      response.put("message", msg);
      return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
