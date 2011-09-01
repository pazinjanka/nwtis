<%-- 
    Document   : login
    Created on : 15.06.2011., 21:05:44
    Author     : Martina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Login</h3>
        <p>Molimo Vas da se za nastavak rada prijavite</p>

        <h5>Unesi podatke:</h5>
        <form action="login" method="POST">
          Korisničko ime: <input type="text" name="kor_ime"><br>
          Lozinka: <input type="password" name="lozinka"><br>
          <input type="submit" value=" Prijava ">
        </form>
    </body>
</html>
