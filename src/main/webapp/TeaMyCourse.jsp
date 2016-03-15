<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foundation for Sites</title>
    <link rel="stylesheet" href="https://code.getmdl.io/1.1.1/material.indigo-pink.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <link rel="stylesheet" href="css/client.css">
</head>
<body>

<div class="main-body">

    <!-- off canves menu -->
    <aside class="left-side-bar">
        <ul class="off-canvas-menu vertical menu" data-accordion-menu>
            <li class="list-title">
                <img src="./images/logo.png" alt="icon"/>
                <label>TSS</label>
            </li>

            <li class="current"><a href="teacher_findMyCourse"><i class="fa fa-calendar"></i><span>我的课程</span></a></li>
        </ul>
    </aside>

    <!-- main content -->
    <div class="main-content">

        <!-- top bar -->
        <div class="top-bar">
            <div class="top-bar-left">
                <a href="#" class="to-menu fa fa-bars"></a>
            </div>
            <div class="top-bar-right hide-for-small-only">
                <a href="#" class="top-user-info">你好，<span>罗会祥</span></a>
                <div class="profile-panel">
                    <ul>
                        <li><a href="#">注销</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- content -->
        <div class="content row">

            <div class="mdl-card mdl-shadow--2dp small-12">

                <div class="mdl-card__title">
                    <h5 class="title">我的课程/<span>2016年第一学期</span></h5>
                </div>

                <table class="mdl-data-table mdl-js-data-table small-12">
                    <thead>
                    <tr>
                        <th width="23%">课程编号</th>
                        <th width="23%">课程名</th>
                        <th width="23%">学分</th>
                        <th width="23%">学生数</th>
                    </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="courses" status="status">
                            <tr>
                                <td data-column="课程编号"><s:property value="cid"/></td>
                                <td data-column="课程名"><a href="teacher_addAss?csid=<s:property value="csid"/>&cid=<s:property value="cid"/>&cname=<s:property value="cname"/>"><s:property value="cname"/></a></td>
                                <td data-column="学分"><s:property value="credit"/></td>
                                <td data-column="学生数">${stuNumsPerCourse[status.index]}</td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
<script defer src="https://code.getmdl.io/1.1.1/material.min.js"></script>
</body>
</html>
