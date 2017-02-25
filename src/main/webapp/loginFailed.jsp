<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<c:import url="head.jsp" />


<body>
<div id="wrap">
<div id="header"><br />
<br />
<h1>Library of Alexandria</h1>
<h4 style="text-align: right;">"My power is as vast as the plains, my strength is that of
    mountains. Each wave that crashes upon the shore thunders like blood in
    my veins." - D.B.
</h4>
</div>
<c:import url="menu.jsp" />
<div id="content">
<h4>Only users can access MTG Card Collections! Please sign up to be a user.</h4>
<img src="images/LibraryofAlexandria.jpeg" alt="whale" class="fancy left"
     style="height: 250px; width: 200px;" />
<p>This is a simple MTG cards cataloging application. You can add a
    collection and then add cards to a collection. Current price of cards are
    given.
</p>
<div>
    <form action="newUser.jsp" method="get">
        <button type="submit">New User Sign Up</button><br>
    </form>
</div>
<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>