package com.buk.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

  @GetMapping("/popup")
  public String kosisPopup() {
    return "subjectStatsTree";
  }

  @GetMapping("/juminStat")
  public String juminStat() {
    return "jumin_stat";
  }

  @GetMapping("/juminAge")
  public String juminAge() {
    return "jumin_age";
  }

  @GetMapping("/juminBirth")
  public String juminBirth() {
    return "jumin_birth";
  }

  @GetMapping("/bukToday")
  public String bukToday() {
    return "buk_today";
  }
}
