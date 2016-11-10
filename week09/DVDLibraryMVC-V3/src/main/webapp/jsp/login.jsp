<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${param.login_error == 1}">
    <h3>Wrong id or password!</h3>
</c:if>

<form method="post" class="signin" action="j_spring_security_check">
    <fieldset>
        <table cellspacing="0">
            <tr>
                <th>
                    <label for="username">Username
                    </label>
                </th>

                <td><input id="username_or_email"
                           name="j_username"
                           type="text" />
                </td>
            </tr>
            <tr>
                <th><label for="password">Password</label></th>
                <td><input id="password"
                           name="j_password"
                           type="password" />
                </td>
            </tr>
            <tr>
                <th></th>
                <td><input name="commit" type="submit" value="Sign In" /></td>
            </tr>
        </table>
    </fieldset>
</form>