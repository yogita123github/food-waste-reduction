<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

  <title>Volunteer Registration</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link rel="stylesheet" href="include/css/main.css">

  <style>
    body{
      overflow-y:hidden;
    }
    #hover-text-div{
      background-color: rgba(0, 0, 0, 0.7);
    }

    #loginForm{
      position: absolute;
      top:0;
      margin-top:2%;
      margin-left:26%;
      color:white;
      
      padding:5%;
      width:45%;
      background-color:rgb(72, 67, 73,0.8);
    }

    #loginForm form{
      margin-top:10%;
    }

    #loginForm h3{
      margin-left:24%;
    }

  </style>

</head>
<body>
    <c:choose>
   	   <c:when test="${status == 'Success'}">
   	   		<script type="text/javascript">
   	   			alert("Registered Successfully !!");
   	   		</script>
   	   </c:when>
   	   <c:when test="${status == 'Fail'}">
   	   		<script type="text/javascript">
   	   			alert("Registration Failed Due to Invalid Data ");
   	   		</script>
   	   </c:when>
   </c:choose>
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

        <div class="container-fluid">
          <div class="row">
              <div class="col-12 p-0" id="homerow">
                  <div id="hover-text-div"></div>
                  <img src="./res/images/home-img.jpg" class="img-fluid home-image-section2">
                  <div class="container-fluid" id="loginForm">
                
                    <h3 class="text-center">Volunteer Registration</h3>
                      <form:form action="/volunteerRegistration" modelAttribute="volunteer" method="POST"> 
                        <div class="row">
                        <div class="col-6">
                          <div class="form-group">
                            <label for="exampleInputEmail1">Username</label>
                            <form:input path="d_uname" type="text" class="form-control" placeholder="Enter Username" />
                          </div>
                         
                          <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <form:input path="d_email" type="email" class="form-control" placeholder="Enter email" />
                          </div>
                      </div>
                      <div class="col-6">	
                        <div class="form-group">
                          <label for="exampleInputPassword1">Contact Number</label>
                          <form:input type="text" path="contact"  class="form-control"  placeholder="Enter Whatsapp Number" />
                        </div>
                        <div class="form-group">
                          <label for="exampleInputEmail1">Password</label>
                          <form:input path="d_pass" type="password" class="form-control"  placeholder="Enter Password" />
                        </div>
                     
                        
                      </div>
                      <button type="submit" class="btn btn-primary btn-block mt-2" >Register</button>
                     </div> 	
                      </form:form>
                 
                  </div>
                </div>
              </div>
          </div>


    


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
​<c:choose>
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
