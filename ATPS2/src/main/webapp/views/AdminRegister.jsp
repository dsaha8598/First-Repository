<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./views/css/bootstrap.min.css" />
<link rel="stylesheet" href="./views/css/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="vendor/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>


 <script>
 $('.datepicker').pickadate();
	</script>
<!--------------------------------------------- CSS CODE --------------------------------------------------------------->
<style>
body{
		background-color: #25274d;
	}
	.contact{
		padding: 4%;
		height: 400px;
	}
	.col-md-3{
		background: #ff9b00;
		padding: 4%;
		border-top-left-radius: 0.5rem;
		border-bottom-left-radius: 0.5rem;
	}
	.contact-info{
		margin-top:10%;
	}
	.contact-info img{
		margin-bottom: 15%;
	}
	.contact-info h2{
		margin-bottom: 10%;
	}
	.col-md-9{
		background: #fff;
		padding: 3%;
		border-top-right-radius: 0.5rem;
		border-bottom-right-radius: 0.5rem;
	}
	.contact-form label{
		font-weight:600;
	}
	.contact-form button{
		background: #25274d;
		color: #fff;
		font-weight: 600;
		width: 25%;
	}
	.contact-form button:focus{
		box-shadow:none;
	}
</style>
 
  
	
<!-- ---------------------------------------header part division ----------------------------------------------------->
		<div style="border:1px solid pink;padding:3px;font-size:20px;height:130px">  
		<table  style="border:0px;height:130px;width:1325px">
			<tr style="width:100px">
				<td width="20%"><img src="images/logo.jpg" style="width:300px;height:120px;"/></td>
				<td width="70%"><h1 style="color:maroon;font-size:50px">Welcome To Home Page</h1></td>
			</tr>
		</table>
	</div> 
<!---------------------------------------------- Body SECTION ------------------------------------------------------->
	

<!------ Include the above in your HEAD tag ---------->

<div class="container contact">
	<div class="row">
		<div class="col-md-3">
			<div class="contact-info">
				<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
				<h2>Contact Us</h2>
				<h4>We would love to hear from you !</h4>
			</div>
		</div>
		<div class="col-md-9">
			<div class="contact-form">
			<form:form action="d" modelAttribute="domain" method="POST">
				<div class="form-group">
				  <label class="control-label col-sm-2" for="fname">First Name:</label>
				  <div class="col-sm-10">          
					<div><form:input path="firstName" class="form-control" type="text"  placeholder="Enter Last Name"/></div>
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="lname">Last Name:</label>
				  <div class="col-sm-10">          
					<form:input path="lastName" class="form-control" type="text"  placeholder="Enter Last Name"/>
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="email">Enter Email</label>
				  <div class="col-sm-10">
					<form:input path="lastName" class="form-control" type="text"  placeholder="Enter Email"/>
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="comment">Enter Phone Number</label>
				  <div class="col-sm-10">
					<form:input path="phNo" class="form-control" type="text" placeholder="Enter Email"/>
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="comment">Enter Date of Birth</label>
				  <div class="col-sm-10">
					 <input placeholder="Selected date" type="text" id="date-picker-example" class="form-control datepicker">
				  </div>
				</div>
				<div class="form-group">        
				  <div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				  </div>
				</div>
				</form:form>
			</div>
			
		</div>
	</div>
</div>

	
<div class="md-form">
  <input placeholder="Selected date" type="text" id="date-picker-example" class="form-control datepicker">
  <label for="date-picker-example">Try me...</label>
</div>	
	
	
	
	
	
	
</html>