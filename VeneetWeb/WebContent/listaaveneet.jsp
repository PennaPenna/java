<%@ include file="onkokirjauduttu.jsp"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Vene"%>  
<%@ page import="dao.Dao"%>  
<%@ page import="java.util.ArrayList"%> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
<link href="https://fonts.googleapis.com/css?family=Francois+One|Pathway+Gothic+One" rel="stylesheet"> 
<title>Tervetuloa</title>
</head>
<body><p class="kayttaja">
<% out.print("Kirjautuneena: " + session.getAttribute("kayttaja") + "</br>"); %></p>
<div id="container">
<h1>Tervetuloa <% out.print(session.getAttribute("kayttaja")); %>!</h1>
<p>Alta löydät veneet listattuna. <br>Pääset myös <a href="lisaavene.jsp">lisäämään</a>, <a href="HaeVeneet">hakemaan, poistamaan ja muokkaamaan veneitä.</a></p>
<!-- <form action="HaeVeneet" method="post" name="haeLomake" id="haeLomake">
Hakusana:
<input type="text" name="hakusana">&nbsp;
<input type="submit" value="Hae"> <a href="lisaavene.jsp"><input type="button" value="Lisää vene"></a>
</form>-->
<table class="table_main">
<tr>
<th>Nimi</th>
<th>Merkki/malli</th>
<th>Pituus</th>
<th>Leveys</th>
<th>Hinta</th>
<th></th>
</tr>
<%Dao dao = new Dao();
	ArrayList<Vene> Veneet = dao.listaaKaikki();
	for(int i=0;i<Veneet.size();i++){
		out.print("<tr>");
		out.print("<td>" + Veneet.get(i).getNimi() + "</td>");
		out.print("<td>" + Veneet.get(i).getMerkkimalli() + "</td>");
		out.print("<td>" + Veneet.get(i).getPituus() + "</td>");
		out.print("<td>" + Veneet.get(i).getLeveys() + "</td>");
		out.print("<td>" + Veneet.get(i).getHinta() + "</td>");
		out.print("</tr>");
	}	
%>
</table><input type="button" id="hae" name="hae" value="Hae muokkaa ja poista veneitä"><input type="button" id="lisaa" name="lisaa" value="Lisää veneitä"></div>
<script>
	$(document).ready(function(){
		$("#hae").click(function(){
	    	window.location.href = 'HaeVeneet'; 
	    	});
	    $("#lisaa").click(function(){
	    	window.location.href = 'lisaavene.jsp';
	    });
	});

</script></body>
</html>