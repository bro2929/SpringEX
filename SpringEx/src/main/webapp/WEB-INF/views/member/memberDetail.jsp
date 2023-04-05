<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보 페이지</title>
</head>
<body>

${memDetail.id}회원의 정보입니다.

<form method="post">
<table border="1">
	<tr>
		<th>아이디</th><th>비밀번호</th><th>이름</th><th>주소</th><th>이메일</th><th>연락처</th>
	</tr>
	<tr>
		<!-- 이때 memDetail은 Model 객체 변수(select한 데이터가 저장된)를 말함(메소드X) -->
		<td><input type="hidden" value="${memDetail.id}" name="id">${memDetail.id}</td> <!-- DB에 보낼용/사용자에게 보여줄용 -->
		<td><input type="password" value="${memDetail.password}" name="password"></td>		  <!-- td에는 name 속성이 없기 때문에 input 필요 -->
		<td><input type="text" value="${memDetail.name}" name="name"></td>
		<td><input type="text" value="${memDetail.addr}" name="addr"></td>
		<td><input type="text" value="${memDetail.email}" name="email"></td>
		<td><input type="text" value="${memDetail.phone}" name="phone"></td>
	</tr>
	<tr>
		<td colspan="6">
			<input type="submit" value="수정" formaction="modify">
			<input type="submit" value="삭제" formaction="remove">
		</td>
	</tr>
</table>
</form>

</body>
</html>