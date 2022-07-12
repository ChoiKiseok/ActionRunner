<!--
  KOSIS OpenAPI를 이용하여 통계목록을 생성하는 예제입니다.
  이 소스는 KOSIS API를 사용하는데 참고가 되도록 제공하는 것으로
  사용자의 운영환경에 따라 수정작업이 필요합니다

  * 유의사항 : Ajax를 활용하여 개발을 진행하실 때에는 CrossDomain으로 인한
     통신문제가 발생 할 수 있습니다.
     JSON 방식으로 제공받으실 때에는 개발홈페이지에 임의의 jsp를 생성하여
     호출함으로써 CrossDomain에 대한 제약을 우회하실 수 있는 개발소스를 제공합니다.
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=utf-8" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
  <head>
    <style> 
      .category01 {background: none !important;}
      .category01 > ul {height: 100% !important; border: 1px solid black; padding: 10px !important;}
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>북구통계 > 주제별통계</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/dtree.css">
    <script src="/js/dtree.js"></script>
    
  </head>
  <body>
    <div id="content"></div>
  </body>
  <script type="text/javascript" language="JavaScript">
    var mapData;

    // window onload 되었을때 실행 함수
    window.onload = function() {
      getSubList("203_203A_555_55501");
    }

    /****************************************************
     * 통계목록 리스트 조회 함수
     ****************************************************/
    function getSubList(parentListId) {
      $.ajax({
        url: "/api?listId=" + parentListId,
        type: "get",
        dataType: "json",
        async: false,
        success: function(result) {
          mapData = result;
        },
        error: function(err) {
          console.log(err);
        }
      })
      // 통계목록 리스트를 화면에 출력하기 위한 함수
      makeNode();
    }

    /*dTree 정의 및 root 트리 생성
    * dTree.add(p1, p2, p3, p4, p5, p6, p7)
    * p1 : id값
    * p2 : 부모참조 id값. 여기에 적힌 id가 부모노드가 된다
    * p3 : 표시될 노드의 이름
    * p4 : 해당 노드를 클릭했을때 이동될 페이지 주소
    * p5 : 해당노드의 이름에 마우스를 가져다 대면 뜨는 설명
    * p6 : a태그의 target에 해당하는값. 보통 새창에서 열리게 할때 쓰임
    * p7 : 이미지경로및 이름. 여기에 적힌 이미지가 표시된다. 안적을경우엔 기본값으로 표시
    */
    var d = new dTree('d');
    d.add("203_203A_555_55501", -1, '주제별통계');
    function makeNode() {
      
      for (var cnt = 0; cnt < mapData.length; cnt++) {
        var nodeInfo = "";  //통계청 홈페이지로 이동하는 URL
        var nodeNm = '';    //노드 이름
        var id = '';        //노드ID
        var img = '';       //이미지 경로
        var type = '';      //새 창 열기

        if (mapData[cnt].tblId != '') {
          nodeInfo =
            "http://kosis.kr/start.jsp?orgId=" +
            mapData[cnt].orgId +
            "&tblId=" +
            mapData[cnt].tblId +
            "&vw_cd=" +
            mapData[cnt].vwCd +
            "&up_id=" +
            mapData[cnt].upId;
          nodeNm = mapData[cnt].tblNm;
          id = mapData[cnt].tblId;
          img = '/img/dtree/page.gif';
          type = '_blank';
        } else {
          nodeInfo = "javascript:getSubList('"+ mapData[cnt].listId +"');"
          nodeNm = mapData[cnt].listNm;
          id = mapData[cnt].listId;
          img = '/img/dtree/folder.gif';

        }
        d.add(id, mapData[cnt].upId, nodeNm, nodeInfo, '', type, img);
      }
      document.getElementById('content').innerHTML = d;
      d.closeAll();
    }
  </script>
</html>