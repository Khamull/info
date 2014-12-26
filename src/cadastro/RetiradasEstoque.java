// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RetiradasEstoque.java

package cadastro;


// Referenced classes of package cadastro:
//            Produto, Usuario, Empresa

public class RetiradasEstoque
{

    public RetiradasEstoque()
    {
        produto = new Produto();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String retiradasPorProdutoID()
    {
        return (new StringBuilder("SELECT * FROM retiradasestoque WHERE produtoID = '")).append(produto.produtoID).append("'").toString();
    }

    public String retiradasEntreDatas(String dataInicio, String dataFim)
    {
        String busca = "SELECT * FROM retiradasestoque ";
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE produtoID = '").append(produto.produtoID).append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append(" 23:59:59").append("'").toString();
        return busca;
    }

    public String retiradasEntreDatasDetalhada(String dataInicio, String dataFim)
    {
        String busca = "SELECT usuario.usuarioID, usuario.usuarioLogin, usuario.usuarioNome, retiradasestoque.* ";
        busca = (new StringBuilder(String.valueOf(busca))).append("FROM retiradasestoque ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("LEFT JOIN usuario ON usuario.usuarioID = retiradasestoque.usuario ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE retiradasestoque.produtoID = '").append(produto.produtoID).append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND retiradasestoque.data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append(" 23:59:59").append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("GROUP BY retiradasestoque.retiradaID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY retiradasestoque.data DESC").toString();
        return busca;
    }

    public String retiradasEntreDatasRelatorio(String dataInicio, String dataFim)
    {
        String busca = "SELECT usuario.usuarioID, usuario.usuarioLogin, usuario.usuarioNome, produto.produtoID, produto.nome, produto.unidade, retiradasestoque.* ";
        busca = (new StringBuilder(String.valueOf(busca))).append("FROM retiradasestoque ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("LEFT JOIN usuario ON usuario.usuarioID = retiradasestoque.usuario ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("INNER JOIN produto ON produto.produtoID = retiradasestoque.produtoID  ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE retiradasestoque.data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append(" 23:59:59").append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("GROUP BY retiradasestoque.retiradaID ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("ORDER BY retiradasestoque.data ASC").toString();
        return busca;
    }

    public String quantidadeRetirada(String dataInicio, String dataFim)
    {
        String busca = "SELECT SUM(quantidade) as totalRetirada FROM retiradasestoque ";
        busca = (new StringBuilder(String.valueOf(busca))).append("WHERE produtoID = '").append(produto.produtoID).append("' ").toString();
        busca = (new StringBuilder(String.valueOf(busca))).append("AND data BETWEEN '").append(dataInicio).append("' AND '").append(dataFim).append("'").toString();
        return busca;
    }

    public String cadastraRetirada()
    {
        String cadastra = "INSERT INTO retiradasestoque ";
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("(produtoID, quantidade, motivo, usuario, empresaID) VALUES").toString();
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("('").append(produto.produtoID).append("', '").append(quantidade).append("', '").append(motivo).append("', '").append(usuario.login).append("', '").append(empresa.empresaID).append("')").toString();
        return cadastra;
    }

    public int retiradaID;
    public Produto produto;
    public float quantidade;
    public String motivo;
    public Usuario usuario;
    public Empresa empresa;
}
