<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<h1 style="color: green; text-align: center">First you need to
	Enter your vehicle registration number</h1>

<div style="color: brown; padding: 3px; font-size: 30px">
     <form:form action="getAdressDetails" modelAttribute="domain" method="POST">
	<table>
			
			<tr>
				<td>Enter registration number here</td>
				<td><form:input type="text" path="vehicle_reg_num" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT" /></td>
			</tr>
	</table>
 </form:form>
</div>


<!---------------------------------------------------------------------------------------------------------------->

<div style="color: brown; padding: 3px; font-size: 30px">
	<b>Have a look in your adress details</b> <b>${adress }</b>
</div>
<div>
	<a href="home">HOME</a><br>
	<br> <a href="">PROCEED</a>
</div>
</html>