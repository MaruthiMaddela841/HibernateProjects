<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
</head>
<body>
	<h1 style='color: green; text-align: center'>Welcome to Page</h1>

	<form action='./controller' method='GET'>
		<table align='center' border='1' bgcolor='cyan '>
			<tr>
				<td>Enter Input Page</td>
				<td><input type='text' name='pageSize' /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type='submit' value='generateReport' name='s1'/></td>
			</tr>
		</table>
	</form>
</body>
</html>