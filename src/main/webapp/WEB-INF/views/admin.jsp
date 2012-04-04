<%@ page import="ie.cit.cloudapp.Player"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<li class="current_page_item"><a href="#">Admin</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
				<div id="content">
					<div class="post">
						<h2 class="title"><a href="#">Administrator </a></h2>
						<div class="entry">
						<h3>Edit Players</h3>
						<table border="1" bordercolor="#999393" style="background-color:#FFFFFF" width="400" cellpadding="3" cellspacing="3"><th>First Name</th><th>Surname</th><th>Club</th><th>Team Colour</th><th>Swap Sides</th><th>Delete</th>
						<c:forEach items="${players}" var="player" varStatus="row">
	 					<tr><td> ${player.firstName} </td><td> ${player.surname} </td><td> ${player.club} </td><td> ${player.teamColour} </td>
	 					<td><form method="post"> <input name="_method" type="hidden" value="put"> <input name="playerId" type="hidden" value="${player.id}"> <input type="submit" value="Swap Team"></form></td>
	 					<td><form method="post"> <input name="_method" type="hidden" value="delete"> <input name="playerId" type="hidden" value="${player.id}"> <input type="submit" value="Delete"></form></td></tr> 
						</c:forEach>
						</table>							
						
						</div>
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