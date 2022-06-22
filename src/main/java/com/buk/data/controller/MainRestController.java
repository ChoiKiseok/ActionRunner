package com.buk.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buk.data.domain.KosisMenuDto;
import com.buk.data.service.KosisApiService;

@RestController
public class MainRestController {
  @Autowired
  private KosisApiService kosisApiService;

  @GetMapping("/api")
  public List<KosisMenuDto> getKosisMenuList(@RequestParam("listId") String listId) throws Exception {
    return kosisApiService.getKosisMenuList(listId);
  }

  @PostMapping("/api")
  public List<KosisMenuDto> getMenuList(String listId) {
    List<KosisMenuDto> menuList = kosisApiService.getMenuList(listId);
    return menuList;
  }
}
