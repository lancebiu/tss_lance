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

            <div class="user-list">
                <h5 class="ttitle">学生列表</h5>

                <table class="stack">
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>院系</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="students">
                        <tr>
                            <td data-column="学号"><s:property value="uid"/></td>
                            <td data-column="公司"><s:property value="uname"/></td>
                            <td data-column="院系"><s:property value="department"/></td>
                            <td class="operate" data-column="操作"><a href="#" class="fa fa-close">删除</a><a href="#"
                                                                                                          class="fa fa-search">详情</a>
                            </td>
                        </tr>
                    </s:iterator>

                    </tbody>
                </table>

                <ul class="pagination" role="navigation" aria-label="Pagination">
                    <li>当前${page}/${totalPage}页</li>
                    <li class="pagination-first"><a href="admin_students">首页</a></li>
                    <s:if test="%{page == 1}">
                        <li class="pagination-previous"><a href="admin_students?page=${page-1}" aria-label="Previous page" class="disabled"> 上一页 </a></li>
                    </s:if>
                    <s:else>
                        <li class="pagination-previous"><a href="admin_students?page=${page-1}" aria-label="Previous page"> 上一页 </a></li>
                    </s:else>
                    <s:if test="%{page == totalPage}">
                        <li class="pagination-next"><a href="admin_students?page=${page+1}" aria-label="Next page" class="disabled"> 下一页 </a></li>
                    </s:if>
                    <s:else>
                        <li class="pagination-next"><a href="admin_students?page=${page+1}" aria-label="Next page"> 下一页 </a></li>
                    </s:else>
                    <li class="pagination-last"><a href="admin_students?page=${totalPage}"> 尾页 </a></li>
                </ul>
            </div>
        </div>
    </div>
</div>


<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
</body>
</html>
