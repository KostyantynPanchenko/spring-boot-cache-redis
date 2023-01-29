package com.example.springbootcacheredis.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Player implements Serializable {
  private final Long id;
  private final String firstName;
  private final String lastName;
}
