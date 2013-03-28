<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!--<meta http-equiv="refresh" content="3;url=http://www.naver.com">-->
<%--response.sendRedirect("http://www.naver.com");--%>
<title>${title }</title>
</head>
<body>
	<ul>
		<li>
			${sampleMessage}
			<table>
				<tr>
					<td>empno</td>
					<td><spring:eval expression="emp.empNo"/></td>
				</tr>
				<tr>
					<td>ename</td>
					<td><spring:eval expression="emp.ename"/></td>
				</tr>
				<tr>
					<td>job</td>
					<td><spring:eval expression="emp.job"/></td>
				</tr>
				<tr>
					<td>mgr</td>
					<td><spring:eval expression="emp.mgr"/></td>
				</tr>
				<tr>
					<td>hiredate</td>
					<td><spring:eval expression="emp.hireDate"/></td>
				</tr>
				<tr>
					<td>sal</td>
					<td><spring:eval expression="emp.sal"/></td>
					<%-- 
						VO 에서 포맷지정으로 아래처럼 지저분해질 필요가 없다
						그냥 EL(${})로 값은 가져올수 있겠으나 한키로 이렇게 포맷을 지정해 가져올수 없다.
						정확히는 spring에서 해주는 컨버젼스 덕택이다,
						<mvc:annotation-driven>는 바로 이 ConversionService를 request 스코프 애트리뷰트에 등록한다.
						SPEL의 강점이 생길수 있는 원인이다.
					
					<td><spring:eval expression="new java.text.DecimalFormat('###,###').format(emp.sal)"/></td> --%>
				</tr>
				<tr>
					<td>comm</td>
					<td><spring:eval expression="emp.comm"/></td>
				</tr>
				<tr>
					<td>deptno</td>
					<td><spring:eval expression="emp.empNo"/></td>
				</tr>
			</table>
		</li>
		<li>
			소속부서정보; JPA에 의한 자동 조인
			<table>
				<tr><td>dname</td><td>${emp.dept.dname}</td></tr>
				<tr><td>loc</td><td>${emp.dept.loc}</td></tr>
			</table>
		</li>
		<li>
			commonStringArr(@ModelAttribute) : 
			<c:forEach items="${commonStringArr}" var="commonStringArr">
				${commonStringArr}
			</c:forEach>
		</li>
		<li>
			<a href="/index.jsp">처음</a>
			<a href="/empList">목록</a>
		</li>
	</ul>
	
</body>
</html>