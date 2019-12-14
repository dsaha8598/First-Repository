<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<table height="600pixel" width="100%" border="1">
	<tr height="30%">
		<td colspan="2">			 
			<img src="images/logo.jpg" width="40%" height="40%"/>			
			<%@include file="Header.jsp"%>
							
		</td>
	</tr>
	
	
	
	<tr height="60%">
			  <td width="40%">
			  </td>
		   
			   <td width="60%">
			   <b style="color:red;font-size:20px">${msg}</b><br><br><br><br><br>
	           <form:form action="forgotPasswordPOST" modelAttribute="domain" method="POST">
	           <b style="color:green">Enter your Email id</b> 
	           <form:input type="text" path="email"/><br><br><br><br><br>
	           <input type="submit" value="submit"/>
	           &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
	           
	           </form:form>
	           <a href="login"><button>go to login page</button></a>
			   </td>
	 </tr>
	 
	 
	 
	 <tr height="10%">
	 <td colspan="2"><%@include file="Footer.jsp"%></td>
	 </tr>
	
	
</table>
</html>