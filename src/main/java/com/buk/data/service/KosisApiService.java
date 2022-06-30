package com.buk.data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.buk.data.domain.KosisMenuDto;
import com.buk.data.repository.KosisMenuRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KosisApiService {
  @Autowired
  private KosisMenuRepository kosisMenuRepository;
  
  public List<KosisMenuDto> getKosisMenuList(String parentListId) throws Exception {
    List<KosisMenuDto> menuList = new ArrayList<>();

    RestTemplate restTemplate = new RestTemplate();
    String url = new StringBuilder()
                            .append("https://kosis.kr/openapi/statisticsList.do?")
                            .append("method=")
                            .append("getList")
                            .append("&apiKey=")
                            .append("N2VmY2ZiYjFiYzNhMDQ3M2Q1NGI4YTBiZWI5YjI0ZTc=")
                            .append("&vwCd=")
                            //.append("MT_ZTITLE")
                            .append("MT_OTITLE")
                            .append("&parentListId=")
                            .append(parentListId)
                            .append("&format=json")
                            .toString();

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    
    MultiValueMap<String, List<Object>> body = new LinkedMultiValueMap<>();
    
    HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestMessage, String.class);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

    String json = objectMapper.writeValueAsString(response);
    Object obj = objectMapper.readValue(json, Object.class);

    Map<String, String> map = objectMapper.convertValue(obj, Map.class);

    String responseBody = map.get("body").replace("[", "").replace("]", "");
    
    String[] bodys = responseBody.split("},");
    for(int i=0; i<bodys.length; i++) {
      if(i < bodys.length-1)
        bodys[i] = bodys[i] + "}";
      JSONObject jsonObject = new JSONObject(bodys[i]);

      String listId = "";
      String listNm = "";
      String vwCd = "";
      String vwNm = "";
      String orgId = "";
      String recTblSe = "";
      String tblId = "";
      String tblNm = "";

      Iterator keys = jsonObject.keys();
      while(keys.hasNext()){
        String key = keys.next().toString();
        String value = jsonObject.get(key).toString();

        switch(key) {
          case "LIST_ID":
            listId = value;
            break;
          case "LIST_NM":
            listNm = value;
            break;
          case "VW_CD":
            vwCd = value;
            break;
          case "VW_NM":
            vwNm = value;
            break;
          case "ORG_ID":
            orgId = value;
            break;
          case "REC_TBL_SE":
            recTblSe = value;
            break;
          case "TBL_ID":
            tblId = value;
            break;
          case "TBL_NM":
            tblNm = value;
            break;
          default:
            break;
        }
      }

      KosisMenuDto menu = new KosisMenuDto();
      menu.setListId(listId);
      menu.setListNm(listNm);
      menu.setVwCd(vwCd);
      menu.setVwNm(vwNm);
      menu.setOrgId(orgId);
      menu.setRecTblSe(recTblSe);
      menu.setTblId(tblId);
      menu.setTblNm(tblNm);
      menu.setUpId(parentListId);

      menuList.add(menu);
    }

    //kosisMenuRepository.saveAll(menuList);
    return menuList;
  }

  public List<KosisMenuDto> getMenuList() {
    return kosisMenuRepository.findAll();
  }

  public List<Map<String, String>> kosisApi() throws Exception {
    List<Map<String, String>> mapList = new ArrayList<>();
    RestTemplate restTemplate = new RestTemplate();
    String url = new StringBuilder()
                            .append("https://kosis.kr/openapi/statisticsData.do?")
                            .append("method=")
                            .append("getList")
                            .append("&apiKey=")
                            .append("N2VmY2ZiYjFiYzNhMDQ3M2Q1NGI4YTBiZWI5YjI0ZTc=")
                            .append("&jsonVD=")
                            .append("Y")
                            .append("&format=json")
                            .append("&userStatsId=")
                            .append("cks1649/555/DT_55501_B001031/2/1/20220624105443")
                            .append("&prdSe=")
                            .append("Y")
                            .append("&newEstPrdCnt=")
                            .append("1")
                            .toString();
    log.info(url);

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    
    MultiValueMap<String, List<Object>> body = new LinkedMultiValueMap<>();
    
    HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestMessage, String.class);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

    String json = objectMapper.writeValueAsString(response);
    Object obj = objectMapper.readValue(json, Object.class);

    Map<String, String> map = objectMapper.convertValue(obj, Map.class);
    
    String responseBody = map.get("body").replace("[", "").replace("]", "");
    String[] bodys = responseBody.split("},");

    for(int i=0; i<bodys.length; i++) {
      if(i < bodys.length-1)
        bodys[i] = bodys[i] + "}";
      JSONObject jsonObject = new JSONObject(bodys[i]);
      
      Iterator keys = jsonObject.keys();
      Map<String, String> jsonMap = new HashMap<>();
      while(keys.hasNext()){
        String key = keys.next().toString();
        String value = jsonObject.get(key).toString();

        jsonMap.put(key, value);
      }
      mapList.add(jsonMap);
    }
    log.info("{}", mapList);

    return mapList;
  }
}
