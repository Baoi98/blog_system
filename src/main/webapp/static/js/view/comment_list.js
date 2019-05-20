function ifdelete(id) {
    layer.confirm('确定删除该评论吗?', {
        btn: ['确定','取消'] //按钮
    }, function(){
        $.ajax({
            type: 'POST',
            url: '/api/comment/del',
            datatype:'json',
            data:{"id":id},
            success: function(data){
                if(data['stateCode']==1){
                    layer.msg('删除成功!',{icon:1,time:1000});
                    setTimeout("window.location.reload()",1000);
                }
                else {
                    layer.msg('删除失败!',{icon:5,time:1000});
                }
            },
            error:function(data) {
                console.log('错误...');
            },
        });
    }, function(){

    });
}