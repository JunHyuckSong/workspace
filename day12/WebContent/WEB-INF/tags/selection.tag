<%@ tag language="java" pageEncoding="UTF-8"%>
<!-- 속성을 만들어줄 수 있다 -->
<%@ attribute name="border"%>
<%@ attribute name="bgcolor"%>

<jsp:useBean id="sel" class="day12.Selection"/>

<h1><jsp:doBody/></h1> <!-- 해당 태그(mytag)바디에 있는 바디내용을 받아올 수 있다 -->

<table border="${border}" bgcolor="${bgcolor }">
	<%
		for(String v:sel.getNameList()){
			out.println("<tr><td>"+v+"</td></tr>");	
		}
	%>
</table>