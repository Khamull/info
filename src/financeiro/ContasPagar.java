// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ContasPagar.java

package financeiro;

import cadastro.Empresa;
import pdv.FormaPagamento;

public class ContasPagar
{

    public ContasPagar()
    {
        formPag = new FormaPagamento();
        empresa = new Empresa();
    }

    public String cadastraConta()
    {
        String cadastrar = "INSERT INTO contapagar ";
        cadastrar = (new StringBuilder(String.valueOf(cadastrar))).append("(formPagID, favorecido, valor, vezes, intervalo, data, usuario, empresaID) ").toString();
        cadastrar = (new StringBuilder(String.valueOf(cadastrar))).append("VALUES ('").append(formPag.formPagID).append("', '").append(favorecido).append("', '").append(valor).append("', '").append(vezes).append("', '").append(intervalo).append("', '").append(data).append("', '").append(usuario).append("', '").append(empresa.empresaID).append("')").toString();
        return cadastrar;
    }

    public String ultimaConta()
    {
        return "SELECT * FROM contapagar ORDER BY contapagarID DESC LIMIT 1";
    }

    public String contaPorId()
    {
        return (new StringBuilder("SELECT * FROM contapagar WHERE contapagarID = '")).append(contaID).append("'").toString();
    }

    public String detalhePagamento()
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("contapagar.contapagarID, contapagar.favorecido, contapagar.valor as total, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("lancamentos.valor as pago, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("pagar.*").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("FROM pagar ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN lancamentos ON lancamentos.pagarID = pagar.pagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ").toString();
        pesquisa = (new StringBuilder(String.valueOf(pesquisa))).append("WHERE contapagar.contapagarID = '").append(contaID).append("' ").toString();
        return pesquisa;
    }

    public int contaID;
    public FormaPagamento formPag;
    public String favorecido;
    public float valor;
    public int vezes;
    public int intervalo;
    public String data;
    public String usuario;
    public Empresa empresa;
}
