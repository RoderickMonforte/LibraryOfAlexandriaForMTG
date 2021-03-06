<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<c:import url="head.jsp" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable({
            "responsive" : true
        });
    } );

</script>


<body>
<div id="wrap">
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<div id="content">

    <%--first row of the content wich is the collection name--%>
    <div class="row">
        <div class="col-*-*">
            <h3>${collection.displayName} Card List</h3>
        </div>
    </div>

    <%--second row for messages--%>
    <div class="row">
        <div class="col-*-*">
            <div class="container-fluid" ${alert.hidden}>
                <div class="${alert.type}">
                    ${alert.message}
                </div>
            </div>
        </div>
    </div>

    <%--third row for image and table content--%>
    <div class="row">
        <%--first column of the third row is card image--%>
        <div class="col-md-3">
            <img id="cardImage" src="images/LibraryofAlexandria.jpeg" style="height: 250px; width: 179px;" />
            <br><br>
            <form action="addCard.jsp" method="get">
                <button type="submit" name="submit" value="Enter"
                        class="btn btn-primary">Add new card</button>
            </form>
            <br>
            <strong>Collection Statistics</strong>
            <table class="table table-bordered">
                <tr>
                <th>Owned Cards</th><td> ${collection.cardQuantityString} </td>
                </tr>
                <tr>
                <th>Total Price</th><td> ${collection.priceAmountString} </td>
                </tr>
            </table>
        </div>
        <%--second column of the third row for collection cards--%>
        <div class="col-md-9">
            <div class="container-fluid">
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
                        <tr onmouseover="{document.getElementById('cardImage').src = '${card.cardItemById.imageUrl}';
                        return false;}">
                            <td>${card.cardItemById.cardName}</td>
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
                                        <li><a href="setUpCard?cardId=${card.cardId}">View/Edit</a></li>
                                        <li><a href="deleteCard?cardId=${card.cardId}">Delete</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>