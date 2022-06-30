package com.buk.data.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buk.data.domain.KosisMenuDto;
import com.buk.data.service.KosisApiService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainRestController {
  @Autowired
  private KosisApiService kosisApiService;

  @GetMapping("/api")
  public List<KosisMenuDto> getKosisMenuList(@RequestParam("listId") String listId) throws Exception {
    return kosisApiService.getKosisMenuList(listId);
  }

  @PostMapping("/api")
  public List<KosisMenuDto> getMenuList() {
    List<KosisMenuDto> menuList = kosisApiService.getMenuList();
    return menuList;
  }

  @PostMapping("/api/today")
  public List<Map<String, String>> getApiList() throws Exception {
    return kosisApiService.kosisApi();
  }
}
