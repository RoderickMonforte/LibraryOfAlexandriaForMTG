<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<c:import url="head.jsp" />


<body>
<div id="wrap">
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<div id="content">
<h3>Welcome to Library of Alexandria</h3>
<div class="row">
    <div class="col-md-3">
        <img src="images/LibraryofAlexandria.jpeg" alt="library" class="fancy left"
            style="height: 250px; width: 179px;" />
    </div>
    <div class="col-md-9">
        <div class="row">
            <p>This is a simple MTG cards cataloging application. You can add a
                collection and then add cards to a collection. Current price of cards are
                given.
            </p>
        </div>
        <div class="row">
            <form action="setUpCollection" method="get">
                <button type="submit" class="btn btn-primary">Show Collection</button><br><br>
            </form>
            <c:choose>
                <c:when test="${isLoggedIn==true}">
                    <form action="setUpUser" method="get">
                        <button type="submit" class="btn btn-info">Update User Profile</button><br><br>
                    </form>
                    <form action="logOut" method="get">
                        <button type="submit" class="btn btn-info">Log Out</button><br>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="newUser.jsp" method="get">
                        <button type="submit" class="btn btn-success">New User Sign Up</button><br>
                    </form>
                </c:otherwise>
            </c:choose>

        </div>
        <div class="row">
            <div class="container-fluid" ${alert.hidden}>
                <div class="${alert.type}">
                    ${alert.message}
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>