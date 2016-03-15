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
                <img src="./img/logo.png" alt="icon"/>
                <label>TSS</label>
            </li>
            <li class="off-canvas-submenu-call current">
                <a href="#"><i class="fa fa-book"></i><span>我的课程</span><span
                        class="right fa fa-angle-right"></span></a>

                <ul class="menu vertical nested">
                    <li><a href="student_myCourse?term=2016-1">2016年第一学期</a></li>
                    <li><a href="student_myCourse?term=2015-2">2015年第二学期</a></li>
                    <li><a href="student_myCourse?term=2015-1">2015年第一学期</a></li>
                </ul>
            </li>
            <li><a href="student_allCourse"><i class="fa fa-calendar"></i><span>学期选课</span></a></li>
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


            <h5><span><s:property value="cname"/></span>/课程作业</h5>
            <s:iterator value="homeworks">
            <form action="upload2" method="post" enctype="multipart/form-data">
            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp small-12">
                <tbody>
                <tr>
                    <td>作业编号:</td>
                    <td style="text-align: left"><s:property value="hid"/></td>
                    <input type="hidden" name="hid" value="<s:property value="hid"/>"/>
                </tr>
                <tr>
                    <td>截至时间</td>
                    <td style="text-align: left"><s:property value="deadline"/></td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td style="text-align: left"><s:property value="description"/></td>
                </tr>
                <tr>
                    <td>作业样例</td>
                    <td style="text-align: left"><a href="#" class="fa fa-file-pdf-o" style="color: black;"><s:property value="efname"/></a></td>
                </tr>
                <tr>
                    <td>你的作业</td>
                    <td style="text-align: left">
                        <input type="file" name="myFile" id="myFile" style="width: 30%;">
                        <input type="submit" id="submit" value="提交">
                    </td>
                </tr>
                <tr>
                    <td>作业评分</td>
                    <td style="text-align: left"><s:property value="score"/></td>
                </tr>
                </tbody>
            </table>
            </form>
            </s:iterator>
        </div>
    </div>
</div>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
<script defer src="https://code.getmdl.io/1.1.1/material.min.js"></script>
</body>
</html>