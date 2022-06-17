package com.buk.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "tb_kosis_menu")
public class KosisMenuDto {
  @Id
  private String LIST_ID;     //목록ID
  private String LIST_NM;     //목록명
  private String VW_CD;       //서비스뷰
  private String VW_NM;       //목록구분
  private String ORG_ID;      //통계표ID
  private String REC_TBL_SE;  //추천통계표여부
}


// "LIST_NM":"인구총조사","VW_CD":"MT_ZTITLE","VW_NM":"국내통계 주제별","LIST_ID":"A_4"
// "LIST_NM":"총조사인구(2015년 이후)","VW_CD":"MT_ZTITLE","VW_NM":"국내통계 주제별","LIST_ID":"A11_2015_1"
// "LIST_NM":"전수부문 (등록센서스, 2015년 이후)","VW_CD":"MT_ZTITLE","VW_NM":"국내통계 주제별","LIST_ID":"A11_2015_1_10"
// "LIST_NM":"전수기본표","VW_CD":"MT_ZTITLE","VW_NM":"국내통계 주제별","LIST_ID":"A11_2015_1_10_10"
// "TBL_NM":"성, 연령 및 가구주와의 관계별 인구 - 시군구","TBL_ID":"DT_1IN1507","VW_CD":"MT_ZTITLE","VW_NM":"국내통계 주제별","ORG_ID":"101","REC_TBL_SE":"N"