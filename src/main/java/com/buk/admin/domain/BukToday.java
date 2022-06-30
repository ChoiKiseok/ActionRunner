package com.buk.admin.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "tb_buktoday")
public class BukToday {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;
  private int titleCd;
  private int value;
  private String baseMonth;
  private LocalDate dt;

  @ManyToOne
  @JoinColumn(name = "title_cd")
  private BukTodayCd title;
}
