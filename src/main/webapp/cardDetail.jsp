<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />


<body>
<div id="wrap">
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<div id="content">
    <%--first row heading card name--%>
    <div class="row">
        <div class="col-*-*">
            <h3>${collection.displayName} Collection</h3>
            <h2 style="text-align : center">${card.cardItemById.cardName}</h2>
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
        <div class="col-md-5">
            <div class="row">
                <img src="${card.cardItemById.imageUrl}" alt="${card.cardItemById.cardName}" class="fancy left"
                     style="height: 400px; width: 286px;" />
            </div>
            <div class="row">
                <br>
                <form method="get" action="setUpCardLocal">
                    <input type="submit" class="btn btn-primary" value="Back to Card List" >
                </form>
            </div>
        </div>
        <div class="col-md-7">
            <div class="row">
                <div class="col-md-3">
                    <strong>Artist</strong>
                </div>
                <div class="col-md-9">
                    <p>${card.cardItemById.getArtist()}</p>
                </div>

            </div>
            <div class="row">
                <div class="col-md-3">
                    <strong>Rarity</strong>
                </div>
                <div class="col-md-9">
                    <p>${card.cardItemById.getRarity()}</p>
                </div>

            </div>
            <div class="row">
                <div class="col-md-3">
                    <strong>Type</strong>
                </div>
                <div class="col-md-9">
                    <p>${card.cardItemById.getType()}</p>
                </div>

            </div>

            <div class="row">
                <div class="col-md-3">
                    <strong>Set Name</strong>
                </div>
                <div class="col-md-9">
                    <p>${card.cardItemById.getSetName()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <strong>Mana Cost</strong>
                </div>
                <div class="col-md-9">
                    <p>${card.cardItemById.getManaCost()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <strong>Layout</strong>
                </div>
                <div class="col-md-9">
                    <p>${card.cardItemById.getLayout()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <strong>Price</strong>
                </div>
                <div class="col-md-4">
                    <p>${card.cardItemById.priceString}</p>
                </div>
                <div class="col-md-5">
                    <form method="get" action="updatePrice">
                        <input type="number" min="0" id="multiverseId" name="MultiverseId"  value=${card.cardItemById.multiverseId} hidden/>
                        <input type="submit" class="btn btn-primary" value="Update Price" >
                    </form>
                </div>
            </div>
            <hr>
            <div class="row">
                <form method="get" action="updateCard">
                    <div class="row">
                        <div class="col-md-6">
                            <input type="number" min="0" id="cardId" name="CardId"  value=${card.cardId} hidden/>
                            <div class="form-group">
                                <label for="ownedCount" >Owned Quantity</label>
                                <input type="number" min="0" id="ownedCount" name="OwnedCount" class="form-control" value=${card.ownedQuantityString} required/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="wishCount" >Wish Count</label>
                                <input type="number" min="0" id="wishCount" name="WishCount" class="form-control" value=${card.wishListString} required/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="noteText" >Note Text</label>
                                <textarea id="noteText" name="NoteText" class="form-control" rows="4" cols="20" placeholder="notes about this card">${card.noteText}</textarea>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <input type="submit" class="btn btn-primary" value="Update" >
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>

<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>