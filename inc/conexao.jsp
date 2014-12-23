<%
Connection con = null;
Statement st = null;

//CONEXAO PARA HOSPEDAGEM
Class.forName("org.gjt.mm.mysql.Driver");
con = DriverManager.getConnection("jdbc:mysql://mysql.fortesystem.net.br/fortesystem03", "fortesystem03", "varzeainfo123");
st=con.createStatement();


//CONEXAO PARA PC-ALMIR
//Class.forName("org.gjt.mm.mysql.Driver");
//con=DriverManager.getConnection("jdbc:mysql://localhost/varzeainfo","root","");
//st=con.createStatement();

%>