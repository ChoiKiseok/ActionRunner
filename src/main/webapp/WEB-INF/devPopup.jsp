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
    <title>통계청 - 공유서비스</title>
    <link
      type="text/css"
      rel="stylesheet"
      media="all"
      href="https://kosis.kr/openapi/ext/style/subCommon.css"
    />
    <link
      type="text/css"
      rel="stylesheet"
      media="all"
      href="https://kosis.kr/openapi/devGuide/devGuide01/css/openTmp.css"
    />
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script
      type="text/javascript"
      language="JavaScript"
      src="https://kosis.kr/openapi/devGuide/devGuide01/js/dojo.js"
    ></script>
    <script
      type="text/javascript"
      language="JavaScript"
      src="https://kosis.kr/openapi/devGuide/devGuide01/js/json.js"
    ></script>
    <script
      type="text/javascript"
      language="JavaScript"
      src="https://kosis.kr/openapi/devGuide/devGuide01/js/ajax.js"
    ></script>
  </head>
  <body>
    <div id="content"></div>
  </body>
  <script type="text/javascript" language="JavaScript">
    var mapData;

    // window onload 되었을때 실행 함수
    dojo.addOnLoad(function () {
      // 통계목록 리스트를 조회하기위해 함수를 호출한다.
      getSubList("MT_ZTITLE", 0, "203_203A_555_55501");
    });

    /****************************************************
     * 통계목록 리스트 조회 함수
     * parameter : vwcd - 서비스뷰 코드 (통계목록구분)
     * listLev - 목록 레벨
     * parentId - 시작목록 Id
     ****************************************************/
    function getSubList(vwcd, listLev, parentId) {
      $.ajax({
        url: "/api",
        data: "listId=" + parentId,
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
      makeNode(Number(listLev) + 1);
    }

    /****************************************************
     * 통계목록 리스트를 화면에 출력하기 위한 함수
     * parameter : listLev - 목록 레벨
     ****************************************************/
    function makeNode(listLev) {
      var nodeInfo = "";

      nodeInfo = nodeInfo + "<ul>";
      for (var cnt = 0; cnt < mapData.length; cnt++) {
        nodeInfo = nodeInfo + "<li>";
        if (mapData[cnt].tblId != '') {
          nodeInfo =
            nodeInfo +
            "<img src='http://kosis.kr/openapi/devGuide/devGuide01/image/stats.gif'> <a target='_balnk' href=\"http://kosis.kr/start.jsp?orgId=" +
            mapData[cnt].orgId +
            "&tblId=" +
            mapData[cnt].tblId +
            "&vw_cd=" +
            mapData[cnt].vwCd +
            "&up_id=" +
            mapData[cnt].UP_ID +
            '">' +
            mapData[cnt].tblNm +
            "</a>";
        } else {
          nodeInfo =
            nodeInfo +
            "<img src='http://kosis.kr/openapi/devGuide/devGuide01/image/folder.gif'> <a href=\"javascript:getSubList('" +
            mapData[cnt].vwCd +
            "', '" +
            listLev +
            "', '" +
            mapData[cnt].listId +
            "');\">" +
            mapData[cnt].listNm +
            "</a>";
        }
        nodeInfo = nodeInfo + "</li>";
      }
      nodeInfo = nodeInfo + "</ul>";

      var r_node = document.getElementById("content"); //
      var v_node = document.getElementById("depth" + listLev);
      
      if (typeof v_node != "undefined" && v_node != null) {
        v_node.innerHTML = nodeInfo;
      } else {
        v_node = document.createElement("div");
        v_node.setAttribute("id", "depth" + listLev);
        v_node.className = "category0" + listLev;
        v_node.style.height = '500px';
        v_node.style.background = 'none';
        v_node.innerHTML = nodeInfo;
        r_node.appendChild(v_node);
      }

      var nodeCount = document.getElementsByTagName("div").length;

      for (var cnt = Number(listLev) + 1; cnt < nodeCount; cnt++) {
        if (document.getElementById("depth" + cnt) != null)
          r_node.removeChild(document.getElementById("depth" + cnt));
      }
    }
  </script>
</html>