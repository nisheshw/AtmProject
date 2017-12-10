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
        <script src="${pageContext.request.contextPath}/static/js/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>

        <div id="map" style="height:550px; width:1300px;"></div>
        <script>
            function initMap() {
                var uluru = {lat: 27.7172, lng: 85.3240};
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 4,
                    center: uluru
                });
                var marker = new google.maps.Marker({
                    position: uluru,
                    map: map
                });
            }
        </script>

        <ul>
            <c:forEach var="atm" items="${atm}">
                <li>ATM ID: ${atm.id}</li>
                <li>Serial No: ${atm.serialNo}</li>
                <li>Location: ${atm.location}</li>
                <li>Longitude: ${atm.longitude}</li>
                <li>Latitude: ${atm.latitude}</li><br/>
                </c:forEach>
        </ul>

        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAckg_UEZIijm41WabFgrNs0_0q1ng4jLE&callback=initMap">
        </script>
    </body>
</html>
