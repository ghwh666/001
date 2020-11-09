var baseAjax =     {
    type: 'POST',
    dataType: 'json',
    contentType:'application/json;charset=UTF-8',
    async:false,
    error:function(data) {
        alter("error:"+data);
    }
};
function ajaxSubmit(url, data, returnFun)
{
    baseAjax.url = url;
    if (data != null)
    {
        baseAjax.data = data;
    }
    baseAjax.success = function(result) {
        returnFun(result);
    };
    $.ajax(baseAjax);
}
