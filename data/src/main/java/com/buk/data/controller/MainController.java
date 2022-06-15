package com.buk.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  
  @GetMapping("/test")
  public String testPage() {
    
    return "index.html";
  }
}
