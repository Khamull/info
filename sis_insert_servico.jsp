<%@ page errorPage="index.jsp?erro=3" %>
<%@ page import="java.sql.*" %>
<%@ include file="inc/seguranca.jsp" %>
<%@ include file="inc/conexao.jsp" %>

<jsp:useBean id="usuario" class="cadastro.Usuario" scope="page"></jsp:useBean>

<jsp:useBean id="cliente" class="cadastro.Cliente" scope="page"></jsp:useBean>


<%
//Instancia um objeto do tipo Statement para ajudar na query
Statement st01 = con.createStatement();
%>

<%
//Instancia um objeto do tipo ResultSet para receber resultado de uma Consulta
ResultSet rs = null;
ResultSet rs01 = null;
%>


<%
//Pesquisa todos os clientes Ativos
rs01 = st01.executeQuery(cliente.listaClientesaAtivos());
%>


<%
//Trata mensagens
//variaveis que serão utilizadas para verificação
String msg = "";
int numeroMsg;
//verifica se foi passado alguma mensagem via URL
if(request.getParameter("msg") != null){
	numeroMsg = Integer.parseInt(request.getParameter("msg"));
	msg = usuario.mensagem(numeroMsg);
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2" />
<title>FORTE SYSTEM</title>

<script type="text/javascript">
function verForm(){
	
}
</script>

<script type="text/javascript" src="js/jquery.js"></script>


<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.pstrength-min.1.2.js"></script>
        <script>
        	$(document).ready(function(){
				$('.password').pstrength();
			});
        </script>

<script type="text/javascript" src="js/interface.js"></script>

<!--[if lt IE 7]>
 <style type="text/css">
 .dock img { behavior: url(iepngfix.htc) }
 </style>
<![endif]-->   

<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/geral.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

function verForm(){
	
	if(document.form1.clienteID.value == ""){
		alert("Favor Inserir um cliente para esse Serviço!");
		document.form1.clienteID.focus();
		return false;
	}
	
	if(document.form1.descricao.value == ""){
		alert("Informe detalhes do Serviço!");
		document.form1.descricao.focus();
		return false;
	}
	
	if(document.form1.valor.value == ""){
		alert("Informe o valor do Serviço!");
		document.form1.valor.focus();
		return false;
	}
	
	verPonto();
	
	
	
}

</script>


<script type="text/javascript">

//Valida se o Campo é Numérico (COM VÍRGULA " , " )
function numero()	{
if (event.keyCode<48 && event.keyCode!=44 || event.keyCode>57 && event.keyCode!=44){return false;} 
}

//Verifca se tem "," ao invés de "." e Substitui
function verPonto(){
	var valor = document.form1.valor.value;
		
	valor = valor.replace(",",".");
		
	document.form1.valor.value = valor;
}

</script>

</head>

<body onload="javascript: document.form1.clienteID.focus()">

<div id="container">

<div id="topo">
 <jsp:include page="inc/menu_superior.jsp" />
</div>


<div id="corpo">
<table width="985" align="center" height="440">
<tr>
 <td height="25" bgcolor="#EEEEEE">
 <input type="button" class="botao" onclick="javascript: window.location.href='sis_view_servicos.jsp'" value="Lista de Serviços" />&nbsp;
 <input type="button" class="botao" onclick="javascript: window.location.href='sis_insert_cliente_servico.jsp'" value="+ Incluir Cliente" />
 </td>
</tr>
<tr>
 <td height="25" align="center"><strong>CADASTRO DE SERVI&Ccedil;O</strong></td>
</tr>
<tr> 
 <td valign="top" align="center"> 
 
 <form method="post" name="form1" action="sis_insert_manager_servico.jsp" onsubmit="return verForm(this)">
 <table align="center" cellpadding="2" cellspacing="2">
  
  <tr>
   <td width="63" align="left">Cliente</td>
   <td width="536" align="left">
   <select name="clienteID">
    <option value="">Selecione . . .</option>
    <%while(rs01.next()){ %>
     <option value="<%=rs01.getString("clienteID") %>"><%=rs01.getString("clienteNomeFantasia") %></option>
    <%} %>
   </select>   </td>
  </tr>
  <tr>
   <td align="left" colspan="2">Descri&ccedil;&atilde;o do Servi&ccedil;o</td>
  </tr>
  <tr>
   <td align="left" colspan="2"><textarea name="descricao" style="width:600px; height:250px"></textarea></td>
  </tr>
  
  <tr>
   <td align="left" colspan="2"><input type="submit" name="CADASTRAR" value="Cadastrar" class="botao" />
     <input name="valor" type="hidden" value="0.00" size="20" maxlength="10" onkeypress="verPonto(); return numero(this.value)"/></td>
  </tr>
 </table>
 </form>
 
 </td> 
</tr> 
</table>
</div>


<div id="rodape"><jsp:include page="inc/rodape.jsp" /></div>

</div>

<script type="text/javascript">
	
	$(document).ready(
		function()
		{
			$('#dock').Fisheye(
				{
					maxWidth: 50,
					items: 'a',
					itemsText: 'span',
					container: '.dock-container',
					itemWidth: 40,
					proximity: 50,
					halign : 'center'
				}
			)
		}
	);

</script>

</body>
</html>