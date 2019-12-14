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
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	   </head>
	<script>
		$(function () {
		    $("#datepicker").datepicker();
		    
  </script>
<!--------------------------------------------ajax call-----------------------------------------------------------  -->
	<script>
	$(document).ready(function(){
$("#email").blur(function(){
	var enteredEmail=$("#email").val();
	$.ajax({
		url : '/ATPS/checkUniqueEmail',
		data :{
				email:  enteredEmail
		},
		success:function(result){
			if(result=='failure'){
				var errMsg='duplicate Email id'
				$("#emailErrMsg").html(errMsg)
			}
			
		}
	});
});
});
</script>
<!-- ------------------------------------form validation------------------------------------------------------------ -->
<script type="text/javascript">
	$(function() {
		$('form[id="owner"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				email : {
					required : true,
					email : true
				},
				gender:'required',
				phNo : 'required',
				dob:'required',
			},
			messages : {
				firstName : 'Please enter firstName',
				lastName : 'Please enter lastName',
				email : 'please enter email',
				phNo : 'Please enter phone number',
				gender : 'Please select gender',
				dob : 'Please select DOB',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
	
	
</script>



<style>
	div {
		  background-image: url('images/back1.jpg');
		   background-size: cover;
		}
		</style>
<!-------------------------------------  header division -------------------------------------------------------------->
		<div style="border:0px solid pink;padding:3px;font-size:20px;height:130px">  
			<table  style="border:0px;height:130px;width:1325px">
				<tr style="width:100px">
					<td width="20%"><img src="images/logo.jpg" style="width:300px;height:120px;"/></td>
					<td width="70%"><h1 style="color:maroon;font-size:50px">Welcome To Home Page</h1></td>
				</tr>
			</table>
		</div> 
	
<!----------------------------------- middle division ----------------------------------------------------------------->
	
	<style>
      .flex-container {
        display: flex;
        align-items: center; /* Use another value to see the result */
        width: 100%;
        height: 40px;
        background-color:;
      }
      .flex-container > div {
        width: 45%;
        height: 50px;
        margin: 5px;
        border-radius: 6px;
        background-color: ;
      }
    </style>
   
   <table>
    <tr>
     <td width="30%"></td>
     
     <td width="70%">
		<div style="border:0px solid green;padding:3px;width:700px;height:600px">
		<form:form action="registerAgencyPost" method="POST" modelAttribute="domain" id="owner">
				<div style="border:0px solid cyan;padding:3px;text-align:center;width:800px"  class="flex-container">
					<div style="font-size:23px">Enter First Name</div>
					<div><form:input path="firstName" type="text"/></div>
					<div></div>
				</div>
				<div style="border:0px solid cyan;padding:3px;text-align:center;width:800px"  class="flex-container">
					<div style="font-size:23px">Enter Last Name</div>
					<div><form:input path="lastName" type="text"/></div>
					<div></div>
				</div>
				<div style="border:0px solid cyan;padding:3px;text-align:center;width:800px"  class="flex-container">
					<div style="border:0px solid red;font-size:23px" >Enter Email</div>
					<div><form:input path="email" type="text" id="email"/></div>
					<div id="emailErrMsg" style="color:red"></div>
				</div>
				<div style="border:0px solid cyan;padding:3px;text-align:center;width:800px"  class="flex-container">
					<div style="font-size:23px">Enter Phone Number</div>
				   <div><form:input path="phNo" type="text"/></div>
				   <div></div>
				</div>
				<div style="border:0px solid cyan;padding:3px;text-align:center;width:800px"  class="flex-container">
					<div style="font-size:23px">Enter Date of Birth</div>
					<div><form:input path="dob" id="datepicker" /></div>
					<div></div>
				</div>
				<div style="border:0px solid cyan;padding:3px;text-align:center;width:800px"  class="flex-container">
					<div style="font-size:23px">Select Role</div>
					<div><select name="role">
							  <option value="AGENCY">Agency</option>
							  <option value="ADMIN">Admin</option>
							  <option value="USER">User</option>
						</select>
					</div>
					<div></div>
				</div>
				<div style="border:0px solid cyan;padding:3px;text-align:center;width:800px"  class="flex-container">
					<div><input type="reset" value="Reset" /> </div>  
			       <div> <input type="submit" value="Next" /></div>
			       <div></div>
				</div>
			</form:form>
			<div><a href="login">return to login page</a></div>
		</div>
		</td>
		</tr>
	</table>
<!--------------------------------------- footer division -------------------------------------------------------------->
 <div style="height:100px"></div><div style="height:100px"></div>
     <div>
    <%@include file="Footer.jsp" %>
    </div>
	
	</html>