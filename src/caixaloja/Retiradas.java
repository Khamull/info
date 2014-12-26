// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Retiradas.java

package caixaloja;

import cadastro.Empresa;
import cadastro.Usuario;

// Referenced classes of package caixaloja:
//            Caixa

public class Retiradas
{

    public Retiradas()
    {
        caixa = new Caixa();
        usuario = new Usuario();
        responsavel = new Usuario();
        empresa = new Empresa();
    }

    public String ultimaRetirada()
    {
        return "SELECT * FROM retiradas ORDER BY retiradaID DESC LIMIT 1";
    }

    public String somaRetiradas()
    {
        return (new StringBuilder("SELECT SUM(valor) as totalRetiradas FROM retiradas WHERE caixaID = '")).append(caixa.caixaID).append("'").toString();
    }

    public String buscaRetiradas()
    {
        return (new StringBuilder("SELECT * FROM retiradas WHERE caixaID = '")).append(caixa.caixaID).append("'").toString();
    }

    public String retirar()
    {
        String cadastra = "INSERT INTO retiradas ";
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("(caixaID, valor, usuario, responsavel, observacao, empresaID) ").toString();
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("VALUES ").toString();
        cadastra = (new StringBuilder(String.valueOf(cadastra))).append("('").append(caixa.caixaID).append("', '").append(valor).append("', '").append(usuario.login).append("', '").append(responsavel.login).append("', '").append(observacao).append("', '").append(empresa.empresaID).append("')").toString();
        return cadastra;
    }

    public int retiradaID;
    public Caixa caixa;
    public float valor;
    public Usuario usuario;
    public Usuario responsavel;
    public String observacao;
    public Empresa empresa;
}
