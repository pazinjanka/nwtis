<%-- 
    Document   : index
    Created on : 04.06.2011., 20:32:52
    Author     : Martina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dobrodošli!</title>
  </head>
  <body>
      <h3> Prijaviti se želim kao... </h3>
        <form action="login" method="POST">
          Korisničko ime: <input type="text" name="kor_ime"><br>
          Lozinka: <input type="password" name="lozinka"><br>
          <input type="submit" value=" Prijava ">
        </form>
      <p>Korisnik <a href="sigurnoKorisnik/pageK.html" >here!</a></p>
      <p><a href="sigurnoKorisnik/ispisPodataka.jsp" >Ispis podataka</a></p>
  </body>
</html>