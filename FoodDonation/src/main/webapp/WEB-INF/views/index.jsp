<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="../include/css/main.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<!-- Menu Code -->
	<nav class="navbar navbar-expand-lg navbar-light nav-bg"> <a
		class="navbar-brand text-white" href="/">FOOD FOR ORPHANS</a>
	<div class="collapse navbar-collapse" id="navbarNavDropdown"></div>
	<ul class="navbar-nav" id="menulist">
		<li class="nav-item active"><a class="nav-link" href="/">Home
				<span class="sr-only">(current)</span>
		</a></li>
		<c:choose>
			<c:when test="${empty role}">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="true"> Login </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="/volunteerLogin"
							style="color: black; font-size: 13px;">Volunteer</a> <a
							class="dropdown-item" href="/donatorLogin"
							style="color: black; font-size: 13px;">Donator</a> <a
							class="dropdown-item" href="/adminLogin"
							style="color: black; font-size: 13px;">Admin</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="true"> Register </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="/volunteerRegistration"
							style="color: black; font-size: 13px;">Volunteer</a> <a
							class="dropdown-item" href="/donatorRegistration"
							style="color: black; font-size: 13px;">Donator</a>

					</div></li>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${role == 'Admin'}">
				<li class="nav-item"><a class="nav-link" href="/dashboard">Dashboard
						<span class="sr-only"></span>
				</a></li>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${role == 'Donator'}">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="true"> Options </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="/donationsByMe"
							style="color: black; font-size: 13px;">My Donations</a> <a
							class="dropdown-item" href="/donationForm"
							style="color: black; font-size: 13px;">Donate</a>

					</div></li>
				<li class="nav-item"><a class="nav-link" href="/logout">Logout
						<span class="sr-only"></span>
				</a></li>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${role == 'Volunteer'}">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="true"> Options </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="/MyRequestsToDeliver"
							style="color: black; font-size: 13px;">My Requests</a> <a
							class="dropdown-item" href="/pendingReq"
							style="color: black; font-size: 13px;">Pending Requests</a>

					</div></li>
				<li class="nav-item"><a class="nav-link" href="/logout">Logout
						<span class="sr-only"></span>
				</a></li>
			</c:when>
		</c:choose>
	</ul>
	</nav>

	<!-- Home Image  -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-12 p-0" id="homerow">
				<div id="hover-text-div">
					<div id="hover-text">
						<h1 class="text-white">
							GIVING HOPE ONE MEAL AT A <br /> TIME
						</h1>
					</div>
					<div id="scroll-down-button">
						<span><i onclick="scrollDownClicked()"
							onmouseover="scrollDownEnter()" onmouseout="scrollDownExit()"
							class="fa fa-angle-double-down text-white"
							style="font-size: 36px"></i></span><br> <span class="text-white"
							id="scroll-down-button-text"><b>Scroll Down</b></span>
					</div>
				</div>
				<img src="../res/images/home-img.jpg"
					class="img-fluid home-image-section2">

			</div>
		</div>
	</div>
	<div class="container-fluid" id="section2">
		<div class="row py-3">
			<div class="col-4 pt-4 offset-2">
				<img class="img-fluid" src="../res/images/home-img2.jpg">
			</div>
			<div class="col-4 pt-4">
				<span><b>ONE MEAL AT A TIME</b></span><br /> <br /> <span
					id="section2-desc">That's where we start. <br /> <br />
					When all you know is hunger it becomes all you know of life. It
					hollows out your body, weakening your immune system and leading to
					disease.<br /> <br /> Most of us are fortunate—we don’t know what
					it’s like to be that hungry.<br /> <br /> But millions of people
					do. Malnourished mothers give birth to underweight babies leading
					to a high mortality rate. The children who survive face their own
					battle due to a lack of food.<br /> <br /> <b><i>"Poverty
							is a complex issue, but feeding a child isn't" - Jeff Bridges</i></b><br />
					<br /> We want to make a difference .. even if it’s only one meal
					at a time.<b>But we need your help.</b><br /> <br /> <b>Simply
						Choose to Donate Below and also consider joining our mailing list
						using the form below. </b>
				</span><br> <a href="/donationForm" class="donate-button text-white">Donate</a>
			</div>
		</div>
	</div>
	<div class="container-fluid" id="section3">
		<div class="row py-5">
			<div class="col-3 pt-4 offset-2">
				<img class="img-fluid" src="../res/images/giving-hope.jpg"> <br />
				<br>
				<h5>GIVING HOPE</h5>
				<span>We bring hope in the midst of despair, offering
					children the chance for a better life and a brighter tomorrow.</span>
			</div>
			<div class="col-3 pt-4">
				<img class="img-fluid" src="../res/images/giving-life.jpg"> <br />
				<br>
				<h5>GIVING LIFE</h5>
				<span>Solving the crisis of hunger one meal at a time gives
					people an opportunity for a new life and a new future for them and
					their children.</span>
			</div>
			<div class="col-3 pt-4">
				<img class="img-fluid" src="../res/images/giving-courage.jpg">
				<br /> <br>
				<h5>GIVING COURAGE</h5>
				<span>We serve where the need is greatest, hoping to inspire
					courage in those facing a life of turmoil and struggle. </span>
			</div>
		</div>
	</div>



















	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="../include/js/script.js"></script>
</body>
</html>
<c:choose>
<c:when test="${not empty error}">
   <html>
      <body>
      	<script type="text/javascript">
      	   alert("${error }");
      	</script>
      </body>
   </html>
</c:when>
</c:choose>