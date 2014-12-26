// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Fornecedor.java

package cadastro;


// Referenced classes of package cadastro:
//            Endereco, Usuario, Empresa

public class Fornecedor
{

    public Fornecedor()
    {
        endereco = new Endereco();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String listaFornecedores()
    {
        return "SELECT * FROM fornecedor ORDER BY fornecedorID DESC";
    }

    public String listaFornecedoresAtivos()
    {
        return "SELECT * FROM fornecedor WHERE fornAtivo = 'S' ORDER BY fornecedorID DESC";
    }

    public String fornecedorPorID()
    {
        return (new StringBuilder("SELECT * FROM fornecedor WHERE fornecedorID = '")).append(fornecedorID).append("'").toString();
    }

    public String pesquisaFornecedor(String keyWord)
    {
        return (new StringBuilder("SELECT * FROM fornecedor WHERE fornAtivo = 'S' AND fornNomeFantasia LIKE '%")).append(keyWord).append("%' ORDER BY fornecedorID DESC").toString();
    }

    public String listaFornecedoresOrdenados()
    {
        return "SELECT * FROM fornecedor ORDER BY fornNomeFantasia ASC";
    }

    public String verificaCnpj()
    {
        return (new StringBuilder("SELECT fornCnpj FROM fornecedor WHERE fornCnpj = '")).append(cnpj).append("'").toString();
    }

    public String verificaCnpjAlterar()
    {
        return (new StringBuilder("SELECT fornCnpj FROM fornecedor WHERE fornCnpj = '")).append(cnpj).append("' AND fornecedorID <> '").append(fornecedorID).append("'").toString();
    }

    public String salvarFornecedor()
    {
        String salvaCli = "INSERT INTO fornecedor (fornNomeFantasia, fornRazaoSocial, fornCnpj, fornInscEstadual, ";
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("fornInscMunicipal, fornEndereco, fornNumero, fornBairro, fornCep, fornCidade, fornUf, ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("fornComplemento, fornContato, fornTelefone, fornFax, fornRadio, fornCelular, operadoraCelular, ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("fornEmail, fornSite, fornUsuario, empresaID) VALUES ('").append(nomeFantasia).append("', '").append(razaoSocial).append("', ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("'").append(cnpj).append("', '").append(inscEstadual).append("', '").append(inscMunicipal).append("', '").append(endereco.logradouro).append("', '").append(endereco.numero).append("', ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("'").append(endereco.bairro).append("', '").append(endereco.cep).append("', '").append(endereco.cidade).append("', '").append(endereco.uf).append("', '").append(endereco.complemento).append("', ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("'").append(contato).append("', '").append(telefone).append("', '").append(fax).append("', '").append(radio).append("', '").append(celular).append("', ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("'").append(operadoraCelular).append("', '").append(email).append("', '").append(site).append("', '").append(usuario).append("', '").append(empresa.empresaID).append("')").toString();
        return salvaCli;
    }

    public String alteraFornecedor()
    {
        String editaForn = "UPDATE  fornecedor SET  ";
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornNomeFantasia =  '").append(nomeFantasia).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornRazaoSocial =  '").append(razaoSocial).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornCnpj =  '").append(cnpj).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornInscEstadual =  '").append(inscEstadual).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornInscMunicipal =  '").append(inscMunicipal).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornEndereco =  '").append(endereco.logradouro).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornNumero =  '").append(endereco.numero).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornBairro =  '").append(endereco.bairro).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornCep =  '").append(endereco.cep).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornCidade =  '").append(endereco.cidade).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornUf =  '").append(endereco.uf).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornComplemento =  '").append(endereco.complemento).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornContato =  '").append(contato).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornTelefone =  '").append(telefone).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornFax =  '").append(fax).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornRadio =  '").append(radio).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornCelular =  '").append(celular).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("operadoraCelular =  '").append(operadoraCelular).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornEmail =  '").append(email).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornSite =  '").append(site).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("fornUsuario =  '").append(usuario.nome).append("', ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("empresaID = '").append(empresa.empresaID).append("' ").toString();
        editaForn = (new StringBuilder(String.valueOf(editaForn))).append("WHERE  fornecedorID = '").append(fornecedorID).append("'").toString();
        return editaForn;
    }

    public String excluirFornecedor()
    {
        return (new StringBuilder("DELETE FROM fornecedor WHERE fornecedorID = '")).append(fornecedorID).append("'").toString();
    }

    public String statusFornecedor(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE fornecedor SET fornAtivo = 'N' WHERE fornecedorID = '")).append(fornecedorID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE fornecedor SET fornAtivo = 'S' WHERE fornecedorID = '")).append(fornecedorID).append("'").toString();
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Fornecedor Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Fornecedor Alterado com Sucesso!";

        case 3: // '\003'
            return "Fornecedor Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um fornecedor cadastrado com esse CNPJ.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um fornecedor cadastrado com esse CNPJ.";
        }
        return "";
    }

    public int fornecedorID;
    public String nomeFantasia;
    public String razaoSocial;
    public String cnpj;
    public String inscEstadual;
    public String inscMunicipal;
    public Endereco endereco;
    public String contato;
    public String telefone;
    public String fax;
    public String radio;
    public String celular;
    public String operadoraCelular;
    public String email;
    public String site;
    public Usuario usuario;
    public Empresa empresa;
}
