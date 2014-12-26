// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServicoItem.java

package servico;


// Referenced classes of package servico:
//            Servico

public class ServicoItem
{

    public ServicoItem()
    {
        servico = new Servico();
    }

    public String listaItens()
    {
        return (new StringBuilder("SELECT * FROM servicoitem WHERE servicoID = '")).append(servico.servicoID).append("'").toString();
    }

    public String pesquisaItem()
    {
        return (new StringBuilder("SELECT * FROM servicoitem WHERE servicoitemID = '")).append(servicoItemID).append("'").toString();
    }

    public String salvaItem()
    {
        String salvaItem = "INSERT INTO servicoitem (servicoID, descricao, valor) VALUES ";
        salvaItem = (new StringBuilder(String.valueOf(salvaItem))).append("('").append(servico.servicoID).append("', '").append(descricao).append("', '").append(valor).append("')").toString();
        return salvaItem;
    }

    public String excluiItem()
    {
        return (new StringBuilder("DELETE FROM servicoitem WHERE servicoitemID = '")).append(servicoItemID).append("'").toString();
    }

    public int servicoItemID;
    public Servico servico;
    public String descricao;
    public float valor;
}
