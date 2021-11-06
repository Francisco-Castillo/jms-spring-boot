
package com.example.jms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author fcastillo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetDTO {

  private Long id;
  private String name;
  private String type;

}
