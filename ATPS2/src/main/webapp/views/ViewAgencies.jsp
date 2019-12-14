<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="./views/css/bootstrap.min.css" />
<link rel="stylesheet" href="./views/css/jquery-ui.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">



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
<!------------------------------------------------- middle------------------------------------------------------- -->		

<table align="center" width="800" height="300" border="5|0" bordercolor="teal" style="color:lime" bgcolor="white">
		<thead>
			<tr>
				<th style="font-size:25px;color:#501B1D">First Name</th>
				<th style="font-size:25px;color:#501B1D">Last Name</th>
				<th style="font-size:25px;color:#501B1D">Email</th>
				<th style="font-size:25px;color:#501B1D">phone no</th>
				<th style="font-size:25px;color:#501B1D">Date Of Birth</th>
				<th style="font-size:25px;color:#501B1D">Role</th>
				<th style="font-size:25px;color:#501B1D">actiom</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="agency" items="${listUser}" varStatus="index">
				<tr>
					<td style="font-size:20px;color:#9A1750">${agency.firstName}</td>
					<td style="font-size:20px;color:#9A1750">${agency.lastName}</td>
					<td style="font-size:20px;color:#9A1750">${agency.email }</td>
					<td style="font-size:20px;color:#9A1750">${agency.phNo }</td>
					<td style="font-size:20px;color:#9A1750">${agency.dob }</td>
					<td style="font-size:20px;color:#9A1750">${agency.role}</td>
					<td>
					   <c:choose>
							<c:when test="${activeStatus==agency.activeStatus}">
							   <a href="deActivate?id=${agency.id }" onclick="return confirm('Are you sure you want to deactivate?');">
							     <img src="images/d.jpg" height="50px" width="100px"/>
							   </a>
				            </c:when>
			                <c:otherwise>
				                  <a href="activate?id=${agency.id }" onclick="return confirm('Are you sure you want to activate this item?');">
				                     <img src="images/a.jpg" height="50px" width="100px"/>
				                  </a>
			                </c:otherwise>
		            	</c:choose>
					</td>										
			    </tr>
		    </c:forEach>	
		</tbody>
	</table>
	
	<div>
			<h1 align="center" style="color:#CD5C5C">
				<c:if test="${cp>1 }">
				  <a href="viewAgencies?pn=${cp-1 }">previous</a>
				</c:if>
				
				<c:forEach  begin="1" end="${tp}" var="i">
					<c:choose>
							<c:when test="${cp==i}">
							  <c:out value="${i }"/>
							</c:when>
						    <c:otherwise>
							  <a href="viewAgencies?pn=${i}"><c:out value="${i}"/></a>
						    </c:otherwise>
					</c:choose>
					 
				</c:forEach>
				<c:if test="${cp<tp }">
				<a href="viewAgencies?pn=${cp+1 }">next</a>
				</c:if>			         
			</h1>
	</div>   
	 
	 <br><br>
	
	
	<div style="font-size:40px;color:blue;text-align:center"><a href="home">home</a></div>
<!-------------------------------------------- footer section --------------------------------------------------------->
<div><%@include file="Footer.jsp" %></div>
</html>