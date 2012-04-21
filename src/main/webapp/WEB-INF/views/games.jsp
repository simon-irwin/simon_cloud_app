<%@ page import="ie.cit.cloudapp.Player"%>
<%@ page import="ie.cit.cloudapp.Game"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Red vs Green</title>
<link href="styles/style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
	<div id="header-wrapper">
		<div id="header">
			<div id="logo">
				<h1>Red vs Green </h1>
				<p>The Wednesday Night Football App</a></p>
			</div>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="signup.html">Sign Up</a></li>
			<li><a href="theplayers.html">Players</a></li>
			<li class="current_page_item"><a href="#">Games</a></li>
			<li><a href="playerprofile.html">Player Profile</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
				<div id="content">
				</br><b><a href="j_spring_security_logout">LOGOUT: <security:authentication
						property="principal.username" /></a></b>
					<div class="post">
						<h2 class="title"><a href="#">Games </a></h2>
						<div class="entry">
						<h3>Create Game</h3>
						<form method="post"><table style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3">
							<tr><td><b>Date: </b></td><td><input name="date"></td></tr> 
							<tr><td><b>Venue: </b></td><td><input name="venue"></td></tr>
							<input name="winner" type="hidden" value="N/A">
							</table>
							<input type="submit">									
						</form>	
						</div>
						<div class="entry">
						<h3>Set Winner</h3>
							<table border="1" bordercolor="#999393" style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3"><th>Game Id</th><th>Date</th><th>Venue</th><th>Winner</th><th>Update</th>
							<c:forEach items="${games}" var="game" varStatus="row">
		 					<c:if test="${game.winner eq 'N/A'}">
		 					<form method="post">
		 					<input name="_method" type="hidden" value="put"> <input name="gameId" type="hidden" value="${game.id}"> 
		 					<tr><td> ${game.id} </td><td> ${game.date} </td><td> ${game.venue} </td><td> <input name="winner"></td><td><input type="submit" value="Update"></td></tr> 
							</form>
							</c:if>
							</c:forEach>
							</table>								
						</div>
						<div class="entry">
						<h3>Upcoming Games</h3>
						<table border="1" bordercolor="#999393" style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3"><th>Game No.</th><th>Date</th><th>Venue</th>
						<c:forEach items="${games}" var="game" varStatus="row">
	 					<c:if test="${game.winner eq 'N/A'}">
	 					<tr><td> ${game.id} </td><td> ${game.date} </td><td> ${game.venue} </td></tr>
	 					</c:if>
	 					</c:forEach>
						</table>				
						</div>
						<div class="entry">
						<h3>Historical Games</h3>
						<table border="1" bordercolor="#999393" style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3"><th>Game No.</th><th>Date</th><th>Venue</th><th>Winner</th>
						<c:forEach items="${games}" var="game" varStatus="row">
	 					<c:if test="${game.winner ne 'N/A'}">
	 					<tr><td> ${game.id} </td><td> ${game.date} </td><td> ${game.venue} </td><td>${game.winner}</td></tr>
	 					</c:if>
	 					</c:forEach>
						</table>				
						</div>
					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->
				<div style="clear: both;">&nbsp;</div>

	</div>
	<!-- end #page -->

<div id="footer">
	<p>Copyright (c) 2011 redvsgreen.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org/"> CSS Templates</a>.</p>
</div>
<!-- end #footer -->
</div></body>
</html>