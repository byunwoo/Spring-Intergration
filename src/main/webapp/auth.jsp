<%@page import="org.springframework.security.core.*"%>
<%@page import="org.springframework.security.core.context.*" %>
<%@page import="org.springframework.security.core.userdetails.*" %>
<%@page import="java.util.Collection"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>Spring Security 인증결과</h1>
<li><a href="index.jsp">Index Page</a></li>
<%
	String userName = null;

	SecurityContext context = SecurityContextHolder.getContext();
	Authentication authentication = context.getAuthentication();
	Object principal = authentication.getPrincipal();
	if (principal instanceof UserDetails) {
		UserDetails userDetails = (UserDetails)principal;
		userName = userDetails.getUsername();
	} else {
		userName = (String)principal;
	}
	
	Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	StringBuffer sb = new StringBuffer();
	for (GrantedAuthority authority : authorities) {
		if (sb.length() > 0) sb.append(",");
		sb.append(authority.getAuthority());
	}
	
%>
<h2>hello, <%=userName %></h2>
<h2>authorities : <%=sb.toString() %></h2>

</body>
</html>