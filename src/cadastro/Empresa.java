// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Empresa.java

package cadastro;


public class Empresa
{

    public Empresa()
    {
    }

    public String dadosEmpresa()
    {
        return "SELECT * FROM empresa WHERE empresaID = '1'";
    }

    public String dadosGerais()
    {
        return (new StringBuilder("SELECT * FROM empresa WHERE empresaID = '")).append(empresaID).append("'").toString();
    }

    public String listaEmpresas()
    {
        return "SELECT * FROM empresa WHERE empresaAtiva = 'S' ORDER BY empresaID DESC";
    }

    public String listaTodasEmpresas()
    {
        return "SELECT * FROM empresa ORDER BY empresaID DESC";
    }

    public String contaEmpresas()
    {
        return "SELECT COUNT(*) as qtdd FROM empresa WHERE empresaAtiva = 'S'";
    }

    public String alterarEmpresa()
    {
        String altEmpresa = (new StringBuilder("UPDATE empresa SET unidade = '")).append(unidade).append("', nomeFantasia = '").append(nomeFantasia).append("', razaoSocial = '").append(razaoSocial).append("', ramo = '").append(ramo).append("', ").toString();
        altEmpresa = (new StringBuilder(String.valueOf(altEmpresa))).append("cnpj = '").append(cnpj).append("', inscEstadual = '").append(inscEstadual).append("', inscMunicipal = '").append(inscMunicipal).append("', cep = '").append(cep).append("', ").toString();
        altEmpresa = (new StringBuilder(String.valueOf(altEmpresa))).append("rua = '").append(rua).append("', numero = '").append(numero).append("', bairro = '").append(bairro).append("', cidade = '").append(cidade).append("', uf = '").append(uf).append("', ").toString();
        altEmpresa = (new StringBuilder(String.valueOf(altEmpresa))).append("complemento = '").append(complemento).append("', responsavel = '").append(responsavel).append("', telefone = '").append(telefone).append("', fax = '").append(fax).append("', ").toString();
        altEmpresa = (new StringBuilder(String.valueOf(altEmpresa))).append("celular = '").append(celular).append("', operadora = '").append(operadora).append("', email = '").append(email).append("', site = '").append(site).append("' ").toString();
        altEmpresa = (new StringBuilder(String.valueOf(altEmpresa))).append("WHERE empresaID = '").append(empresaID).append("'").toString();
        return altEmpresa;
    }

    public String salvaEmpresa()
    {
        String cadastraEmpresa = "INSERT INTO empresa ";
        cadastraEmpresa = (new StringBuilder(String.valueOf(cadastraEmpresa))).append("(unidade, nomeFantasia, razaoSocial, ramo, cnpj, inscEstadual, inscMunicipal, cep, rua, numero, bairro, cidade, uf, ").toString();
        cadastraEmpresa = (new StringBuilder(String.valueOf(cadastraEmpresa))).append("complemento, responsavel, telefone, fax, celular, operadora, email, site) ").toString();
        cadastraEmpresa = (new StringBuilder(String.valueOf(cadastraEmpresa))).append("VALUES ").toString();
        cadastraEmpresa = (new StringBuilder(String.valueOf(cadastraEmpresa))).append("('").append(unidade).append("', '").append(nomeFantasia).append("', '").append(razaoSocial).append("', '").append(ramo).append("', '").append(cnpj).append("', '").append(inscEstadual).append("', '").append(inscMunicipal).append("', ").toString();
        cadastraEmpresa = (new StringBuilder(String.valueOf(cadastraEmpresa))).append("'").append(cep).append("', '").append(rua).append("', '").append(numero).append("', '").append(bairro).append("', '").append(cidade).append("', '").append(uf).append("', '").append(complemento).append("', ").toString();
        cadastraEmpresa = (new StringBuilder(String.valueOf(cadastraEmpresa))).append("'").append(responsavel).append("', '").append(telefone).append("', '").append(fax).append("', '").append(celular).append("', '").append(operadora).append("', '").append(email).append("', '").append(site).append("')").toString();
        return cadastraEmpresa;
    }

    public String statusEmpresa(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE empresa SET empresaAtiva = 'N' WHERE empresaID = '")).append(empresaID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE empresa SET empresaAtiva = 'S' WHERE empresaID = '")).append(empresaID).append("'").toString();
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Nova Filial cadastrada com Sucesso!";

        case 2: // '\002'
            return "Dados da Empresa Alterado com Sucesso!";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int empresaID;
    public String unidade;
    public String nomeFantasia;
    public String razaoSocial;
    public String ramo;
    public String cnpj;
    public String inscEstadual;
    public String inscMunicipal;
    public String cep;
    public String rua;
    public String numero;
    public String bairro;
    public String cidade;
    public String uf;
    public String complemento;
    public String responsavel;
    public String telefone;
    public String fax;
    public String celular;
    public String operadora;
    public String email;
    public String site;
}
