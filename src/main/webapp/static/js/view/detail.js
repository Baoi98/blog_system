$("#commentButton").click(function () {
    if ($("#content").val() == '' && $("#name").val() == '' && $("#email").val() == '') {
        $("#info").text("提示:请输入评论内容,昵称和邮箱");
    } else if ($("#content").val() == '') {
        $("#info").text("提示:请输入评论内容");
    } else if ($("#name").val() == '') {
        $("#info").text("提示:请输入昵称");
    } else if ($("#email").val() == '') {
        $("#info").text("提示:请输入邮箱");
    } else {
        $("#info").text("");
        $.ajax({
            type: "POST",
            url: "/api/comment/add",
            data: {
                content: $("#content").val(),
                name: $("#name").val(),
                email: $("#email").val(),
                articleId: $("#articleId").val(),
            },
            dataType: "json",
            success: function (data) {
                if (data.stateCode.trim() == "1") {
                    $("#info").text("评论成功,跳转中...");
                    window.location.reload();
                } else {
                    $("#info").text("评论失败...");
                }
            }
        });
    }
})