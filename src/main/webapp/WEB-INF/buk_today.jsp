<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  <title>북구통계 > 그림으로 보는 북구</title>
</head>
<body>
  <div id="content"></div>
</body>
<script>
  var mapData;
  window.onload = () => {
    $.ajax({
        url: "/api/today",
        type: "post",
        //dataType: "json",
        async: false,
        success: function(result) {
          console.log(result);
          mapData = result;
          showMapData();
        },
        error: function(err) {
          console.log(err);
        }
      })
  }

  function showMapData() {
    mapData.forEach(element => {
      console.log(element.C1_NM)
      console.log(element.DT);
    });
  }
</script>
</html>