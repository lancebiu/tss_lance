/**
 * Created by lance on 2/15/16.
 */


function getSchedules(droppable) {
    $.ajax({
        url: "schedule_list",
        dataType: 'json',
        data: {
            term: $("#year").val() + "-" + $("#term").val()
        },
        success: function (data) {

            droppable.find("tbody").html("");
            $.each(data.courses, function (idx, course) {
                var $new_item = $("<tr csid='"+(data.schedules)[idx].csid+"'></tr>");
                $new_item.append("<td data-column='编号'>" + course.cid + "</td>");
                $new_item.append("<td data-column='名称'>" + course.cname + "</td>");
                $new_item.append("<td data-column='学分'>" + course.credit + "</td>");
                $new_item.append("<td data-column='操作'><a href='#' class='fa fa-close'>删除</a></td>");
                droppable.find("tbody").append($new_item);
            });

        },
        error: function () {
            alert("error");
        }
    });
}

// draggable list

$(function () {

    var hasExist = false;

    var $draggable_list = $(".draggable-list");
    var $droppable = $(".droppable");
    var $draggable_item = $draggable_list.find("li");
    $draggable_item.attr("draggable", "true");

    $draggable_item.bind("dragstart", function (event) {
        hasExist = false;
        $(this).addClass("dragged");
        event.originalEvent.dataTransfer.setData('text', $(this).html());
    });

    $droppable.bind("dragover", function (event) {
        event.preventDefault();
    }).bind("drop", function (event) {
        if ($(this).hasClass("disabled"))
            return false;

        var $tmp_item = $("<li></li>");
        $tmp_item.html(event.originalEvent.dataTransfer.getData("text"));

        var $course_id = $tmp_item.find(".course-id").text();

        $(this).find("tbody tr td[data-column='编号']").each(function () {
            if ($(this).text() === $course_id) {
                alert("该课程已存在");
                hasExist = true;
            }
        });

        if (!hasExist) {

            $.ajax({
                url: "schedule_add",
                dataType: 'json',
                data: {
                    cid: $course_id,
                    term: $("#year").val() + "-" + $("#term").val()
                },
                success: function (data) {
                    var $new_item = $("<tr csid='"+data.csid+"'></tr>");
                    $new_item.append("<td data-column='编号'>" + $course_id + "</td>");
                    $new_item.append("<td data-column='名称'>" + $tmp_item.find(".course-name").text() + "</td>");
                    $new_item.append("<td data-column='学分'>" + $tmp_item.find(".course-credit").text() + "</td>");
                    $new_item.append("<td data-column='操作'><a href='#' class='fa fa-close'>删除</a></td>");
                    $droppable.find("tbody").append($new_item);
                },
                error: function () {
                    alert("error!");
                }
            });

        }
    });



    $("body").on("click", "a.fa-close" , function () {

        if($droppable.hasClass("disabled")) {
            return false;
        }else {
            $item = $(this).parent().parent();

            $.ajax({
                url : "schedule_delete",
                dataType : "json",
                data : {
                    csid : $item.attr("csid")
                },
                success : function (data) {
                    $item.remove();
                },
                error : function () {
                    alert("该课程已指派教学计划，无法删除!");
                }
            });

        }
    });



    getSchedules($droppable);

    $(".search-box").find("select").change(function () {
        if($("#year").val() != '2016' || $("#term").val() != '1'){
            $droppable.addClass("disabled");
        }else {
            $droppable.removeClass("disabled");
        }
        getSchedules($droppable);
    });

});

