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
<h3>${card.getCardName()}</h3>
<img src="images/LibraryofAlexandria.jpeg" alt="whale" class="fancy right"
     style="height: 250px; width: 200px;" />
<div>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <table id="userTable" class="display" cellspacing="0" width="50%">
            <thead>
            <th>Attribute</th>
            <th>Value</th>
            </thead>
            <tbody>
            <c:forEach var="card" items="${collections}">
                <tr>
                    <td>${cardDetail.getFieldLabel()}</td>
                    <td>${cardDetail.getFieldValue()}</td>
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