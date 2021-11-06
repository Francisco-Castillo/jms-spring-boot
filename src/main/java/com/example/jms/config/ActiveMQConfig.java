package com.example.jms.config;

import javax.jms.Queue;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

/**
 *
 * @author fcastillo
 */
@Configuration
@EnableJms
public class ActiveMQConfig {

  @Value("${activemq.broker.url}")
  private String urlBroker;

  @Value("${queue.name}")
  private String queueName;

  @Bean
  public JmsTemplate jmsTemplate() {
    return new JmsTemplate(connectionFactory());
  }

  @Bean
  public ActiveMQConnectionFactory connectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(urlBroker);
    return connectionFactory;
  }

  @Bean
  public Queue queue() {
    return new ActiveMQQueue(queueName);
  }

}
