<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!--<meta http-equiv="refresh" content="3;url=http://www.naver.com">-->
<%--response.sendRedirect("http://www.naver.com");--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<title>${title }</title>
</head>
<body>

	<ul>
		<li>
			${sampleMessage}
		</li>
		<li>
			${empList}
		</li>
		<li>
			<a href="/index.jsp">처음</a>
		</li>
	</ul>

	<table>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
		</tr>
		<c:forEach items="${empList}" var="emp">
		<tr>
			<td>${emp.empNo }</td>
			<td><a href="/getEmp/${emp.empNo }">${emp.ename }</a></td>
			<td>${emp.job }</td>
		</tr>
		</c:forEach>
		<tr>
			commonStringArr(@ModelAttribute) : 
			<c:forEach items="${commonStringArr}" var="commonStringArr">
				${commonStringArr}
			</c:forEach>
		</tr>
	</table>
	
</body>
</html>