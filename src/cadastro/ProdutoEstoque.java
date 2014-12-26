// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProdutoEstoque.java

package cadastro;


// Referenced classes of package cadastro:
//            Produto, Empresa

public class ProdutoEstoque
{

    public ProdutoEstoque()
    {
        produto = new Produto();
        empresa = new Empresa();
    }

    public String pesquisaEstoque()
    {
        return (new StringBuilder("SELECT * FROM produtoestoque WHERE produtoID = '")).append(produto.produtoID).append("' AND empresaID = '").append(empresa.empresaID).append("'").toString();
    }

    public String salvaQuantidade()
    {
        String salvaQtdd = "INSERT INTO produtoestoque ";
        salvaQtdd = (new StringBuilder(String.valueOf(salvaQtdd))).append("(produtoID, empresaID, quantidade) ").toString();
        salvaQtdd = (new StringBuilder(String.valueOf(salvaQtdd))).append("VALUES ").toString();
        salvaQtdd = (new StringBuilder(String.valueOf(salvaQtdd))).append("('").append(produto.produtoID).append("', '").append(empresa.empresaID).append("', '").append(quantidade).append("')").toString();
        return salvaQtdd;
    }

    public String alteraEstoque()
    {
        String alteraQtdd = "UPDATE produtoestoque SET ";
        alteraQtdd = (new StringBuilder(String.valueOf(alteraQtdd))).append("quantidade = '").append(quantidade).append("' ").toString();
        alteraQtdd = (new StringBuilder(String.valueOf(alteraQtdd))).append("WHERE produtoID = '").append(produto.produtoID).append("' AND empresaID = '").append(empresa.empresaID).append("'").toString();
        return alteraQtdd;
    }

    public int produtoEstoqueID;
    public Produto produto;
    public Empresa empresa;
    public float quantidade;
}
