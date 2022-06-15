package com.buk.data.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
  
  @GetMapping("/test")
  public String testPage() {
    return "index.html";
  }
}
