function irLogin(){
    window.location.href="Login.html";
}
function irRegister(){
    window.location.href="Register.html";
}
function irIndex(){
    window.location.href="index.html";
}
function logear(){
    var correo = $('#usuario').val();
    var password = $('#contrasena').val();
    $.ajax({
        contentType: "application/json",
        type: 'POST',
        url: '/dsaApp/game/login',
        data: JSON.stringify({ "correo": correo, "password": password }),
        dataType: 'json',
        success: function(result){
            window.location.href="Tienda.html"
            alert("Login correcto.")
        },
        error: function(error){
            if (usuario == "" || password == "")
                alert("Te has dejado algo en blaco, compruebalo de nuevo!");
            else{
                alert("Correo o contraseña incorrecta, prueba de nuevo!");
            }
        }
    });
}
function registrar() {
    var username = $('#usuario').val();
    var password = $('#contrasena').val();
    var password2 = $('#contrasena2').val();
    var email = $('#email').val();
    if (password == password2) {

        $.ajax({
            contentType: "application/json",
            type: 'POST',
            url: '/dsaApp/game/registrarUsuario',
            data: JSON.stringify({"nombre": username, "correo":email, "password": password}),
            dataType: 'json',
            success: function (result) {
                window.location.href = "Login.html";
            },
            error: function (error) {
                console.log(error);
                if (email == null || username == null || password == null)
                    alert("Has dejado algo en blanco, miralo de nuevo!");
                else
                    alert("Usuario o contraseña ya estan siendo usados, prueba de nuevo!");
            }
        });
    }
    else alert("Comprueba que las dos contraseñas son iguales.");
}
function listadeObjetos() {
    $("#tcuerpo").empty();
    $.ajax({
        type:'GET',
        url:"/dsaApp/game/listaObjetos",
        dataType:'json',
        success:function (result) {
            for (let i = 0; i < result.length; i++) {
                console.log("i: " + i, result[i]);
                $("#tabla").append(
                    "<tr> <td>" + result[i].nombre +
                    "</td> <td>" + result[i].descripcion +
                    "</td> <td>" + result[i].precio
                );
            }
        },
        error: function (error) {
            alert("Unable to get Shop data.");
            console.log(error);
            window.location.href = "Main.html";
        }
    });
}

















