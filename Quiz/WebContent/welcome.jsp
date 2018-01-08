<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome ${username}


	<form action="AddSubject">
		<input type="submit" value="Dodaj temat">
	</form>

	<form action="Logout">

		<a href="videos.jsp">Videos here</a> <input type="submit"
			value="Logout">

	</form>

	<form action="typeQuestion">
		<input type="submit" value="Pokaż pytania"> <br />

		<c:forEach items="${list}" var="List">

			<a href="answerOnQuestion.jsp"><input type="text" name="question"${List.question}
				value="Pytanie: ${List.question}"></a>

			<br />

		</c:forEach>
	</form>

</body>
</html>