// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Estoque.java

package cadastro;


// Referenced classes of package cadastro:
//            Fornecedor, Produto, Empresa

public class Estoque
{

    public Estoque()
    {
        fornecedor = new Fornecedor();
        produto = new Produto();
        empresa = new Empresa();
    }

    public String pesquisaEstoque()
    {
        return (new StringBuilder("SELECT estoque FROM produto WHERE produtoID = '")).append(produto.produtoID).append("'").toString();
    }

    public String salvaEstoque()
    {
        String salvarEst = "INSERT INTO estoque ";
        salvarEst = (new StringBuilder(String.valueOf(salvarEst))).append("(fornecedorID, produtoID, quantidade, precoCusto, preco, lucro, unidade, usuario, empresaID) ").toString();
        salvarEst = (new StringBuilder(String.valueOf(salvarEst))).append("VALUES ").toString();
        salvarEst = (new StringBuilder(String.valueOf(salvarEst))).append("('").append(fornecedor.fornecedorID).append("', '").append(produto.produtoID).append("', '").append(quantidade).append("', '").append(produto.precoCusto).append("', ").toString();
        salvarEst = (new StringBuilder(String.valueOf(salvarEst))).append("'").append(produto.preco).append("', '").append(produto.lucro).append("', '").append(produto.unidade).append("', '").append(usuario).append("', '").append(empresa.empresaID).append("')").toString();
        return salvarEst;
    }

    public String alteraEstoqueProduto()
    {
        String alteraEst = (new StringBuilder("UPDATE produto SET precoCusto = '")).append(produto.precoCusto).append("', preco = '").append(produto.preco).append("', estoque = '").append(quantidade).append("', ").toString();
        alteraEst = (new StringBuilder(String.valueOf(alteraEst))).append("lucro = '").append(produto.lucro).append("', unidade = '").append(produto.unidade).append("' ").toString();
        alteraEst = (new StringBuilder(String.valueOf(alteraEst))).append("WHERE produtoID = '").append(produto.produtoID).append("'").toString();
        return alteraEst;
    }

    public String alteraEstoque()
    {
        return (new StringBuilder("UPDATE produto SET estoque = '")).append(produto.estoque).append("' WHERE produtoID = '").append(produto.produtoID).append("'").toString();
    }

    public String qtdTotalEstoque()
    {
        return "SELECT SUM(estoque) AS produtoEstoque, precoCusto FROM produto WHERE produtoAtivo = 'S'";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "";

        case 2: // '\002'
            return "";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int estoqueID;
    public Fornecedor fornecedor;
    public Produto produto;
    public float quantidade;
    public String usuario;
    public Empresa empresa;
}
