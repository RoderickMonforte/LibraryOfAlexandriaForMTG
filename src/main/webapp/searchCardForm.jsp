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
<h3>${collection.displayName} Card List</h3>
<div id="message">
    <p>${errorMessage}</p>
</div>
<div id="good">
    <p>${goodMessage}</p>
</div>
<div>
    <form action="createCardList" method="get">
        <input type="text" class="form-control" id="cardName"
               name="CardName"
               placeholder="enter card name" value=${cardName}>
        <select id="cardSelect" name="cardChosen">
        </select>
        <button type="submit" name="submit" value="Enter"
                class="btn btn-primary">Search</button>
    </form>
    <div class="container-fluid">
        <h4>Search Results: </h4>
        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
            <th>Name</th>
            <th>Set</th>
            <th>Image</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach var="card" items="${cards}">
                <tr>
                    <td>${card.name}</td>
                    <td>${card.setName}</td></td>
                    <td>< <img height="14" width="10" src="${card.imageUrl}"></td>
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
<script>
    document.getElementById("cardName").addEventListener('keyup', function() {
        var query = document.getElementById("cardName").value
        loadDoc(query);
    }, false);
    function loadDoc() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 &amp;&amp; this.status == 200) {
                obj = JSON.parse(this.responseText);
                var options = "";
                var i = 0;
                for (i = 0; i &lt; obj.cards.length; i++) {
                    options = options + "&lt;option value=obj.cards[i].multiverseid>" + obj.cards[i].name + "-" + obj.cards[i].setName+"</option>";
                }
                document.getElementById("testselect").innerHTML = options;

            }
        };
        var a = "https://api.magicthegathering.io/v1/cards?name=" + arguments[0]
        var b = a.concat(arguments[0])
        xhttp.open("GET", a, true);
        xhttp.send();
    }
</script>

</body></html>