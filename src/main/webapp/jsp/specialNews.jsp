<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/5/25
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="resources/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resources/lib/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="resources/lib/css/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="resources/lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="resources/lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="resources/lib/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="resources/lib/css/select2.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="resources/css/themes/flat-blue.css">
</head>
<body>

<div class="container-fluid">

这是查询到的新闻
<s:iterator value="#request.news_list" var="nl">
    <tr>
        <td><s:property value="#nl.title"></s:property></td>
        <br/>
        <td><s:property value="#nl.author"></s:property></td>
        <br/>
        <td><s:property value="#nl.description"></s:property></td>
        <td><a href="<s:property value="#nl.url"/>">阅读原文</a></td>
        <br/>
        <td>平台：<s:property value="#nl.platform"></s:property></td>
        <td><s:property value="#nl.date"></s:property></td>
    </tr>
    <br>
</s:iterator>
<div class="row">
    <div class="side-body">
    <div class="col-xs-12">
        <div class="card">
            <div class="card-header">
                <div class="card-title">
                    <div class="title">新闻标题</div>
                </div>
                <div class="pull-right card-action">
                    <div class="btn-group" role="group" aria-label="...">
                        <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalCardExample"><i class="fa fa-code"></i></button>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <div class="text-indent">
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
                    新闻的概要描述
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<script type="text/javascript" src="resources/lib/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/lib/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/lib/js/Chart.min.js"></script>
<script type="text/javascript" src="resources/lib/js/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="resources/lib/js/jquery.matchHeight-min.js"></script>
<script type="text/javascript" src="resources/lib/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="resources/lib/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="resources/lib/js/select2.full.min.js"></script>
<script type="text/javascript" src="resources/lib/js/ace/ace.js"></script>
<script type="text/javascript" src="resources/lib/js/ace/mode-html.js"></script>
<script type="text/javascript" src="resources/lib/js/ace/theme-github.js"></script>
<!-- Javascript -->
<script type="text/javascript" src="resources/js/app.js"></script>
<script type="text/javascript" src="resources/js/index.js"></script>
</body>
</html>
