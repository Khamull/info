// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TipoProduto.java

package cadastro;


public class TipoProduto
{

    public TipoProduto()
    {
    }

    public String listaTipos()
    {
        return "SELECT * FROM tipoproduto ORDER BY tipo ASC";
    }

    public String listaTiposAtivos()
    {
        return "SELECT * FROM tipoproduto WHERE tipoAtivo = 'S' ORDER BY tipo ASC";
    }

    public String tipoPorId()
    {
        return (new StringBuilder("SELECT * FROM tipoproduto WHERE tipoprodutoID = '")).append(tipoProdutoID).append("'").toString();
    }

    public String tipoPorNome()
    {
        return (new StringBuilder("SELECT * FROM tipoproduto WHERE tipo = '")).append(tipo).append("'").toString();
    }

    public String tipoPorNomeEditar()
    {
        return (new StringBuilder("SELECT * FROM tipoproduto WHERE tipo = '")).append(tipo).append("' AND tipoprodutoID <> '").append(tipoProdutoID).append("'").toString();
    }

    public String pesquisaTipos(String keyWord)
    {
        return (new StringBuilder("SELECT * FROM tipoproduto WHERE tipo LIKE '%")).append(keyWord).append("%'").toString();
    }

    public String salvaTipo()
    {
        return (new StringBuilder("INSERT INTO tipoproduto (tipo) VALUES ('")).append(tipo).append("')").toString();
    }

    public String alteraTipo()
    {
        return (new StringBuilder("UPDATE tipoproduto SET tipo = '")).append(tipo).append("' WHERE tipoprodutoID = '").append(tipoProdutoID).append("'").toString();
    }

    public String excluiTipo()
    {
        return (new StringBuilder("DELETE FROM tipoproduto WHERE tipoprodutoID = '")).append(tipoProdutoID).append("'").toString();
    }

    public String statusTipo(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE tipoproduto SET tipoAtivo = 'N' WHERE tipoprodutoID = '")).append(tipoProdutoID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE tipoproduto SET tipoAtivo = 'S' WHERE tipoprodutoID = '")).append(tipoProdutoID).append("'").toString();
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Tipo Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Tipo Alterado com Sucesso!";

        case 3: // '\003'
            return "Tipo Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um tipo cadastrado com esse Nome.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um tipo cadastrado com esse Nome.";
        }
        return "";
    }

    public int tipoProdutoID;
    public String tipo;
}
