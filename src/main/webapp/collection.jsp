<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<c:import url="head.jsp" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#collectionTable').DataTable({
            "columns": [
                { "width": "18%" },
                { "width": "25%" },
                { "width": "25%" },
                { "width": "10%" },
                { "width": "10%" },
                { "width": "12%" }
            ]
        });
    } );
</script>
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
<h3>${user.displayName} Collection</h3>
<div id="message">
    <p>${errorMessage}</p>
</div>
<div id="good">
    <p>${goodMessage}</p>
</div>
<br/>
<div>
    <div class="container-fluid">
        <h4>Search Results: </h4>
        <form action="addCollection" method="get">
        <table id="collectionTable" class="display" cellspacing="0" width="100%">
            <thead>
            <th>Name</th>
            <th>Description</th>
            <th>Notes</th>
            <th>Card Qty.</th>
            <th>Price</th>
            <th>Action</th>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" class="form-control" id="collectionName"
                           name="CollectionName"
                           placeholder="new collection name" value=${collectionName}>
                </td>
                <td><!--<input type="text" class="form-control"
                            id="descriptionText"
                           name="DescriptionText"
                           placeholder="new description"
                           value=${descriptionText}>-->
                    <textarea rows="2" cols="20" class="form-control"
                              id="descriptionText" name="DescriptionText"
                              placeholder="new description">${descriptionText}</textarea>
                </td>
                <td><!--<input type="text" class="form-control" id="noteText"
                           name="NoteText"
                           placeholder="note to self" value=${noteText}>-->
                    <textarea rows="2" cols="20" class="form-control"
                              id="noteText" name="NoteText"
                              placeholder="reminder">${noteText}</textarea>

                </td>
                <td><input type="text" readonly="readonly"
                           class="form-control"
                           id="cardQuantity"
                           name="CardQuantity"
                           placeholder="counted">
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
            <c:forEach var="collection" items="${collections}">
                <tr>
                    <td>${collection.displayName}</td>
                    <td>${collection.descriptionText}</td></td>
                    <td>${collection.noteText}</td>
                    <td>${collection.cardQuantityString}</td>
                    <td>${collection.priceAmountString}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-primary dropdown-toggle"
                                    type="button"
                                    data-toggle="dropdown">Go</button>
                                <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Card List</a></li>
                                <li><a href="updateCollection?mode=preUpdate;${collection.collectionId}">Edit</a></li>
                                <li><a href="deleteCollection?collectionId=${collection.collectionId}">Delete</a></li>
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