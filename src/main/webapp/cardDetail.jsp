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
    <div class="row">
        <div class="col-*-*">
            <h3>${card.cardItem.getCardName()}</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <h3>${card.cardItem.getCardName()}</h3>
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-2">
                    <strong>Artist</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItem.getArtist()}</p>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Rarity</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItem.getRarity()}</p>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Type</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItem.getType()}</p>
                </div>

            </div>

            <div class="row">
                <div class="col-md-2">
                    <strong>Set Name</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItem.getSetName()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Mana Cost</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItem.getManaCost()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Layout</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItem.getLayout()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <strong>Price</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItem.getPriceString()}</p>
                </div>
            </div>

        </div>
    </div>

    <img src="images/LibraryofAlexandria.jpeg" alt="whale" class="fancy right"
     style="height: 500px; width: 400px;" />

<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>