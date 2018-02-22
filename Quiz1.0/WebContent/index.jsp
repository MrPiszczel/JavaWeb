<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona glowna</title>

<style>
.status {
	height: 4vh;
	width: 0%;
	background-color: cornflowerblue;
	transition: .6s linear;
	position: fixed;
	top: 0;
	left: 0;
}

body {
	margin: 0; height : 500vh;
	background-image: linear-gradient(45deg, red 0%, blue 100%);
	height: 500vh;
}
</style>
</head>

<body>


	<div class="status">
		<form action="Index" method="post">
			Enter username: <input type="text" name="uname"><br>
			Enter password: <input type="password" name="pass"> <input
				type="submit" value="login"> <br></br> <select
				name="country">
				<option>Polska</option>
				<option>Chiny</option>
				<option>Hiszpania</option>
			</select>
		</form>



		<form action="Registration">
			<input type="submit" value="registration">
		</form>
	</div>


</body>
</html>