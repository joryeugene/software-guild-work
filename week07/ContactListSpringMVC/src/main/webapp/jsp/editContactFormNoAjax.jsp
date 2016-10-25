<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Company Contacts</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search/">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayContactListNoAjax">Contact List (No Ajax)</a></li>
                </ul>    
            </div>
            <h2>Edit Contact</h2>

            <!-- #1 - Link to displayContactListNoAjax -->
            <a href="displayContactListNoAjax">Back - Contact List (No Ajax)</a><br>
            <hr>

            <sf:form class="form-horizontal" role="form" modelAttribute="contact"
                     action="editContactNoAjax" method="POST">
                <div class="form-group">
                    <label for="edit-first-name" class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="edit-first-name"
                                  path="firstName" placeholder="${contact.firstName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit-last-name" class="col-md-4 control-label">Last Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="edit-last-name"
                                  path="lastName" placeholder="${contact.lastName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit-company" class="col-md-4 control-label">Company:</label>

                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="edit-company"
                                  path="company" placeholder="${contact.company}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit-email" class="col-md-4 control-label">Email:</label>
                    <div class="col-md-8">
                        <sf:input type="email" class="form-control" id="edit-email"
                                  path="email" placeholder="${contact.email}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit-phone" class="col-md-4 control-label">Phone:</label>
                    <div class="col-md-8">
                        <sf:input type="tel" class="form-control" id="edit-phone"
                                  path="phone" placeholder="${contact.phone}"/>
                        <sf:hidden path="contactId"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit" id="edit-button" class="btn btn-default">Update Contact</button>
                    </div>
                </div>
            </sf:form>

        </div>



        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

