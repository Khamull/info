// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FormaPagamento.java

package pdv;


public class FormaPagamento
{

    public FormaPagamento()
    {
    }

    public String listaFormasPagamento()
    {
        return "SELECT * FROM formapagamento WHERE formAtivo = 'S' ORDER BY formID";
    }

    public String formaPorID()
    {
        return (new StringBuilder("SELECT * FROM formapagamento WHERE formID = '")).append(formPagID).append("'").toString();
    }

    public int formPagID;
    public String formPagNome;
}
