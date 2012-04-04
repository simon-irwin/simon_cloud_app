<%@ page import="ie.cit.cloudapp.Player"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Red vs Green</title>
<link href="styles/style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="header-wrapper">
			<div id="header">
				<div id="logo">
					<h1>Red vs Green</h1>
					<p>
						The Wednesday Night Football App</a>
					</p>
				</div>
			</div>
		</div>
		<!-- end #header -->
		<div id="menu">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li class="current_page_item"><a href="#">Sign Up</a></li>
				<li><a href="admin.html">Admin</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="page">
					<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">Sign Up </a>
							</h2>
							<div class="entry">
								<h3>List of Players</h3>
								<table border="1" bordercolor="#999393" style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3"><th>First Name</th><th>Surname</th><th>Club</th><th>Team Colour</th>
								<c:forEach items="${players}" var="player" varStatus="row">
			 					<tr><td> ${player.firstName} </td><td> ${player.surname} </td><td> ${player.club} </td><td> ${player.teamColour} </td></tr> 
								</c:forEach>
								</table>
								<br />
								<h3>Sign Up Form</h3>
								<form method="post"><table style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3">
									<tr><td><b>Username: </b></td><td><input name="username"></td></tr> 
									<tr><td><b>Password: </b></td><td><input name="password"></td></tr>
									<tr><td><b>First Name: </b></td><td><input name="firstName"></td></tr> 
									<tr><td><b>Surname: </b></td><td><input name="surname"></td></tr>
									<tr><td><b>Club: </b></td><td><input name="club"></td></tr>
									<tr><td><b>Team: </b></td><td>Red<input type="radio" name="teamcolour" value="Red"> Green <input type="radio" name="teamcolour" value="Green"></td></tr>
									</table>
									<input type="submit">
									
								</form>
							</div>
						</div>
						<div style="clear: both;">&nbsp;</div>
					</div>
					<!-- end #content -->
					<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #page -->

		<div id="footer">
			<p>
				Copyright (c) 2011 redvsgreen.com. All rights reserved. Design by <a
					href="http://www.freecsstemplates.org/"> CSS Templates</a>.
			</p>
		</div>
		<!-- end #footer -->
	</div>
</body>
</html>