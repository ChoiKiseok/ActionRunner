<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:set var="method">
  <%out.println(request.getParameter("method") == null ? "" :
  (request.getParameter("method"))); %>
</c:set>
<c:set var="key">
  <%out.println(request.getParameter("key") == null ? "" :
  (request.getParameter("key"))); %>
</c:set>
<c:set var="vwcd">
  <%out.println(request.getParameter("vwcd") == null ? "" :
  (request.getParameter("vwcd"))); %>
</c:set>
<c:set var="parentId">
  <%out.println(request.getParameter("parentId") == null ? "" :
  (request.getParameter("parentId")));%>
</c:set>
<c:set var="type">
  <%out.println(request.getParameter("type") == null ? "" :
  (request.getParameter("type"))); %>
</c:set>

<c:import
  url="https://kosis.kr/openapi/statisticsList.do?method=getList&apiKey=N2VmY2ZiYjFiYzNhMDQ3M2Q1NGI4YTBiZWI5YjI0ZTc=&vwCd=MT_ZTITLE&parentListId=A&format=json"
  charEncoding="utf-8"
  var="content"
/>