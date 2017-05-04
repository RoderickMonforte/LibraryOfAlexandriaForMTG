<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<c:import url="head.jsp" />
<body>
<div id="wrap">
<c:import url="header.jsp" />
<c:import url="menu.jsp" />
<div id="content">
<h3>New User Entry Form</h3>

<div class="container-fluid">
    <div class="row" ${alert.hidden}>
        <div class="${alert.type}">
            ${alert.message}
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <img src="http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=990&type=card" alt="library" class="fancy left" style="height: 250px; width: 179px;" />
        </div>
        <div class="col-md-4">
            <form id="loginForm" action="addUser" method="post">
                <div class='form-group${alert.getField("UserIdName").fieldClass}'>
                    <label for="userID" class="control-label">User ID</label>
                    <input type="text" class="form-control col-sm-2" id="userID"
                           name="UserIDName" placeholder="Enter User ID" autocomplete="off"
                           value='${alert.getField("UserIdName").value}'>
                    ${alert.getField("UserIdName").spanString}
                </div>
                <div class='form-group${alert.getField("DisplayNameName").fieldClass}'>
                    <label for="displayName" class="control-label">Name</label>
                    <input type="text" class="form-control" id="displayName"
                           name="DisplayNameName" placeholder="Enter Name" autocomplete="off"
                           value='${alert.getField("DisplayNameName").value}'>
                    ${alert.getField("DisplayNameName").spanString}
                </div>
                <div class='form-group${alert.getField("PasswordText").fieldClass}'>
                    <label for = "passWord" class="control-label">Password</label>
                    <input type="password" class="form-control" id="passWord"
                           name="PasswordText" placeholder="Enter Password"
                           value='${alert.getField("PasswordText").value}'>
                    ${alert.getField("PasswordText").spanString}
                </div>
                <div class='form-group${alert.getField("RePasswordText").fieldClass}'>
                    <label for ="repassword" class="control-label">Re-type Password</label>
                    <input type="password" class="form-control" id="rePassWord"
                           name="RePasswordText" placeholder="Re-type Password"
                           value='${alert.getField("RePasswordText").value}'>
                    ${alert.getField("RePasswordText").spanString}
                </div>
                <div class="form-group">
                    <button type="submit" name="submit" value="Enter"
                            class="btn btn-primary">Enter</button>
                </div>
            </form>
        </div>
        <div class="col-md-4">
            <img src="http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=1651&type=card" alt="library" class="fancy right" style="height: 250px; width: 179px;" />
        </div>
    </div>
</div>
<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>