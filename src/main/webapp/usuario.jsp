<!DOCTYPE html>
<%@page import= "clienteweb.User" %>
<%@page import= "java.util.*" %>
<html>
<head>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js">
    </script>
    <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<h2>Criar Novo Usuario</h2>
<form id="user-form" method="post" action="usuario">
    <table >
        <tr>
            <td> Identificador:</td>
            <td><input type="number" name="userId"/></td>
        </tr>
        <tr>
            <td> Nome: </td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td> Email:</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td> Senha:</td>
            <td><input type="text" name="senha"/></td>
        </tr>
        <tr>
            <td> Status:</td>
            <td><select name="status">
					  <option value="ativo">Ativo</option>
					  <option value="inativo">Inativo</option>
				</select>	</td>
        </tr>
    </table>
    <input type="submit" value="Cadastro"/>
</form>
<br>

<input id="clickMe" type="button" value="Exibir todos" onclick="exibirTodos();" />
<input id="clickMe" type="button" value="Exibir ativos" onclick="exibirAtiv();" />
<input id="clickMe" type="button" value="Exibir inativos" onclick="exibirInativ();" />

<table>
	<thead>
    	<th>ID</th>
    	<th>Nome</th>
    	<th>e-mail</th>
    	<th>status</th>
    </thead>
    <tbody id="tabela">
    </tbody>
</table>





<script type="text/javascript">
function exibirTodos() {
	var mapa = $.parseJSON('${Mapa}');
	var table = document.getElementById("tabela");
	$("#tabela tr").remove();
	//mapa.forEach(logMapElements);
	for (var i in mapa){
			var row = table.insertRow(-1);
			var id = row.insertCell(0).innerHTML = mapa[i].id;
			var nome = row.insertCell(1).innerHTML = mapa[i].Nome;
			var email = row.insertCell(2).innerHTML = mapa[i].email;
			var status = row.insertCell(3).innerHTML = mapa[i].status;	
	}
	
	}
function exibirAtiv() {
	var mapa = $.parseJSON('${Mapa}');
	var table = document.getElementById("tabela");
	$("#tabela tr").remove();
	//mapa.forEach(logMapElements);
	for (var i in mapa){
		if(mapa[i].status == "ativo"){
			var row = table.insertRow(-1);
			var id = row.insertCell(0).innerHTML = mapa[i].id;
			var nome = row.insertCell(1).innerHTML = mapa[i].Nome;
			var email = row.insertCell(2).innerHTML = mapa[i].email;
			var status = row.insertCell(3).innerHTML = mapa[i].status;
		}
	}
	
	}
function exibirInativ() {
	var mapa = $.parseJSON('${Mapa}');
	var table = document.getElementById("tabela");
	$("#tabela tr").remove();
	//mapa.forEach(logMapElements);
	for (var i in mapa){
		if(mapa[i].status == "inativo"){
			var row = table.insertRow(-1);
			var id = row.insertCell(0).innerHTML = mapa[i].id;
			var nome = row.insertCell(1).innerHTML = mapa[i].Nome;
			var email = row.insertCell(2).innerHTML = mapa[i].email;
			var status = row.insertCell(3).innerHTML = mapa[i].status;
		}
	}
	
	}

</script>

</body>
</html>