package com.buk.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
  
  @GetMapping("/test")
  public String testPage() {
    log.debug("======= Teest Page =====");
    return "index.html";
  }
}
