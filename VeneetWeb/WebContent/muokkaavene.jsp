<%@ include file="onkokirjauduttu.jsp"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
<link href="https://fonts.googleapis.com/css?family=Francois+One|Pathway+Gothic+One" rel="stylesheet"> 
<title>Muokkaa vene</title>
</head>
<%
String nimi="";
if(request.getParameter("muokkaa_nimi")!=null){
	nimi=request.getParameter("muokkaa_nimi");}
	
String merkkimalli="";
	if(request.getParameter("merkkimalli")!=null){
		merkkimalli=request.getParameter("merkkimalli");}

Double pituus=0.0;
		if(Double.parseDouble(request.getParameter("pituus"))!=0){
			pituus=Double.parseDouble(request.getParameter("pituus"));}

Double leveys=0.0;
		if(Double.parseDouble(request.getParameter("leveys"))!=0){
			leveys=Double.parseDouble(request.getParameter("leveys"));}

Double hinta=0.0;
		if(Double.parseDouble(request.getParameter("hinta"))!=0){
			hinta=Double.parseDouble(request.getParameter("hinta"));}
	
	
%>
<body><p class="kayttaja">
<% out.print("Kirjautuneena: " + session.getAttribute("kayttaja") + "</br>"); %></p>
<div id="container">
<h1>Muokkaa veneen tietoja</h1>
<form action="MuokkaaVene" method="post" name="muokkaaLomake" id="muokkaaLomake">
<table class="table_main">
<tr>
<td class="td_lisaa" align="right">Nimi:</td>
<td class="td_lisaa"><input type="text" name="nimiUusi" id="nimi" value="<%=nimi%>"></td>
</tr>
<tr>
<td class="td_lisaa" align="right">Merkki/malli:</td>
<td class="td_lisaa"><input type="text" name="merkkimalli" id="merkkimalli" value="<%=merkkimalli%>"></td>
</tr>
<tr>
<td class="td_lisaa" align="right">Pituus:</td>
<td class="td_lisaa"><input type="number" name="pituus" id="pituus" value="<%=pituus%>"></td>
</tr>
<tr>
<td class="td_lisaa" align="right">Leveys:</td>
<td class="td_lisaa"><input type="number" name="leveys" id="leveys" value="<%=leveys%>"></td>
</tr>
<tr>
<td class="td_lisaa" align="right">Hinta:</td>
<td class="td_lisaa"><input type="number" name="hinta" value="<%=hinta%>"></td>
</tr>
<tr>
<td class="td_lisaa"><input type="button" name="hae" id="hae" value="< Palaa hakuun" style="width:143px"></td>
<td class="td_lisaa"><input type="submit" value="Vahvista muutos" style="width:143px"></td>
</tr>
<tr>
<td class="td_lisaa" colspan="2"><a href="lisaavene.jsp"><input type="button" value="Lisää uusi vene >" style="width:300px"></a></td>
</tr>
</table>
<input type="hidden" name="nimi" value="<%=nimi%>">
</form>
</div>
<script>
	$(document).ready(function(){
		$("#nimi").focus();
	    $("#hae").click(function(){	    	
	    	window.location.href = 'HaeVeneet';
	    });
	    $("#muokkaaLomake").validate({
	    	rules: {
	    		nimiUusi: {
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
	    		nimiUusi: {
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
	    		document.forms["muokkaaLomake"].submit();
	    	}
	    });
	});
</script>
</body>
</html>