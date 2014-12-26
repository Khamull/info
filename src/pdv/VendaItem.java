// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VendaItem.java

package pdv;

import cadastro.Produto;

// Referenced classes of package pdv:
//            Venda

public class VendaItem
{

    public VendaItem()
    {
        venda = new Venda();
        produto = new Produto();
    }

    public String pesquisItem()
    {
        return (new StringBuilder("SELECT * FROM vendaitem WHERE itemID = '")).append(itemID).append("'").toString();
    }

    public String listaItensPorID()
    {
        String pesquisaItem = "SELECT produto.produtoID, produto.tipoprodutoID, produto.codigo, produto.nome, produto.unidade, ";
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("tipoproduto.tipoprodutoID, tipoproduto.tipo, ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("vendaitem.* ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("FROM vendaitem ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("INNER JOIN produto ON produto.produtoID = vendaitem.produtoID ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("WHERE vendaitem.vendaID = '").append(venda.vendaID).append("' ").toString();
        pesquisaItem = (new StringBuilder(String.valueOf(pesquisaItem))).append("ORDER BY vendaitem.itemID DESC").toString();
        return pesquisaItem;
    }

    public String salvaItem()
    {
        String salvaItem = "INSERT INTO vendaitem ";
        salvaItem = (new StringBuilder(String.valueOf(salvaItem))).append("(vendaID, produtoID, quantidade, valor, total) ").toString();
        salvaItem = (new StringBuilder(String.valueOf(salvaItem))).append("VALUES ").toString();
        salvaItem = (new StringBuilder(String.valueOf(salvaItem))).append("('").append(venda.vendaID).append("', '").append(produto.produtoID).append("', '").append(quantidade).append("', '").append(produto.preco).append("', '").append(total).append("')").toString();
        return salvaItem;
    }

    public String excluiItem()
    {
        return (new StringBuilder("DELETE FROM vendaitem WHERE itemID = '")).append(itemID).append("'").toString();
    }

    public String totalItem()
    {
        return (new StringBuilder("SELECT SUM(total) as subtotal FROM vendaitem WHERE vendaID = '")).append(venda.vendaID).append("'").toString();
    }

    public int itemID;
    public Venda venda;
    public Produto produto;
    public float quantidade;
    public float total;
}
