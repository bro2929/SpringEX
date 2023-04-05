<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 페이지</title>
</head>
<body>
관리자용 페이지 입니다.

	<table border="1">
		<tr>
			<th>ID</th><th>이름</th><th>주소</th><th>이메일</th><th>연락처</th>
		</tr>
		<!-- 여기부터 불러온 데이터 -->
		<c:forEach items="${memlist}" var="list">
		<tr>
			<!-- 아이디를 클릭하면 해당 회원의 상세 페이지로 이동 -->
			<td><a href="memberDetail?id=${list.id}">${list.id}</a></td><td>${list.name}</td><td>${list.addr}</td><td>${list.email}</td><td>${list.phone}</td>
		</tr>
		</c:forEach>
	</table>
<a href="board/list">게시판 리스트로 이동</a>
</body>
</html>