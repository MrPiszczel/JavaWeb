<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ContentQuestion">
		Nazwa pytania<br></br> 
		<input type="text" name="subject"><br></br>
		<p>odpowiedz 1</p>
		<input type="text" name="answer1">
		<p>Odpowiedz 2</p>
		<input type="text" name="answer2">
		<p>Odpowiedz 3</p>
		<input type="text" name="answer3">
		<p>Odpowiedz 4</p>
		<input type="text" name="answer4">
		<p>Poprawna odpowiedz a , b , c , d</p>
		<input type="text" name="trueAnswer"><br></br> 
		<input type="submit" value="Zatwierdz">
	</form>
</body>
</html>