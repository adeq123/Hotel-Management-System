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
<c:url var="backGroundLink"
	value="/resources/images/hotel-page-background.jpg"></c:url>

<body background="${backGroundLink}">
	<table class="main">
		<tr>
			<td height="80px" >
				<!-- HEADER  --> <jsp:include page="include/header.jsp" />
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- Upper Menu  --> <jsp:include page="include/upperMenu.jsp" />
			</td>
		</tr>
		<tr>
			<td height="350px">
				<!-- Page content table --> <!-- //<div style="overflow-x: auto;"> -->
				<table height="100%" width="100%" class="content">
					<td width="100px">
						<!--Left Side Menu  --> <%-- <jsp:include page="include/guestLeftMenu.jsp" /> --%>
					</td>
					<td>
						<!--Main content  --> <!--table with guests  -->
						<div align = "left">Hotel status:</div> <br>
						<table class="status">
							<!-- Heading  -->
							<tr>
								<th>Rooms</th>
								<th><tab4/></th>
								<th>Guests</th>
								<th></th>
							</tr>
							<!-- First row  -->
							<tr>
								<td>Number of rooms: </td>
								<td>${numberOfRooms}</td>
								<td>Number of Guests: </td>
								<td>${numberOfGuests}</td>

							</tr>
							<tr>
								<td>Occupied rooms: </td>
								<td>${numberOfOccupiedRooms}</td>
								<td>Upcoming checkouts: </td>
								<td>${upcommingCheckOuts}</td>

							</tr>

							<tr>
								<td>Free rooms:</td>
								<td>${numberOfVacantRooms}</td>
								<td></td>
								<td></td>

							</tr>
							<tr>
								<td>Free standard rooms:</td>
								<td>${numberOfVacantStandardRooms}</td>
								<td></td>
								<td></td>

							</tr>
							<tr>
								<td>Free business rooms:</td>
								<td>${numberOfVacantBusinessRooms}</td>
								<td></td>
								<td></td>

							</tr>

							<tr>
								<td>Free premium rooms:</td>
								<td>${numberOfVacantPremiumRooms}</td>
								<td></td>
								<td></td>

							</tr>

						</table>
					</td>
					<td width="100px">
						<!--Right Side Menu  -->
						<jsp:include page="include/rightMenu.jsp"/>
					</td>
				</table> <!-- </div> -->
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- Footer  --> <jsp:include page="include/footer.jsp" />
			</td>
		<tr>
	</table>


</body>
</html>