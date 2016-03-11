/**
 *
 * Created by lance on 2/15/16.
 */


function getSchedules() {
    $.ajax({
        url: "schedule_schedules",
        dataType: "json",
        data: {
            term: "2016-1"
        },
        success: function (data) {
            $.each(data.completeSchedules, function (idx, schedule) {
                $(".courses .off-canvas-submenu-call").each(function () {
                    if ($(this).attr("cid") == schedule.cid) {
                        var $teacher = $("<li><a href='#'>" + schedule.tname + " <i class='fa fa-close' tid='" + schedule.tid + "' cid='" + schedule.cid + "'></i></a></li>");
                        $(this).find(".nested.menu").append($teacher);
                    }
                });
            })
        },
        error: function () {
            alert("error");
        }
    });
}

$(function () {

    getSchedules();

    var $overlay = $(".overlay");
    var $dialogPanel = $(".dialog");

    $(".courses .add").click(function () {
        var csid = $(this).attr("csid");
        $.ajax({
            url: "schedule_teachers",
            dataType: "json",
            data: {
                csid: csid
            },
            success: function (data) {
                var $list = $dialogPanel.find("ul");
                $list.html("");
                $.each(data.teachers, function (idx, teacher) {
                    var $new_item = $("<li><input type='checkbox' name='teacherItem' id='" + teacher.tid + "'/>" +
                        "<label for='" + teacher.tid + "'>" + teacher.tname + "</label></li>");
                    $list.append($new_item);
                });
                $dialogPanel.attr("csid", csid);
                $overlay.show();
                $dialogPanel.show();
            },
            error: function () {
                alert("error");
            }
        });
    });

    $dialogPanel.find(".confirm").click(function () {
        var teachers = [];
        $dialogPanel.find("[name=teacherItem]:checkbox").each(function () {
            if (this.checked)
                teachers.push($(this).attr("id"));
        });

        if (teachers.length > 0) {
            $.ajax({
                url: "schedule_addTeacher",
                dataType: "json",
                data: {
                    tids: teachers,
                    csid: $dialogPanel.attr("csid")
                },
                traditional: true,
                success: function (data) {
                    $.each(data.teachers, function (idx, teacher) {
                        var $teacher = $("<li><a href='#'>" + teacher.tname + " <i class='fa fa-close' tid='" + teacher.tid + "' cid='" + data.cid + "'></i></a></li>");
                        $("a[csid=" + $dialogPanel.attr("csid") + "]").parent().parent().append($teacher);
                    });

                    $(".schedule-list tbody").html("");
                    $.each(data.completeSchedules, function (idx, schedule) {
                        var $new_row = $("<tr></tr>");
                        $new_row.append("<td data-columns='编号'>" + schedule.cid + "</td>");
                        $new_row.append("<td data-columns='课程名'>" + schedule.cname + "</td>");
                        $new_row.append("<td data-columns='学分'>" + schedule.credit + "</td>");
                        $new_row.append("<td data-columns='教师'>" + schedule.tname + "</td>");
                        $(".schedule-list tbody").append($new_row);
                    });

                    $dialogPanel.hide();
                    $overlay.hide();
                },
                error: function () {
                    alert("Error!");
                }
            });
        } else {
            $dialogPanel.hide();
            $overlay.hide();
        }
    });

    $("body").on("click", "i.fa-close", function () {
        var $item = $(this).parent().parent();
        $.ajax({
            url: "schedule_deleteTeacher",
            dataType: "json",
            data: {
                term: "2016-1",
                tid: $(this).attr("tid"),
                cid: $(this).attr("cid")
            },
            success: function (data) {
                $item.remove();
                $(".schedule-list tbody").html("");
                $.each(data.completeSchedules, function (idx, schedule) {
                    var $new_row = $("<tr></tr>");
                    $new_row.append("<td data-columns='编号'>" + schedule.cid + "</td>");
                    $new_row.append("<td data-columns='课程名'>" + schedule.cname + "</td>");
                    $new_row.append("<td data-columns='学分'>" + schedule.credit + "</td>");
                    $new_row.append("<td data-columns='教师'>" + schedule.tname + "</td>");
                    $(".schedule-list tbody").append($new_row);
                });

            },
            error: function () {
                alert("error");
            }
        });
    });

});
