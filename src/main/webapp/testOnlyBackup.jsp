<!DOCTYPE html>
<html>
<body>

<div id="demo">
    <h1>The XMLHttpRequest Object</h1>
    <button type="button" onclick="loadDoc('dakkon')">Change Content</button>
    <input type="text" id="query" data-validation="number"/>
    <select id="testselect" name="testChoice" >
    </select>
    <textarea id="testValue" rows="10" cols="30"> </textarea>
    <img id="myImage" src="" />
    <p id="test2"></p>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>

<script>
    document.getElementById("query").addEventListener('keyup', function() {
        var query = document.getElementById("query").value
        loadDoc(query);
    }, false);

    function loadDoc() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                obj = JSON.parse(this.responseText);
                var options = "";
                for (i = 0; i < obj.cards.length; i++) {
                    options = options + "<option onmouseover=mOver(\""+ obj.cards[i].imageUrl+"\") value="+ JSON.stringify(obj.cards[i]) +">" + obj.cards[i].name + "-" + obj.cards[i].setName+"</option>";
                }
                document.getElementById("testselect").innerHTML = options;
                var tValue = document.getElementById("testselect").value;
                document.getElementById("testValue").innerHTML = options;

            }
        };
        var a = "https://api.magicthegathering.io/v1/cards?name=" + arguments[0]
        var b = a.concat(arguments[0])
        xhttp.open("GET", a, true);
        xhttp.send();
    }

    function mOver() {
        document.getElementById("myImage").src = arguments[0].toString();
        document.getElementById("test2").innerHTML = arguments[0].toString();
    }
</script>

</body>
</html>
