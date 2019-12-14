<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="vendor/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>


<script>
$(function () {
    $("#datepicker").datepicker();
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

<script type="text/javascript">
	$(function() {
		$('form[id="owner"]').validate({
			rules : {
				pswd:'required',
				cpswd:'required',
				upswd:'required',
				
			},
			messages : {
				pswd : 'Please enter Temporary password',
				npswd: 'Please enter New password',
				upswd: 'Please confirm your password',
				
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
	     <%-- <%@include file="Header.jsp"%> --%>
	       <img src="images/logo.jpg" width="40%" height="40%"/>
	       <h1 style="color:maroon;text-align:center">Please Update Your Password to Unlock your Account</h1>
			
	     </td>
	</tr>
	
	<tr height="60%">
	  <td width="30%"><b>${obj }</b>
	   </td>
	   
	   <td width="70%">
	   <form:form action="updatePasswordPOST" method="POST" modelAttribute="domain" id="owner">
		   <table width="100%" height="100">
		    <tr>
		      <td width="30%">your Mail id is</td>
		      <td width="70%"> <form:input path="email" value="${domain.email }"/> </td>
		    </tr>
		    
		     <tr>
		      <td width="30%">Enter Temporary Password  </td>
		      <td width="70%"><form:input path="pswd" type="text"/><b style="color:red">${msg }</b></td>
		    </tr>
		    
		     <tr>
		      <td width="30%">Enter new Password</td>
		      <td width="70%"><form:input path="cpswd" type="text"/></td>
		    </tr>
		     <tr>
		      <td width="30%">Confirm Password</td>
		      <td width="70%"><form:input path="upswd" type="text"/></td>
		    </tr>
		    
		    <tr>
		      <td width="30%"><input type="reset" value="Reset" /></td>
		      <td width="70%"><input type="submit" value="Next" /></td>
		    </tr>
		    
		   </table>
	   </form:form>
	   </td>
	   
	   
	<tr height="10%">
	   <td colspan="2"><%@include file="Footer.jsp"%></td>
	 </tr>
</html>