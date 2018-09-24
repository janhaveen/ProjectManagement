<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="fixed-sn white-skin">
<%@ include file="../../Header.jsp" %>
<main>
	<section>
		<input type="hidden" id="ProjectId" name="ProjectId" value="<%=request.getParameter("id") %>">
		<input type="hidden" id="t" name="t" value="<%=request.getParameter("t") %>">
   		<%@include file="ProjectLegendList.jsp" %>
   		<%@include file="NewProjectLegend.jsp" %>
   		<%@include file="DeleteModal.jsp" %>
   </section>
</main>
</body>
<script type="text/javascript" src="../../ProjectLegend/JavaScripts/ProjectLegendList.js"></script>
<script type="text/javascript" src="../../ProjectLegend/JavaScripts/ProjectLegend.js"></script>
</html>