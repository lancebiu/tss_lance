<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://code.getmdl.io/1.1.1/material.indigo-pink.min.css">
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>

<div class="container">
    <div class="fback">
        <div class="left"></div>
        <div class="right"></div>
    </div>

    <div class="formbox">
        <div class="toplam">
            <div class="left">
                <div class="form-container">
                    <p class="title">Sign Up</p>
                    <form action="#">

                        <div class="form-group">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="rUsername">
                                <label class="mdl-textfield__label" for="rUsername">Username</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="password" id="rPassword">
                                <label class="mdl-textfield__label" for="rPassword">Password</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="rEmail">
                                <label class="mdl-textfield__label" for="rEmail">Email</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">
                                Sign up
                            </button>
                            <button class="mdl-button mdl-js-button toggle">
                                Login
                            </button>
                        </div>

                    </form>
                </div>
            </div>
            <div class="right">
                <div class="form-container">
                    <p class="title">Login</p>
                    <form action="#">

                        <div class="form-group">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="username">
                                <label class="mdl-textfield__label" for="username">Username</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="password" id="password">
                                <label class="mdl-textfield__label" for="password">Password</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored" id="login">
                                Login
                            </button>
                            <button class="mdl-button mdl-js-button toggle">
                                Sign up
                            </button>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>

</div>

<script defer src="https://code.getmdl.io/1.1.1/material.min.js"></script>
<script src="./js/jquery-2.1.4.min.js"></script>
<script>
    $(".toggle").click(function () {
        var $formbox = $(".formbox");
        if ($formbox.is(".toggle")) {
            $formbox.removeClass("toggle");
        }else {
            $formbox.addClass("toggle");
        }
        return false;
    });

    $("#login").click(function () {
        console.log("here");
        window.location = "admin_checkUser?uid="+$("#username").val()+"&password="+$("#password").val();
        return false;
    });
</script>

</body>
</html>