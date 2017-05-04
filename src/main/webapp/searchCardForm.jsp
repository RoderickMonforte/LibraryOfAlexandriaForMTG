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
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<div id="content">
<h3>${collection.displayName} Card List</h3>

<div>
    <div class="container-fluid">
        <h2>Search Results: </h2>
        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
            <th>Name</th>
            <th>Owned Qty</th>
            <th>Wish List Qty</th>
            <th>Notes</th>
            <th>Price</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach var="card" items="${cards}">
                <tr>
                    <td>${card.name}</td>
                    <td>${card.ownedQuantityString}</td></td>
                    <td>${card.wishListString}</td>
                    <td>${card.noteText}</td>
                    <td>${card.priceAmountString}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-primary dropdown-toggle"
                                    type="button"
                                    data-toggle="dropdown">Go</button>
                            <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Card Detail</a></li>
                                <li><a href="#">Edit</a></li>
                                <li><a href="#">Delete</a></li>
                            </ul>
                        </div>
                    </td>
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