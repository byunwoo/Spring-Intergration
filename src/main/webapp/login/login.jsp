<html>
<head>
<title>Login</title>
</head>
 
<body>
	<div align="center">
		<h2>Spring Security 로긴</h2>
		<font color="red">
			${SPRING_SECURITY_LAST_EXCEPTION}
			<br/>
			<br/>
			${SPRING_SECURITY_LAST_EXCEPTION.authentication}
			<%-- <br/>
			${SPRING_SECURITY_LAST_EXCEPTION.authentication.authenticated}
			<br/>
			${SPRING_SECURITY_LAST_EXCEPTION.authentication.details} --%>
		</font>
		<form action="/j_spring_security_check" method="post">
			<table>
				<tr><td>User:</td><td><input type='text' name='j_username'></td></tr>
				<tr><td>Password:</td><td><input type='password' name='j_password'></td></tr>
				<tr><td colspan='2' align="center"><input name="submit" type="submit" value="로그인">
					         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             <input name="reset" type="reset" value="취소"></td></tr>
			</table>
		</form>
		
	</div>
</body>
</html>