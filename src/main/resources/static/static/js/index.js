function post() {
    var name = $("#name").val();
    var psw = $("#psw").val();
    comment2target(name, psw);
}
function comment2target(name, psw) {
    if (!name) {
        alert("名字不能为空");
        return;
    }

    $.ajax({
        type:"POST",
        url:"/login",
        contentType:"application/json",
        data:JSON.stringify({
            "name":name,
            "psw":psw
        }),
        success:function (response) {
            if(response.code == 200) {
                window.open("localhost:8080/loginSuccess.html");
            } else{
                alert(response.message);
            }
        },
        dataType:"json"
    });
}