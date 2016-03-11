<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TSS Admin</title>
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
            <li class="off-canvas-submenu-call">
                <a href="#"><i class="fa fa-user"></i><span>用户管理</span><span
                        class="right fa fa-angle-right"></span></a>

                <ul class="menu vertical nested">
                    <li><a href="admin_students">学生管理</a></li>
                    <li><a href="admin_teachers">教师管理</a></li>
                </ul>
            </li>
            <li><a href="admin_courses"><i class="fa fa-book"></i><span>课程管理</span></a></li>
            <li class="current"><a href="admin_schedules"><i class="fa fa-calendar"></i><span>教学计划</span></a></li>
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
                <a href="#" class="top-user-info"><img src="img/head.jpg" alt="head"/>你好，<span>管理员</span> </a>

                <div class="profile-panel">
                    <ul>
                        <li><a href="#">注销</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- content -->
        <div class="content">
            <div class="row">
                <div class="column small-3 courses">
                    <h4 class="title">本学期课程</h4>

                    <ul class="off-canvas-menu vertical menu" data-accordion-menu>
                        <s:iterator value="courses" status="statu">
                            <li class="off-canvas-submenu-call" cid="${cid}">
                                <a href="#">
                                    <span class="course-credit">${credit}</span>
                                    <span class="course-name">${cname}</span>
                                    <span class="right fa fa-angle-right"></span>
                                </a>

                                <ul class="menu vertical nested">
                                    <li><a href="#" class="add fa fa-plus-circle" csid="${schedules[statu.index].csid}">分配教师</a>
                                    </li>
                                </ul>
                            </li>
                        </s:iterator>
                    </ul>

                </div>

                <div class="column small-8 small-offset-1">

                    <div class="schedule-list">
                        <h5 class="ttitle">本学期教学计划</h5>

                        <table class="stack">
                            <thead>
                            <tr>
                                <th>课程编号</th>
                                <th>课程名</th>
                                <th>学分</th>
                                <th>教师</th>
                            </tr>
                            </thead>
                            <tbody>

                            <s:iterator value="completeSchedules">
                                <tr>
                                    <td data-columns="课程编号">${cid}</td>
                                    <td data-columns="课程名">${cname}</td>
                                    <td data-columns="学分">${credit}</td>
                                    <td data-columns="教师">${tname}</td>
                                </tr>
                            </s:iterator>

                            </tbody>
                        </table>
                    </div>
                </div>

            </div>

        </div>
    </div>

    <div class="overlay"></div>
    <div class="dialog teacher-list">
        <h4 class="title">教师名单</h4>
        <ul></ul>
        <a href="#" class="confirm">确定</a>
    </div>

</div>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
<script src="js/adminSchedule.js"></script>
</body>
</html>

