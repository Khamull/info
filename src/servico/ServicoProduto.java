// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServicoProduto.java

package servico;

import cadastro.Produto;

// Referenced classes of package servico:
//            Servico

public class ServicoProduto
{

    public ServicoProduto()
    {
        servico = new Servico();
        produto = new Produto();
    }

    public String listaProdutos()
    {
        String pesquisaProd = "SELECT produto.produtoID, produto.nome, servicoproduto.* ";
        pesquisaProd = (new StringBuilder(String.valueOf(pesquisaProd))).append("FROM servicoproduto INNER JOIN produto ON produto.produtoID = servicoproduto.produtoID ").toString();
        pesquisaProd = (new StringBuilder(String.valueOf(pesquisaProd))).append("WHERE servicoproduto.servicoID = '").append(servico.servicoID).append("'").toString();
        return pesquisaProd;
    }

    public String listaProdutosCupom()
    {
        String pesquisaProd = "SELECT produto.produtoID, produto.nome, produto.codigo, produto.tipoprodutoID, produto.unidade, ";
        pesquisaProd = (new StringBuilder(String.valueOf(pesquisaProd))).append("tipoproduto.tipoprodutoID, tipoproduto.tipo, ").toString();
        pesquisaProd = (new StringBuilder(String.valueOf(pesquisaProd))).append("servicoproduto.* ").toString();
        pesquisaProd = (new StringBuilder(String.valueOf(pesquisaProd))).append("FROM servicoproduto INNER JOIN produto ON produto.produtoID = servicoproduto.produtoID ").toString();
        pesquisaProd = (new StringBuilder(String.valueOf(pesquisaProd))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaProd = (new StringBuilder(String.valueOf(pesquisaProd))).append("WHERE servicoproduto.servicoID = '").append(servico.servicoID).append("'").toString();
        return pesquisaProd;
    }

    public String pequisaProduto()
    {
        return (new StringBuilder("SELECT * FROM servicoproduto WHERE servicoprodutoID = '")).append(servicoProdutoID).append("'").toString();
    }

    public String salvaProduto()
    {
        String salvaProd = "INSERT INTO servicoproduto (servicoID, produtoID, valor) VALUES ";
        salvaProd = (new StringBuilder(String.valueOf(salvaProd))).append("('").append(servico.servicoID).append("', '").append(produto.produtoID).append("', '").append(valor).append("')").toString();
        return salvaProd;
    }

    public String excluiProduto()
    {
        return (new StringBuilder("DELETE FROM servicoproduto WHERE servicoprodutoID = '")).append(servicoProdutoID).append("'").toString();
    }

    public int servicoProdutoID;
    public Servico servico;
    public Produto produto;
    public float valor;
}
