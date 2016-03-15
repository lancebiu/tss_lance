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
    <link rel="stylesheet" href="css/app.css">
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
            <li class="current"><a href="assist_getAsCourse"><i class="fa fa-calendar"></i><span>我的课程</span></a></li>
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

            <h5><span>电子商务</span>/学生作业列表</h5>
            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp small-12">

                <thead>
                <tr>
                    <th width="20%">学生编号</th>
                    <th width="20%">学生姓名</th>
                    <th width="30%">作业</th>
                    <th width="10%">评分</th>
                    <th width="20%">操作</th>
                </tr>

                </thead>
                <tbody>
                    <s:iterator value="homeworks">
                        <tr shid="<s:property value="shid"/>">
                            <td data-colomn="学号"><s:property value="uid"/></td>
                            <td data-colomn="学生姓名"><s:property value="uname"/></td>
                            <td data-colomn="作业"><a href="#" class="fa fa-file-pdf-o"><s:property value="fname"/></a></td>
                            <td data-colomn="助教评分" class="score"><input type="text" style="height: 1.5em;margin:0; font-size: 1em;"></td>
                            <td data-colomn="操作"><a href="#" class="submit">提交</a></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
<script defer src="https://code.getmdl.io/1.1.1/material.min.js"></script>
<script>
    $(".submit").click(function () {

        var $item = $(this).parent().parent();
        $.ajax({
            url: "assist2_examHomework",
            dataType: "json",
            data: {
                shid: $item.attr("shid"),
                score: $item.find(".score").find("input").val()
            },
            success: function (data) {
                alert("success");
            },
            error: function() {
                alert("error");
            }

        });
        return false;
    });
</script>
</body>
</html>