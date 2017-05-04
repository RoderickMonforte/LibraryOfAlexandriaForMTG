<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<c:import url="head.jsp" />


<body>
<div id="wrap">
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<div id="content">
    <div class="row">
        <h4>Login Failed</h4>
        <br>
        <div class="alert alert-info">
            <strong>Info!</strong> Only users can access MTG Card Collections! Please sign up to be a user.
        </div>

    </div>
    <div class="row">
        <div class="col-md-3">
            <img src="images/LibraryofAlexandria.jpeg" alt="whale" class="fancy left"
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
                <form action="newUser.jsp" method="get">
                    <button type="submit" class="btn btn-success">New User Sign Up</button><br>
                </form>
            </div>


        </div>
    </div>
    <div class="row"></div>

<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>