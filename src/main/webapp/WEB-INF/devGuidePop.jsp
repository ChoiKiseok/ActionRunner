<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:set var="method">
  <%out.println(request.getParameter("method") == null ? "" : (request.getParameter("method"))); %>
</c:set>
<c:set var="key">
  <%out.println(request.getParameter("key") == null ? "" : (request.getParameter("key"))); %>
</c:set>
<c:set var="vwcd">
  <%out.println(request.getParameter("vwcd") == null ? "" : (request.getParameter("vwcd"))); %>
</c:set>
<c:set var="parentId">
  <%out.println(request.getParameter("parentId") == null ? "" : (request.getParameter("parentId")));%>
</c:set>
<c:set var="type">
  <%out.println(request.getParameter("type") == null ? "" : (request.getParameter("type"))); %>
</c:set>

<c:import
  url="http://kosis.kr/openapi/Expt/statisticsList.do?method=getList&key=ZjZjOTI3MjRjNmU1YzdhZTMwOWRjNjgxN2MzNDgwNmY=&vwcd=MT_ZTITLE&parentListId=${parentId}&format=json"
  charEncoding="utf-8"
/>