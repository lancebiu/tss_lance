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
            <li class="off-canvas-submenu-call">
                <a href="#"><i class="fa fa-book"></i><span>我的课程</span><span
                        class="right fa fa-angle-right"></span></a>

                <ul class="menu vertical nested">
                    <li><a href="student_myCourse?term=2016-1">2016年第一学期</a></li>
                    <li><a href="student_myCourse?term=2015-2">2015年第二学期</a></li>
                    <li><a href="student_myCourse?term=2015-1">2015年第一学期</a></li>
                </ul>
            </li>
            <li class="current"><a href="student_allCourse"><i class="fa fa-calendar"></i><span>学期选课</span></a></li>
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
                    <h5 class="title">学期选课/<span>2016年第一学期</span></h5>
                </div>

                <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable small-12">
                    <thead>
                    <tr>
                        <th width="23%">课程编号</th>
                        <th width="23%">课程名</th>
                        <th width="23%">授课教师</th>
                        <th width="23%">学分</th>
                    </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="courses">
                            <tr csid="<s:property value="csid"/>">
                                <td data-column="课程编号"><s:property value="cid"/></td>
                                <td data-column="课程名"><s:property value="cname"/></td>
                                <td data-column="授课教师"><s:property value="tname"/></td>
                                <td data-column="学分"><s:property value="credit"/></td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>

                <div class="mdl-card__actions">
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored" style="float: right" id="upload">
                        提交
                    </button>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="js/jquery-2.1.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/foundation/6.1.2/foundation.min.js"></script>
<script src="js/app.js"></script>
<script defer src="https://code.getmdl.io/1.1.1/material.min.js"></script>
<script>

    $("#upload").click(function () {
        var courses = [];
        $("tbody").find("input:checkbox").each(function () {
           if(this.checked) {
               courses.push($(this).parent().parent().parent().attr("csid"));
           }
        });
        console.log(courses);
        if(courses.length > 0) {
            $.ajax({
                url: "student2_selectCourse",
                dataType: 'json',
                traditional: true,
                data: {
                    csids: courses,
                    uid: "131250114"
                },
                success: function (data) {

                },
                error: function () {
                    console.log("error");
                }
            });
        }

    });

</script>
</body>
</html>
