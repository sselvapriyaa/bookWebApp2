<%-- 
    Document   : authorList
    Created on : Sep 26, 2016, 1:43:27 PM
    Author     : Gladwin
--%>


<!DOCTYPE html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="edu.wctc.saa.bookwebapp.model.Author" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Authors</title>
        <link rel='stylesheet' type='text/css' href='styles.css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Results!</h1>
     
       <div class ="container">         
        <table style = "width:500px;" class = "table table-striped table-hover table-condensed">
            <tr style = "background-color:black;color:white;">
                <th align ="left" class ="tableHead">Author Name</th>
                <th align ="left" class ="tableHead">Author Id</th>
                <th align ="right" class ="tableHead">Date Added</th>
            </tr>

            <c:forEach items="${authorList}" var="author" begin="0" end="${endOfList}">
                <tr>
                    <td align = "left">
                        <c:out value="${author.getAuthorName()}"/>
                    </td>
                    <td align = "left">
                        <c:out value="${author.getAuthorId()}"/>
                    </td>
                    <td align = "right">
                <C:out value="${author.getDateAdded()}"/>
            </td>
        </tr>
    </c:forEach>
</table>
       </div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
           </script>

</body>
</html>
