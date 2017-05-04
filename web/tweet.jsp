<%@ page import="main.Tweet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: david_szilagyi
  Date: 2017.05.03.
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TweetCool</title>
</head>
<body>
<div>
    <div>
        <form action="tweet" method="post">
            Name: <br> <input type="text" name="poster" value="${cookie['username'].value}">
            <br> Message: <br> <input type="text" name="content">
            <input type="submit" value="Send">
        </form>
    </div>
    <div>
        <form action="tweet" method="get">
            Name Filter: <br> <input type="text" name="user" value="">
            <br> Message Limit: <br> <input type="text" name="limit" value="10">
            <br> Start from: <br> <input type="text" name="offset" value="0">
            <input type="submit" value="Refresh">
        </form>
    </div>
    <br>
    <div>
        <hr>
        <%
            List<Tweet> tweets = (List<Tweet>) request.getAttribute("filtered");
            if (tweets != null) {
                for (Tweet p : tweets) {
                    out.print(p.toString() + "<br>");
                }
            }
        %>
        <hr>
    </div>
</div>
</body>
</html>