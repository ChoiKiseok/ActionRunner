package com.buk.data.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.buk.data.domain.KosisMenuDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KosisApiService {
  
  public void getKosisMenuList() throws Exception {
    // KosisMenuDto menu = new KosisMenuDto();
    List<KosisMenuDto> menuList = new ArrayList<>();

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://kosis.kr/openapi/statisticsList.do?method=getList&apiKey=N2VmY2ZiYjFiYzNhMDQ3M2Q1NGI4YTBiZWI5YjI0ZTc=&vwCd=MT_ZTITLE&parentListId=V&format=json";

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    MultiValueMap<String, List<Object>> body = new LinkedMultiValueMap<>();

    HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);
    HttpEntity<String> response = restTemplate.postForEntity(url, requestMessage, String.class);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
    
    System.out.println(response.getBody());
    List<String> list = Arrays.asList(response.getBody());

    System.out.println(list);
    // int responseLength = response.getBody().length();
    // List<Object> obj = response.getBody();

    // for(int i=0; i<responseLength; i++) {
    //   KosisMenuDto menu = new KosisMenuDto();
    //   menu = objectMapper.readValue(response.getBody(), KosisMenuDto.class);
    //   menuList.add(menu);
    // }

    // menuList = objectMapper.readValue(response.getBody(), List<KosisMenuDto>);
    System.out.println(menuList.toString());

    //return menuList;
  }
}
