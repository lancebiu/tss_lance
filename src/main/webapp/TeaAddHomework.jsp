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

            <form action="upload" method="post" enctype="multipart/form-data">
            <h5><span>电子商务</span>/添加作业</h5>
            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp small-12">
                <input type="hidden" name="csid" value="<s:property value="csid"/>"/>
                <tbody>
                <tr>
                    <td>作业编号:</td>
                    <td style="text-align: left"><s:property value="hwNUm"/></td>
                </tr>
                <tr>
                    <td>截至时间</td>
                    <td style="text-align: left">
                        <input type="text" id="ddl" name="ddl"/>
                    </td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td style="text-align: left">
                        <textarea name="description" id="description" cols="30" rows="4"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>作业样例</td>
                    <td style="text-align: left">
                        <input type="file" name="myFile" id="myFile"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <input type="submit" value="提交" id="submit">
            </form>

        </div>
    </div>
</div>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
<script defer src="https://code.getmdl.io/1.1.1/material.min.js"></script>
</body>
</html>