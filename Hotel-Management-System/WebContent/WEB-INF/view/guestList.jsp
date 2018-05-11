<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guest List</title>
			
</head>
<body>
<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Room</th>
					<th>Phone Number</th>
					<th>Checkout</th>
				</tr>
				<!-- loop over and print out customers  -->
				<c:forEach var="tempGuest" items="${guestList}">

				<!--construct an cheout link with customer id  -->
					<c:url var="checkoutLink" value="/customer/checkout">
						<c:param name="guestId" value="${tempGuest.id}" />
					</c:url>
					
					<tr>
						<td>${tempGuest.firstName}</td>
						<td>${tempGuest.lastName}</td>
						<td>${tempGuest.room}</td>
						<td>${tempGuest.phoneNumber}</td>
						<td><a href="${updateLink}">Update</a> </td>
					</tr>
				</c:forEach>
			</table>
</body>
</html>