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
<h1>Lisää, muokkaa ja hae veneitä</h1>
<form action="LisaaVene" method="post" name="lisaaLomake" id="lisaaLomake">
<table class="table_main">
<tr>
<td class="td_lisaa"  align="right">Nimi:</td>
<td class="td_lisaa" ><input type="text" name="nimi" id="nimi"></td>
</tr>
<tr>
<td class="td_lisaa"  align="right">Merkki/malli:</td>
<td class="td_lisaa" ><input type="text" name="merkkimalli" id="merkkimalli"></td>
</tr>
<tr>
<td class="td_lisaa"  align="right">Pituus:</td>
<td class="td_lisaa" ><input type="number" name="pituus" id="pituus"></td>
</tr>
<tr>
<td class="td_lisaa"  align="right">Leveys:</td>
<td class="td_lisaa" ><input type="number" name="leveys" id="leveys"></td>
</tr>
<tr>
<td class="td_lisaa"  align="right">Hinta:</td>
<td class="td_lisaa" ><input type="number" name="hinta" id="hinta"></td>
</tr>
<tr>
<td class="td_lisaa"  colspan="2"><input type="submit" value="Lisää" style="width:260px"></td>
</tr>
<tr>
<td class="td_lisaa"  colspan="2"><input type="button" id="hae" value="Hae, poista tai muuta veneitä" style="width:260px"></td>
</tr>
</table>
</form>
<p>
<%
if(request.getParameter("ilmo")!=null){
	if(request.getParameter("ilmo").equals("1")){
		out.print("Veneen lisääminen onnistui");	 
	}else if(request.getParameter("ilmo").equals("0")){
		out.print("Veneen lisääminen ei onnistunut");	
	}
}
%></p></div>
<script>
	$(document).ready(function(){
		$("#nimi").focus();
	    $("#hae").click(function(){	    	
	    	window.location.href = 'HaeVeneet';
	    });
	    $("#lisaaLomake").validate({
	    	rules: {
	    		nimi: {
	    			required: true
	    		},
	    		merkkimalli: {
	    			required: true
	    		},
	    		pituus: {
	    			required:true,
	    			number:true
	    		},
	    		leveys: {
	    			required:true,
	    			number:true
	    		},	
	    		hinta: {
	    			required:true,
	    			number:true
	    		}
	    	},
	    	messages: {
	    		nimi: {
	    			required: " Pakollinen"
	    		},
	    		merkkimalli: {
	    			required: " Pakollinen"
	    		},
	    		pituus: {
	    			required: " Pakollinen",
	    			number: " Ei ole numero"
	    		},
	    		leveys: {
	    			required: " Pakollinen",
	    			number: " Ei ole numero"
	    		},
	    		hinta: {
	    			required: " Pakollinen",
	    			number: " Ei ole numero"
	    		}
	    	},
	    	submitHandler: function (form){
	    		document.forms["lisaaLomake"].submit();
	    	}
	    });
	});

</script>
</body>
</html>