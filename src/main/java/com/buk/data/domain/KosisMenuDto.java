package com.buk.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "tb_kosis_menu")
public class KosisMenuDto {
  @Id
  private String listId;      //목록ID
  private String listNm;      //목록명
  private String vwCd;        //서비스뷰
  private String vwNm;        //목록구분
  private String orgId;       //기관코드
  private String tblId;       //통계표ID
  private String tblNm;       //통계표명
  private String recTblSe;    //추천통계표여부
}