package com.buk.admin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="tb_buktoday_cd")
public class BukTodayCd {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private int titleCd;
  private String title;
}