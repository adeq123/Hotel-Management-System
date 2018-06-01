<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	<table border="1" height="90%" width="75%" align="center">
		<tr>
			<td height="80px">
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
				<!-- Page content table -->
				<table border="1" height="100%" width="100%" align="left">
					<td width="100px">
						<!--Left Side Menu  -->
					</td>
					<td>
						<!--Main content  --> <!--table with guests  -->
						<div>To do list:</div>
						<table>
							<c:forEach var="tempToDo" items="${toDo}">
								<tr>
									<td>
										<div class="todoMainList">${tempToDo.task}</div>
									</td>
									<td><form:form action="delete/?id=${tempToDo.id}"
											method="POST" modelAttribute="toDo">

											<input type="submit" value="&#10004" class="done" />

										</form:form></td>
								</tr>
							</c:forEach>
						</table>

						<table>
							<tr>
								<td>
								Add new task:
								</td>
							</tr>
							<tr>
							<td>
							<form:input path=""/>
							</td>
							</tr>
						</table>

					</td>
					<td width="100px">
						<!--Right Side Menu  -->
					</td>
				</table>
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