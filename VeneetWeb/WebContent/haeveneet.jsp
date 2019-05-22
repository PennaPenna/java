<%@ include file="onkokirjauduttu.jsp"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Vene"%>  
<%@ page import="java.util.ArrayList"%> 
 
<%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
<link href="https://fonts.googleapis.com/css?family=Francois+One|Pathway+Gothic+One" rel="stylesheet"> 
<title>Veneet</title>
</head>
<body><p class="kayttaja">
<% out.print("Kirjautuneena: " + session.getAttribute("kayttaja") + "</br>"); %></p>
<div id="container">
<h1>Hae veneet</h1>
<p>Voit poistaa (<span class="poista">X</span>) ja muokata (<span class="muokkaa">M</span>) veneitä.</p>
<form action="HaeVeneet" method="post" name="haeLomake" id="haeLomake">
Hakusana: &nbsp;
<input type="text" name="hakusana" id="hakusana"> &nbsp;
<input type="submit" value="Hae"> <a href="lisaavene.jsp"><input type="button" value="Lisää vene"></a>
</form>
<%
if(request.getParameter("ilmo")!=null){
	out.print(request.getParameter("ilmo"));	
	if (request.getParameter("ilmo").equals("2")) {
		out.print("Veneen poistaminen ei onnistunut");	
	}
	else {
		out.print("");
	}
	}
%>
<br/>
<table class="table_main">
<tr>
<th>Nimi</th>
<th>Merkki/malli</th>
<th>Pituus</th>
<th>Leveys</th>
<th>Hinta</th>
<th></th>
</tr>
<%if(request.getAttribute("Veneet")!=null){	
	ArrayList<Vene> Veneet = (ArrayList<Vene>)request.getAttribute("Veneet");
	for(int i=0;i<Veneet.size();i++){
		out.print("<tr>");
		out.print("<td>" + Veneet.get(i).getNimi() + "</td>");
		out.print("<td>" + Veneet.get(i).getMerkkimalli() + "</td>");
		out.print("<td>" + Veneet.get(i).getPituus() + "</td>");
		out.print("<td>" + Veneet.get(i).getLeveys() + "</td>");
		out.print("<td>" + Veneet.get(i).getHinta() + "</td>");
		out.print("<td><a class='poista' href='PoistaVene?poista_nimi=" + Veneet.get(i).getNimi() + "'><abbr title='Poista'> X </abbr></a>");
		out.print("&nbsp; <a class='muokkaa' href='muokkaavene.jsp?muokkaa_nimi=" + Veneet.get(i).getNimi() + "&merkkimalli=" + Veneet.get(i).getMerkkimalli() + "&pituus=" + Veneet.get(i).getPituus() + "&leveys=" + Veneet.get(i).getLeveys() + "&hinta=" + Veneet.get(i).getHinta() + "'><abbr title='Muokkaa'> M </abbr></a></td>");
		out.print("</tr>");
	}	
}
%>
</table></div>
<script>
	$(document).ready(function(){
		$("#hakusana").focus();
	    $("#lisaa").click(function(){
	    	window.location.href = 'lisaavene.jsp';
	    });
	    $("#haeLomake").validate({
	    	rules: {
	    		hakusana: {
	    			required: true
	    	},
	    	messages: {
	    		hakusana: {
	    			required: " Pakollinen"
	    	},
	    	submitHandler: function (form){
	    		document.forms["haeLomake"].submit();
	    	}
	    });
	});

</script>
</body>
</html>