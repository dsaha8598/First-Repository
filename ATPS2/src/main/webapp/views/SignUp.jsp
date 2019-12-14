<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<!----------------------------------- date picker for dob-------------------------------- -->
	<script>
	
	</script>
<!-- -----------------------------------for ajax call--------------------------------------------------- -->
<script>
$(document).ready(function(){
	$("#emailErrMsg").html('');
	
	$(function () {
	    $("#datepicker").datepicker();
	});
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
<style type="text/css">
.container {
	max-width: 540px;
	width: 400px;
	border: 1px solid blue;
	border-radius: 7px;
	box-shadow: 5px 17px 10px #956d6d;
	background: #fff;
}

.text-info {
	color: #17a2b8 !important;
	font-weight: bold;
}

.back {
	background-color: #e4ead8;
}

.error {
	color: red;
}

</style>




<table height="600pixel" width="100%" border="0">
	<tr height="30%">
	    <td colspan="2">
	     <%-- <%@include file="Header.jsp"%> --%>
	       <img src="images/logo.jpg" width="40%" height="40%"/>
	       <h1 style="color:maroon;text-align:center">SignUp here by filling correct details</h1>
			
	     </td>
	</tr>
	
	<tr height="55%">
	  <td width="30%">
	   <b>${obj }</b>
	   </td>
	   
	   <td width="70%">
	   <form:form action="signUpPost" method="POST" modelAttribute="domain" id="owner">
		   <table width="100%" height="100" border="0">
		    <tr>
		      <td width="30%" >Enter First Name</td>
		      <td width="30%"><form:input path="firstName" type="text"/></td>
		    </tr>
		    
		     <tr>
		      <td width="30%">Enter Last Name</td>
		      <td width="30%"><form:input path="lastName" type="text"/></td>
		    </tr>
		    
		     <tr>
		      <td width="30%">Enter Email</td>
		      <td width="30%" ><form:input path="email" type="text" id="email"/></td>
		      <td width="40%" style="color:red" id="emailErrMsg"></td>
		    </tr>
		     <tr>
		      <td width="30%">Enter Phone Number</td>
		      <td width="30%"><form:input path="phNo" type="text"/></td>
		    </tr>
		     <tr>
		      <td width="30%">Enter Date of Birth</td>
		      <td width="30%"><form:input path="dob" id="datepicker" /></td>
		    </tr>
		    <tr>
		      <td width="30%">Select Your Gender</td>
		      <td width="30%"><INPUT TYPE="radio" name="gender" value="male" checked/>male
									<INPUT TYPE="radio" name="gender" value="female"/>female
									<INPUT TYPE="radio" name="gender" value="other"/>others
			 </td>
		    </tr>
		    <tr>
		      <td width="30%"><input type="reset" value="Reset" /></td>
		      <td width="30%"><input type="submit" value="Next" /></td>
		      <td width="40%"><a href="login"><button></button></a></td>
		    </tr>
		    
		   </table>
	   </form:form>
	   </td>
	   <tr height="5%"><td><a href="login"><button>home</button></a></td></tr>
	   
	   
	<tr height="10%">
	   <td colspan="2"><%@include file="Footer.jsp"%></td>
	 </tr>
	 </table>
	 
	 
</html>