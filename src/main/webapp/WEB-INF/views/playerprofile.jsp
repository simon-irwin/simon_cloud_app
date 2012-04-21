<%@ page import="ie.cit.cloudapp.Player"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
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
				<li><a href="signup.html">Sign Up</a></li>
				<li><a href="theplayers.html">Players</a></li>
				<li><a href="games.html">Games</a></li>
				<li class="current_page_item"><a href="playerprofile.html">Player Profile</a></li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="page">
					<div id="content">
						</br><b><a href="j_spring_security_logout">LOGOUT: <security:authentication
						property="principal.username" /></a></b>
						<div class="post">
							<h2 class="title">
								<a href="#">Player Profile </a>
							</h2>
							<div class="entry">
								<h3>Your Profile</h3>
								<p>Use the form below to update your profile.</p>
								<form method="post"><table style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3">
									<input name="_method" type="hidden" value="put"> <input name="playerId" type="hidden" value="${player.id}"> 
									<tr><td><b>Username: </b></td><td>${player.username}</td></tr> 
									<tr><td><b>First Name: </b></td><td><input name="firstName" value="${player.firstName}"></td></tr> 
									<tr><td><b>Surname: </b></td><td><input name="surname" value="${player.surname}"></td></tr>
									<tr><td><b>Club: </b></td><td><input name="club" value="${player.club}"></td></tr>
									</table>
									<input type="submit" value="Update">									
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