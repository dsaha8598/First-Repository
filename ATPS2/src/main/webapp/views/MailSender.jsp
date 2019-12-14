<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<table height="600pixel" width="100%" border="0">
	<tr height="30%">
		<td colspan="2">			 
			<img src="images/logo.jpg" width="40%" height="40%"/>			
			<%@include file="Header.jsp"%>
							
		</td>
	</tr>
		<tr height="60%">
			<td width="50">
			<h1></h1>
			</td>
			<td width="50">
				<b style="color:#00cc00;text-align:center;font-size:30px">u have done registration success fully</b><br>
				<b style="color:#00cc00;text-align:center;font-size:30px">your account is in lock mode</b>
				<b style="color:#00cc00;text-align:center;font-size:30px">a mail has been sent to your mail id,go and check your mail id</b><br>
				<b style="color:#00cc00;text-align:center;font-size:30px">use the link given to unlock your account</b><br><br><br>
				<a href="login"><button>go to login page</button></a>
			</td>
		</tr>
		
	<tr height="10%">
	 <td colspan="2"><%@include file="Footer.jsp"%></td>
	 </tr>

</html>