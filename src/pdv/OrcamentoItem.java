// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrcamentoItem.java

package pdv;

import cadastro.Produto;

// Referenced classes of package pdv:
//            Orcamento

public class OrcamentoItem
{

    public OrcamentoItem()
    {
        orcamento = new Orcamento();
        produto = new Produto();
    }

    public String pesquisItem()
    {
        return (new StringBuilder("SELECT * FROM orcamentoitem WHERE itemID = '")).append(itemID).append("'").toString();
    }

    public String listaItensPorID()
    {
        String pesquisaItem = "SELECT produto.produtoID, produto.tipoprodutoID, produto.codigo, produto.nome, produto.unidade, ";
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("tipoproduto.tipoprodutoID, tipoproduto.tipo, ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("orcamentoitem.* ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("FROM orcamentoitem ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("INNER JOIN produto ON produto.produtoID = orcamentoitem.produtoID ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("WHERE orcamentoitem.orcamentoID = '").append(orcamento.orcamentoID).append("' ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("ORDER BY orcamentoitem.itemID DESC").toString();
        return pesquisaItem;
    }

    public String salvaItem()
    {
        String salvaItem = "INSERT INTO orcamentoitem ";
        salvaItem = (new StringBuilder(String.valueOf(salvaItem))).append("(orcamentoID, produtoID, quantidade, valor, total) ").toString();
        salvaItem = (new StringBuilder(String.valueOf(salvaItem))).append("VALUES ").toString();
        salvaItem = (new StringBuilder(String.valueOf(salvaItem))).append("('").append(orcamento.orcamentoID).append("', '").append(produto.produtoID).append("', '").append(quantidade).append("', '").append(produto.preco).append("', '").append(total).append("')").toString();
        return salvaItem;
    }

    public String excluiItem()
    {
        return (new StringBuilder("DELETE FROM orcamentoitem WHERE itemID = '")).append(itemID).append("'").toString();
    }

    public String removeItens()
    {
        return (new StringBuilder("DELETE FROM orcamentoitem WHERE orcamentoID = '")).append(orcamento.orcamentoID).append("'").toString();
    }

    public String totalItem()
    {
        return (new StringBuilder("SELECT SUM(total) as subtotal FROM orcamentoitem WHERE orcamentoID = '")).append(orcamento.orcamentoID).append("'").toString();
    }

    public int itemID;
    public Orcamento orcamento;
    public Produto produto;
    public float quantidade;
    public float total;
}
