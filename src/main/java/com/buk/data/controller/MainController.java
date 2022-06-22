package com.buk.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
  
  @GetMapping("/test")
  public String testPage() {
    log.debug("======= Test Page =====");
    return "index.html";
  }

  @GetMapping("/popup")
  public String kosisPopup() {
    return "devPopup";
  }

  @PostMapping("/guide")
  public String kosisGuide(Model model, @RequestParam("parentId") String parentId) {
    model.addAttribute("parentId", parentId);
    return "devGuidePopup";
  }
}
