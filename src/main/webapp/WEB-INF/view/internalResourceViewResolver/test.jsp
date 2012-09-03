<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!--<meta http-equiv="refresh" content="3;url=http://www.naver.com">-->
<%--response.sendRedirect("http://www.naver.com");--%>
<%%>
<title></title>
</head>
<body>
	<ul>
		<li>
			${sampleMessage}
		</li>
		<li>
			서버로부터 util빈으로 등록한 propertie 에서 직접 읽어온 값 : ${propValue}
		</li>
		<li>
			클라이언트로부터 util빈으로 등록한 propertie 에서 직접 읽어온 값 : <spring:eval expression="@dbProp['jdbc.driver']" />
		</li>
		<li>
			<a href="/index.jsp">처음</a>
		</li>
		<li><br><br></li>
		<li>
			현재 접속한 장비는 모바일 기기가 
			<spring:eval expression="isMobile==true?'맞습니다.':'아닙니다.'" />
			<br>
			spring mobile을 이용해 판단합니다.
		</li>
	</ul>
</body>
</html>