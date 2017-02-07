<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>
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
<div id="nav">
<ul>
<li><a href="#">Home</a></li>
<li><a href="#">About</a></li>
<li><a href="#">Collection</a></li>
</ul>
</div>
<div id="content">
<h3>Welcome of Library of Alexandria</h3>
<img src="images/LibraryofAlexandria.jpeg" alt="whale" class="fancy left"
     style="height: 250px; width: 200px;" />
<p>This is a simple MTG cards cataloging application. You can add a
    collection and then add cards to a collection. Current price of cards are
    given.
</p>
<div>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
            <th>Name</th>
            <th>Description</th>
            <th>Notes</th>
            <th>Price</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.displayName}</td>
                    <td>${user.description}</td></td>
                    <td>${user.note}</td>
                    <td>${user.getPrice()}</td>
                </tr>


            </c:forEach>
            </tbody>
        </table>
    </div>


</div>
<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>