package com.buk.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buk.data.service.KosisApiService;

@RestController
public class MainRestController {
  @Autowired
  private KosisApiService kosisApiService;

  @GetMapping("/api")
  public void getKosisMenuList() throws Exception {
    kosisApiService.getKosisMenuList();
  }
}
