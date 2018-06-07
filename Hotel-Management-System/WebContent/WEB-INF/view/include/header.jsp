<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="header">Hotel Management System</h1>


<div class ="loginOut">
	<c:choose>
		<c:when test="${empty loggedInUser.firstName}">
			<a href="${pageContext.request.contextPath}/login" class ="loginOut">Login</a>
		</c:when>
		<c:otherwise>
				Hello ${loggedInUser.firstName}
				<a href="${pageContext.request.contextPath}/logout" class ="loginOut">Logout</a>
		</c:otherwise>
	</c:choose>
</div>