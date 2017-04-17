<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>
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

    <%--first row of the content wich is the collection name--%>
    <div class="row">
        <div class="col-*-*">
            <h3>${collection.displayName} Card List</h3>
        </div>
    </div>

    <%--second row for messages--%>
    <div class="row">
        <div class="col-*-*">
            <div class="container">
                <h2>Alerts</h2>
                <div class="alert alert-success">
                    ${goodMessage}
                </div>
                <div class="alert alert-info">
                   ${infoMessage}
                </div>
                <div class="alert alert-warning">
                    $warningMessage}
                </div>
                <div class="alert alert-danger">
                    ${errorMessage}
                </div>
            </div>
        </div>
    </div>

    <%--third row for image and table content--%>
    <div class="row">
        <%--first column of the third row is card image--%>
        <div class="col-md-3">
            <img id="cardImage" src="images/LibraryofAlexandria.jpeg" style="height: 250px; width: 200px;" />
        </div>
        <%--second column of the third row for collection cards--%>
        <div class="col-md-9">
            <form action="searchCardForm.jsp" method="get">
                <button type="submit" name="submit" value="Enter"
                        class="btn btn-primary">Add</button>
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
                <tr>
                    <td><input type="text" class="form-control" id="cardName"
                               name="CardName"
                               placeholder="enter card name" value=${cardName}>
                    </td>
                    <td><input type="text" class="form-control"
                               id="ownedQuantity"
                               name="OwnedQuantity" value=${ownedQuantity}
                               placeholder="#">
                    </td>
                    <td><input type="text" class="form-control"
                               id="wishList"
                               name="WishList" value=${wishList}
                                       placeholder="#">
                    </td>
                    <td><textarea rows="2" cols="20" class="form-control"
                                  id="noteText" name="NoteText"
                                  placeholder="thoughts?">${noteText}</textarea>

                    </td>
                    <td><input type="text" readonly="readonly"
                               class="form-control"
                               id="priceAmount"
                               name="PriceAmount"
                               placeholder="computed">
                    </td>
                    <td><button type="submit" name="submit" value="Enter"
                                class="btn btn-primary">Add</button>
                    </td>
                </tr>
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
            </form>
        </div>
    </div>

<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>