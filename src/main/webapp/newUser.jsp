<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
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
<h3>New User Entry Form</h3>

<div id="message">
    <p>${errorMessage}</p>
</div>

<div id="special">
    <form action="addUser" method="post">
        <p>
            <label for="userID">User ID</label>
            <input type="text" class="form-control" id="userID"
                   name="UserIDName"
                   placeholder="Enter User ID">
        </p>
        <p>
            <label for="displayName">Name</label>
            <input type="text" class="form-control" id="displayName"
                   name="DisplayNameName"
                   placeholder="Enter Name">
        </p>
        <p>
            <label for = "passWord">Password</label>
            <input type="password" class="form-control" id="passWord"
                   name="PasswordText"
                   placeholder="Enter Password">
        </p>
        <p>
            <label for ="repassword">Re-type Password</label>
            <input type="password" class="form-control" id="rePassWord"
                   name="RePasswordText"
                   placeholder="Re-type Password">
        </p>

        <tr><th><button type="submit" name="submit" value="Enter"
                class="btn btn-primary">Enter</button>
            </th>
        </tr>
    </form>

</div>
<c:import url="termsOfUse.jsp" />
</div>
</div>
<c:import url="footer.jsp" />
</body></html>