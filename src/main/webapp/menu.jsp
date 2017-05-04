<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="nav">
    <ul class="nav navbar-nav">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="about.jsp">About</a></li>
        <li><a href="setUpCollection">Collection</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <c:choose>
            <c:when test="${isLoggedIn==true}">
                <li><a href="logOut">Logout</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="newUser.jsp">Sign Up</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>

