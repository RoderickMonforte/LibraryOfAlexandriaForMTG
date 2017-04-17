<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<c:import url="head.jsp" />
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
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
        <%--first row of the content wich is the collection name--%>
        <div class="row">
            <div class="col-*-*">
                <h3>${collection.displayName} Card List</h3>
            </div>
        </div>

        <%--second row of he content which is the image and form to get card details    --%>
        <div class="row">
            <%--first column of the second row is card image--%>
            <div class="col-md-3">
                <img id="cardImage" src="images/LibraryofAlexandria.jpeg" style="height: 250px; width: 200px;" />
            </div>
            <%--second column of the second row is card selector--%>
            <div class="col-md-5">
                <form id="addCardForm" method="get" action="addCardLocal">
                    <div class="form-group">
                        <label for="query">Start Typing Card Name</label>
                        <input type="text" id="query" class="form-control" placeholder="Enter name of card"/>
                    </div>
                    <div class="form-group">
                        <label for="buildSelect">Select the actual card to add</label>
                        <select id="buildSelect" name="TheChoice" required>
                        </select>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="ownedCount" >Owned Quantity</label>
                                <input type="number" min="0" id="ownedCount" name="OwnedCount" class="form-control" value=0 required/>
                            </div>
                        </div>
                            <div class="col-md-6">
                            <div class="form-group">
                                <label for="wishCount" >Wish Count</label>
                                <input type="number" min="0" id="wishCount" name="WishCount" class="form-control" value=0 required/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10">
                            <div class="form-group">
                                <label for="noteText" >Note Text</label>
                                <textarea id="noteText" name="NoteText" class="form-control" rows="2" cols="20" placeholder="notes about this card" value="">
                                </textarea>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <br><br>
                            <input type="submit" class="btn btn-info" value="Add" >
                        </div>
                    </div>
                </form>
                <script>
                    $("#addCardForm").validate();
                </script>
            </div>
            <%--third column of the second row is the details about highlighted card--%>
            <div class="col-md-4">
                <table class="table table-bordered">
                    <tr>
                        <th>Card Name</th>
                        <td id="mouseCardName"></td>
                    </tr>
                    <tr>
                        <th>Artist Name</th>
                        <td id="mouseArtistName"></td>
                    </tr>
                    <tr>
                        <th>Flavor Text</th>
                        <td id="mouseCardText"></td>
                    </tr>

                </table>
            </div>
        </div>

<script>
    document.getElementById("query").addEventListener('keyup', function() {
        var query = document.getElementById("query").value
        loadOptions(query);
    }, false);

    function loadOptions() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                obj = JSON.parse(this.responseText);
                var options = "";
                var optionId = "";
                for (i = 0; i < obj.cards.length; i++) {
                    optionId = "options" + String(i);
                    sessionStorage.setItem(optionId, JSON.stringify(obj.cards[i]));
                    options = options + "<option onmouseover=mOver(\"" + optionId + "\") value="+ obj.cards[i].multiverseid +">" + obj.cards[i].name + "-" + obj.cards[i].setName+"</option>";
                }
                document.getElementById("buildSelect").innerHTML = options;
                var tValue = document.getElementById("buildSelect").value;
//                document.getElementById("testValue").innerHTML = options;

            }
        };
        var a = "https://api.magicthegathering.io/v1/cards?name=" + arguments[0];
        var b = a.concat(arguments[0]);
        xhttp.open("GET", a, true);
        xhttp.send();
    }

    function mOver() {
        var optionId = arguments[0];
        var cardOver = JSON.parse(sessionStorage.getItem(optionId));
        document.getElementById("cardImage").src = "images/noimagefound.jpg";
        document.getElementById("mouseCardName").innerHTML = cardOver.name;
        document.getElementById("mouseArtistName").innerHTML = cardOver.artist;
        document.getElementById("mouseCardText").innerHTML = cardOver.flavor;

        if (cardOver.imageURL != "undefined") {
            document.getElementById("cardImage").src = cardOver.imageUrl.toString();
        }
    }



</script>
        <c:import url="termsOfUse.jsp" />
    </div>
</div>
<c:import url="footer.jsp" />
</body>
</html>
