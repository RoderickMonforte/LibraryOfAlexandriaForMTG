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
    <%--first row heading card name--%>
    <div class="row">
        <div class="col-*-*">
            <h3>${collection.displayName}</h3> <br>
            <h2>${card.cardItemById.cardName}</h2>
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
    <%--third row details--%>
    <div class="row">
        <div class="col-md-6">
            <img src="${card.cardItemById.imageUrl}" alt="${card.cardItemById.cardName}" class="fancy right"
                 style="height: 400px; width: 320px;" />
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-2">
                    <strong>Artist</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItemById.getArtist()}</p>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Rarity</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItemById.getRarity()}</p>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Type</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItemById.getType()}</p>
                </div>

            </div>

            <div class="row">
                <div class="col-md-2">
                    <strong>Set Name</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItemById.getSetName()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Mana Cost</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItemById.getManaCost()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Layout</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItemById.getLayout()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Price</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItemById.getPriceString()}</p>
                </div>
            </div>

        </div>
    </div>

<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>