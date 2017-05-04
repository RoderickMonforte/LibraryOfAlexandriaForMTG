<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<c:import url="head.jsp" />


<body>
<div id="wrap">
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<div id="content">
<div class="container-fluid">
    <div class="row">
        <h3>Please login to continue...</h3>
    </div>
    <div class="row">
        <div class="col-md-3">
            <img src="images/LibraryofAlexandria.jpeg" alt="whale" class="fancy left"
                 style="height: 250px; width: 179px;" />
        </div>
        <div class="col-md-6">
            <div class="row">
                <p>This is a simple MTG cards cataloging application. You can add a
                    collection and then add cards to a collection. Current price of cards are
                    given.
                </p>
            </div>
            <div class="row">
                <FORM ACTION="j_security_check" METHOD="POST" class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-md-3" for="UserName">User name:</label>
                        <div class="col-md-9">
                            <INPUT class="form-control" TYPE="TEXT" NAME="j_username" id="UserName" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3" for="Password">Password:</label>
                        <div class="col-md-9">
                            <INPUT class="form-control" TYPE="PASSWORD" NAME="j_password" id="Password">
                        </div>
                    </div>
                    <div class="form-group" style="text-align:right">
                        <INPUT class="btn btn-primary" TYPE="SUBMIT" VALUE="Log In">
                    </div>
                </FORM>
            </div>
        </div>
    </div>
</div>
<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>