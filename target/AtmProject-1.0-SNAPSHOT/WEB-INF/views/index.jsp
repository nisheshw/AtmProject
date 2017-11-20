<%-- 
    Document   : index
    Created on : Nov 16, 2017, 12:08:41 PM
    Author     : Prachin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <c:forEach var="atm" items="${atm}">
                <li>ATM ID: ${atm.id}</li>
                <li>Serial No: ${atm.serialNo}</li>
                <li>Location: ${atm.location}</li>
                <li>Longitude: ${atm.longitude}</li>
                <li>Latitude: ${atm.latitude}</li><br/>
                </c:forEach>

           
        </ul>
    </body>
</html>
