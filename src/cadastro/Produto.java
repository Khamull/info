// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Produto.java

package cadastro;


// Referenced classes of package cadastro:
//            TipoProduto, Fornecedor

public class Produto
{

    public Produto()
    {
        tipo = new TipoProduto();
        fornecedor = new Fornecedor();
    }

    public String listaProdutos()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("ORDER BY produto.nome ASC").toString();
        return pesquisaProduto;
    }

    public String listaProdutosAtivos()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("WHERE produtoAtivo = 'S' ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("ORDER BY produto.nome ASC").toString();
        return pesquisaProduto;
    }

    public String listaProdutosPorID()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID WHERE produto.produtoID = '").append(produtoID).append("' ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("ORDER BY produto.nome ASC").toString();
        return pesquisaProduto;
    }

    public String pesquisaProdutoPorCodigo(String cod)
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append(" WHERE produto.codigo = '").append(cod).append("' ORDER BY produto.nome ASC").toString();
        return pesquisaProduto;
    }

    public String pesquisaProdutos(String keyWord)
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append(" WHERE nome LIKE '%").append(keyWord).append("%' ORDER BY produto.nome ASC").toString();
        return pesquisaProduto;
    }

    public String produtoPorFT()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("WHERE produto.fornecedorID = '").append(fornecedor.fornecedorID).append("' ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("AND produto.tipoprodutoID = '").append(tipo.tipoProdutoID).append("' ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("ORDER BY produto.nome ASC").toString();
        return pesquisaProduto;
    }

    public String produtoPorF()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("WHERE produto.fornecedorID = '").append(fornecedor.fornecedorID).append("' ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("ORDER BY produto.nome ASC").toString();
        return pesquisaProduto;
    }

    public String produtoPorT()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("WHERE produto.tipoprodutoID = '").append(tipo.tipoProdutoID).append("' ").toString();
        pesquisaProduto = (new StringBuilder(String.valueOf(pesquisaProduto))).append("ORDER BY produto.nome ASC").toString();
        return pesquisaProduto;
    }

    public String produtoNome()
    {
        return (new StringBuilder("SELECT * FROM produto WHERE nome = '")).append(nome).append("'").toString();
    }

    public String produtoNomeEditar()
    {
        return (new StringBuilder("SELECT * FROM produto WHERE nome = '")).append(nome).append("' AND produtoID <> '").append(produtoID).append("'").toString();
    }

    public String produtoCodigo()
    {
        return (new StringBuilder("SELECT * FROM produto WHERE codigo = '")).append(codigo).append("'").toString();
    }

    public String produtoCodigoEditar()
    {
        return (new StringBuilder("SELECT * FROM produto WHERE codigo = '")).append(codigo).append("' AND produtoID <> '").append(produtoID).append("'").toString();
    }

    public String produtoPorFornecedor(String fornID)
    {
        return (new StringBuilder("SELECT * FROM produto WHERE fornecedorID = '")).append(fornID).append("' ORDER BY nome ASC").toString();
    }

    public String salvaProduto()
    {
        String salvaProd = "INSERT INTO produto ";
        salvaProd = (new StringBuilder(String.valueOf(salvaProd))).append("(tipoprodutoID, fornecedorID, nome, codigo, unidade, precoCusto, preco, estoqueminimo, estoque, lucro) VALUES").toString();
        salvaProd = (new StringBuilder(String.valueOf(salvaProd))).append("('").append(tipo.tipoProdutoID).append("', '").append(fornecedor.fornecedorID).append("', '").append(nome).append("', '").append(codigo).append("', '").append(unidade).append("', '").append(precoCusto).append("', '").append(preco).append("', '").append(estoqueMinimo).append("', '").append(estoque).append("', '").append(lucro).append("' ) ").toString();
        return salvaProd;
    }

    public String alteraProduto()
    {
        String alterProd = "UPDATE produto SET ";
        alterProd = (new StringBuilder(String.valueOf(alterProd))).append("tipoprodutoID = '").append(tipo.tipoProdutoID).append("', fornecedorID = '").append(fornecedor.fornecedorID).append("', nome = '").append(nome).append("', codigo = '").append(codigo).append("', ").toString();
        alterProd = (new StringBuilder(String.valueOf(alterProd))).append("unidade = '").append(unidade).append("', precoCusto = '").append(precoCusto).append("', preco = '").append(preco).append("', estoqueminimo = '").append(estoqueMinimo).append("', ").toString();
        alterProd = (new StringBuilder(String.valueOf(alterProd))).append("estoque = '").append(estoque).append("', lucro = '").append(lucro).append("' ").toString();
        alterProd = (new StringBuilder(String.valueOf(alterProd))).append("WHERE produtoID = '").append(produtoID).append("'").toString();
        return alterProd;
    }

    public String alteraEstoqueProduto()
    {
        return (new StringBuilder("UPDATE produto SET estoque = '")).append(estoque).append("' WHERE produtoID = '").append(produtoID).append("'").toString();
    }

    public String excluiProduto()
    {
        return (new StringBuilder("DELETE FROM produto WHERE produtoID = '")).append(produtoID).append("'").toString();
    }

    public String statusProduto(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE produto SET produtoAtivo = 'N' WHERE produtoID = '")).append(produtoID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE produto SET produtoAtivo = 'S' WHERE produtoID = '")).append(produtoID).append("'").toString();
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Produto Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Produto Alterado com Sucesso!";

        case 3: // '\003'
            return "Produto Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um produto cadastrado com esse Nome.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um produto cadastrado com esse Nome.";

        case 6: // '\006'
            return "Estoque Alterado com Sucesso!";

        case 7: // '\007'
            return "Imposs\355vel Cadastrar! J\341 existe um produto cadastrado com esse C\363digo.";

        case 8: // '\b'
            return "Imposs\355vel Alterar! J\341 existe um produto cadastrado com esse C\363digo.";
        }
        return "";
    }

    public int produtoID;
    public TipoProduto tipo;
    public Fornecedor fornecedor;
    public String nome;
    public String codigo;
    public String unidade;
    public double precoCusto;
    public double preco;
    public int estoqueMinimo;
    public float estoque;
    public String lucro;
}
