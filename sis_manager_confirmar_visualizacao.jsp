<%@ page import="java.sql.*" %>
<%@ include file="inc/conexao.jsp" %>

<jsp:useBean id="cargo" class="cadastro.Cargo" scope="page"></jsp:useBean>

<jsp:useBean id="servico" class="servico.Servico" scope="page"></jsp:useBean>

<%
//Instancia um objeto do tipo ResultSet para receber resultado de uma Consulta
ResultSet rs = null;
%>

<%
//Atribui o ID do Serviço ao objeto servico
servico.servicoID = Integer.parseInt(request.getParameter("servicoID"));

//Altera o valor de Não visualizado para Visualizado
st.execute(servico.visualizado());
%>

<%
//Após alterado direciona para a página de visualização de Serviços
response.sendRedirect("sis_view_servicos.jsp?msg=4");
%>

<%
 //fecha a consulta
 st.close();
%>