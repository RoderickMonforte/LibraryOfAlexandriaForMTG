<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<c:import url="head.jsp" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#collectionTable').DataTable({
            "responsive" : true,
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
<c:import url="header.jsp" />
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
        <div class="row" ${alert.hidden}>
            <div class="${alert.type}">
                ${alert.message}
            </div>
        </div>
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
                    <td>
                        <div class='form-group${alert.getField("CollectionName").fieldClass}'>
                            <input type="text" class="form-control" id="collectionName"
                                   name="CollectionName" placeholder="new collection name"
                                   value='${alert.getField("CollectionName").value}'>
                            ${alert.getField("CollectionName").spanString}
                        </div>
                    </td>
                    <td>
                        <div class='form-group${alert.getField("DescriptionText").fieldClass}'>
                            <textarea rows="2" cols="20" class="form-control"
                                      id="descriptionText" name="DescriptionText"
                                      placeholder="new description">${alert.getField("DescriptionText").value}</textarea>
                            ${alert.getField("DescriptionText").spanString}
                        </div>

                    </td>
                    <td>
                        <div class='form-group${alert.getField("NoteText").fieldClass}'>
                            <textarea rows="2" cols="20" class="form-control"
                                      id="noteText" name="NoteText"
                                      placeholder="reminder">${alert.getField("NoteText").value}</textarea>
                            ${alert.getField("NoteText").spanString}
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
                                <li><a href="setUpCardLocal?collectionId=${collection.collectionId}">Card List</a></li>
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