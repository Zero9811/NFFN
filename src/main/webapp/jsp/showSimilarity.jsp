<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/6/1
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:iterator value="#request.similar_list" var="sl">
    <tr>
        <td><s:property value="#sl.username"></s:property></td>
        <br/>
        <td><a>加为好友</a></td>
    </tr>
    <br>
</s:iterator>
</body>
</html>
