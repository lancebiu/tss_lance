$(document).foundation();

// off-canvas
$(function () {
    $(".off-canvas-submenu-call>a").click(function () {
        var angle_class = $(this).siblings(".nested.menu").is(':visible') ? 'fa-angle-right' : 'fa-angle-down';
        var icon = $(this).find(".right");

        icon.removeClass("fa-angle-down");
        icon.removeClass("fa-angle-right");
        icon.addClass(angle_class);
    });

    $(".to-menu").click(function () {

        if ($(window).width() <= 640) {
            // small
            var $main_content = $(".main-content");
            if (($main_content).css("left") !== "0px") {
                $main_content.css({"left": "0"});
            } else {
                $main_content.css({"left": "-15rem"});
            }
        } else if ($(window).width <= 1024) {
            // medium
        } else {
            // large
            var sidebar = $(".main-body");
            if (sidebar.hasClass("icon-only")) {
                sidebar.removeClass("icon-only");
            } else {
                sidebar.addClass("icon-only");
            }
        }

    });

    $(".top-user-info").click(function () {
        var $profile_panel = $(".profile-panel");
        if ($profile_panel.is(":hidden")) {
            $profile_panel.show();
        }else {
            $profile_panel.hide();
        }
    });

    $(".pagination .disabled").click(function () {
        return false;
    });

});


