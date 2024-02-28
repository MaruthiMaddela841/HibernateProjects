<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report</title>
</head>
<body>
	<center>
		<c:choose>
			<c:when test="${policiesList ne null || !empty policiesList}">
				<table border='1'>
					<tr>
						<th>PolicyId</th>
						<th>PolicyName</th>
						<th>PolicyType</th>
						<th>Company</th>
						<th>Tenure</th>
					</tr>
					<c:forEach var="dto" items="${policiesList}">
						<tr>
							<td>${dto.policyId}</td>
							<td>${dto.policyName}</td>
							<td>${dto.policyType}</td>
							<td>${dto.company}</td>
							<td>${dto.tenure}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>

		<c:if test="${pageNo>1}">
			<b> <a href="./controller?pageNo=${pageNo-1}&s1=link">Previous</a>&nbsp;&nbsp;
			</b>
		</c:if>

		<c:forEach var="i" begin="1" end="${pagesCount}" step="1">
			<b><a href="./controller?pageNo=${i}&s1=link">${i}</a>&nbsp;&nbsp;</b>
		</c:forEach>
		<c:if test="${pageNo<pagesCount}">
			<b> <a href="./controller?pageNo=${pageNo+1}&s1=link">Next</a>&nbsp;&nbsp;
			</b>
		</c:if>
		<a href="./index.jsp">HOME</a>
	</center>
</body>
</html>