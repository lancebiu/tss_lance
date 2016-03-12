<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foundation for Sites</title>
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <link rel="stylesheet" href="css/app.css">
</head>
<body>

<div class="main-body">

    <!-- off canves menu -->
    <aside class="left-side-bar">
        <ul class="off-canvas-menu vertical menu" data-accordion-menu>
            <li class="list-title">
                <img src="img/logo.png" alt="icon"/>
                <label>TSS</label>
            </li>
            <li class="off-canvas-submenu-call current">
                <a href="#"><i class="fa fa-user"></i><span>用户管理</span><span
                        class="right fa fa-angle-right"></span></a>

                <ul class="menu vertical nested is-active">
                    <li class="current"><a href="admin_students">学生管理</a></li>
                    <li><a href="admin_teachers">教师管理</a></li>
                </ul>
            </li>
            <li><a href="admin_courses"><i class="fa fa-book"></i><span>课程管理</span></a></li>
            <li><a href="admin_schedules"><i class="fa fa-calendar"></i><span>教学计划</span></a></li>
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
                <a href="#" class="top-user-info"><img src="img/head.jpg" alt="head"/>你好，<span>管理员</span></a>
                <div class="profile-panel">
                    <ul>
                        <li><a href="#">注销</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- content -->
        <div class="content">

            <div class="info-title">
                <h3>学生详情</h3>
                <a href="#" class="action">修改</a>
            </div>
            <hr>
            <ul class="pf-items">
                <li>
                    <h4 class="pf-item-title">学号</h4>

                    <p class="pf-item-value"><s:property value="studentEntity.uid" /></p>
                    <input type="text" value="<s:property value="studentEntity.uid" />" class="pf-item-editable" disabled="disabled">
                </li>
                <li class="name">
                    <h4 class="pf-item-title">姓名</h4>

                    <p class="pf-item-value"><s:property value="studentEntity.uname" /></p>
                    <input type="text" value="<s:property value="studentEntity.uname" />" class="pf-item-editable">
                </li>
                <li class="department">
                    <h4 class="pf-item-title">院系</h4>

                    <p class="pf-item-value"><s:property value="studentEntity.department" /></p>
                    <input type="text" value="<s:property value="studentEntity.department" />" class="pf-item-editable">
                </li>
            </ul>

        </div>
    </div>
</div>


<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
<script>
    $(".action").click(function () {
        if ($(this).html() === '修改') {
            $(this).html("完成");
            $(".pf-item-value").hide();
            $(".pf-item-editable").show();
        } else {

            var $that = $(this);
            $.ajax({
                url: "admin2_updateStudent",
                dataType: 'json',
                data: {
                    uname: $(".name").find("input").val(),
                    department: $(".department").find("input").val()
                },
                success: function(data) {
                    $that.html("修改");
                    $(".name").find(".pf-item-value").text($(".name").find("input").val());
                    $(".department").find(".pf-item-value").text($(".department").find("input").val());
                    $(".pf-item-value").show();
                    $(".pf-item-editable").hide();
                },
                error: function() {
                    alert("error!");
                }
            });
        }
    });
</script>
</body>
</html>
