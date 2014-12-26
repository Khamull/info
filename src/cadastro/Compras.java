// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Compras.java

package cadastro;


public class Compras
{

    public Compras()
    {
    }

    public String cadastraItem()
    {
        return (new StringBuilder("INSERT INTO compras (nome, quantidade) VALUES ('")).append(nome).append("', '").append(quantidade).append("')").toString();
    }

    public String excluiItem()
    {
        return (new StringBuilder("DELETE FROM compras WHERE compraID = '")).append(compraID).append("'").toString();
    }

    public String listaItens()
    {
        return "SELECT * FROM compras WHERE compraAtiva = 'S' ORDER BY compraID DESC";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Item Inserido na Compra com Sucesso!";

        case 2: // '\002'
            return "Item Excluido da Compra!";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int compraID;
    public String nome;
    public int quantidade;
}
