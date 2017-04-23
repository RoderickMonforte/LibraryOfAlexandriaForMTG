<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h3>Welcome to Library of Alexandria</h3>
<img src="images/LibraryofAlexandria.jpeg" alt="whale" class="fancy left"
     style="height: 250px; width: 179px;" />
<p>This is a simple cataloging application built for storing Magic the
    Gathering Cards. This uses web service to get prices and other attributes
    of the card.
</p>
    <a href="addCard.jsp">test only </a>

<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>