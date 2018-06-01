<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Management System</title>

<!-- refrence our style sheet  -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/common.css" />
</head>

<!--link to background  -->
<c:url var="backGroundLink" value = "/resources/images/hotel-page-background.jpg"></c:url>

<body background = "${backGroundLink}">
	<table border="1" height = "90%" width="75%" align="center">
		<tr>
			<td height="80px">
				<!-- HEADER  -->
				<jsp:include page="include/header.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- Upper Menu  -->
				<jsp:include page="include/upperMenu.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="350px">
				<!-- Page content table -->
				<table border = "1" height = "100%" width="100%" align="left">
					<td width = "100px">
						<!--Left Side Menu  -->
						<jsp:include page="include/roomLeftMenu.jsp"/>
					</td>
					<td>
						<!--Main content  -->
						<!--table with guests  -->
						<div>Available rooms: </div><br>
						<table>
							<tr>
								<th>Number</th>
								<th>Standard</th>
								<th>Occupied</th>
								<th>Check in</th>

							</tr>
							<!-- loop over and print out customers  -->
							<c:forEach var="tempRoom" items="${roomList}">

								<!--construct an cheout link with room id  -->
								<c:url var="checkinLink" value="/guest/checkin">
									<c:param name="roomId" value="${tempRoom.id}" />
								</c:url>

								
								<tr>
									<td>${tempRoom.number}</td>
									<td>${tempRoom.standard}</td>
									 <td>${tempRoom.isOccupied}</td> 
									<td><a href="${checkinLink}">Check in</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td width = "100px">
						<!--Right Side Menu  -->
						<jsp:include page="include/rightMenu.jsp"/>
					</td>
				</table>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- Footer  -->
				<jsp:include page="include/footer.jsp"/>
			</td>
		<tr>
	</table>
	

</body>
</html>