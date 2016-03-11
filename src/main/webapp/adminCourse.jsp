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
            <li class="current"><a href="admin_courses"><i class="fa fa-book"></i><span>课程管理</span></a></li>
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

            <div class="row">

                <div class="column small-8">

                    <div class="course-list droppable">
                        <h5 class="ttitle">本学期课程列表</h5>

                        <div class="search-box">
                            <select name="year" id="year">
                                <option value="2015">2015年</option>
                                <option value="2016" selected>2016年</option>
                            </select>
                            <select name="term" id="term">
                                <option value="1">第一学期</option>
                                <option value="2">第二学期</option>
                            </select>
                        </div>

                        <table class="stack">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>名称</th>
                                <th>学分</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div>

                <div class="column small-3 small-offset-1 all-course">
                    <h4 class="title">所有课程</h4>

                    <input type="text" id='course-field' placeholder="输入课程名">

                    <ul class="draggable-list">
                        <s:iterator value="courses">
                            <li><span class="course-id">${cid}</span>
                                <span class="course-credit">${credit}</span>
                                <span class="course-name">${cname}</span></li>
                        </s:iterator>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>


<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
<script src="js/adminCourse.js"></script>
</body>
</html>
