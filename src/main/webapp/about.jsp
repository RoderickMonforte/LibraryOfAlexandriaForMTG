<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />


<body>
<div id="wrap">
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<div id="content">
    <div class="row">
        <h3>Welcome to Library of Alexandria</h3>
    </div>
    <div class="row">
        <div class="col-md-3">
            <img src="images/LibraryofAlexandria.jpeg" alt="library" class="fancy left"
                 style="height: 250px; width: 179px;" />
        </div>
        <div class="col-md-9">
            <div class="row">
                <p>This is a simple cataloging application built for storing Magic the
                    Gathering Cards. This uses web service to get prices and other attributes
                    of the card.
                </p>
            </div>
            <div class="row alert alert-info">
                <p>Problem Statement</p>
            </div>
            <div class="row">
                <p>"Magic: The Gathering (MTG; also known as Magic) is a trading card game
                    created by Richard Garfield. First published in 1993 by Wizards of the Coast,
                    Magic was the first trading card game produced and it continues to thrive,
                    with approximately twenty million players as of 2015." -- Wikipedia
                </p>
                <p>
                    Millions of players/collectors have accumulated cards over 24 years
                    with
                    varying
                    degree of value that begs a library to hold and organize them. Key features
                    will be the ability to enter, search, update, delete and categorized cards
                    in a personal
                    collection. Estimate price valuation will be given to each card and
                    collection as additional information.

                </p>
            </div>
        </div>
    </div>
<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>