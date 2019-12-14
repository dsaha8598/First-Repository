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

	<script>
	$(function () {
	    $("#datepicker").datepicker();
	});
	</script>



<style>
	div {
  background-image: url('images/back1.jpg');
   background-size: cover;
}
</style>
<div>
<!--  first division -->
	<div style="border:1px solid pink;padding:3px;font-size:20px;height:130px">  
		<table  style="border:0px;height:130px;width:1325px">
			<tr style="width:100px">
				<td width="20%"><img src="images/logo.jpg" style="width:300px;height:120px;"/></td>
				<td width="70%"><h1 style="color:maroon;font-size:50px">Welcome To Home Page</h1></td>
			</tr>
		</table>
	</div> 

	<!-- second devision -->
	<div style="border:1px solid red;padding:20px;height:800;width:1200;"><!-- background-color:#DB4479" -->
		<table border="0" width="100%" height="100%">
			<tr>
				<td width="70%" bgcolor="#DB4479"></td>
				<td width="10%" bgcolor="#DB4479"><%@include file="ViewTagsDropDown.jsp" %></td>
				<td width="10%" bgcolor="#DB4479"><%@include file="PurchaseDropDown.jsp" %></td>
				<td width="10%" bgcolor="#DB4479"><%@include file="AdminDropDown.jsp" %></td>

				
			</tr>
		</table>
	</div>

</div>
  </html>




























