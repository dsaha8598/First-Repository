<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<script type="text/javascript">
	$(function() {
		$('form[id="owner"]').validate({
			rules : {

				email : {
					required : true,
					email : true
				},
				pswd:'required',
	
			},
			messages : {
				
				email : 'please enter email',
				pswd : 'password required',
				
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>

<table height="600pixel" width="100%" border="0">
	<tr height="30%">
		<td colspan="2">			 
			<img src="images/logo.jpg" width="40%" height="40%"/>			
			<%@include file="Header.jsp"%>
							
		</td>
	</tr>
	
	
	
	<tr height="60%">
		  <td width="60%">
		  <%@include file="SlideImage.jsp" %> 
		  
		   </td>
		   
		   <td width="40%"><form:form action="loginPOST" modelAttribute="domain" method="POST" id="owner" >
		                    <b style="color:red">${msg }</b><br><br><br>
							<b style="color:#222211">enter user name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><form:input path="email"/><br><br><br>
							<b style="color:#222211">enter your password &nbsp;&nbsp;</b><form:input path="pswd" type="password"/><br>
							<input type="submit" value="submit"/>
							</form:form>
							<br><br><br><br>
							<a href="forgotPassword">
							<b1 style="color:#222211;35px">forgot password</b1>
							</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<b2 style="color:#004d4d;35px">New User? SignUp here</b2>&nbsp;&nbsp;&nbsp;<a href="signUp">signup</a>
			</td>
	 </tr>
	 
	 
	 
	 <tr height="10%">
	 <td colspan="2"><%@include file="Footer.jsp"%></td>
	 </tr>
	
	
</table>
</html>