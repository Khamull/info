// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cliente.java

package cadastro;


// Referenced classes of package cadastro:
//            Endereco, Usuario

public class Cliente
{

    public Cliente()
    {
        endereco = new Endereco();
        usuario = new Usuario();
    }

    public String listaClientes()
    {
        return "SELECT * FROM cliente ORDER BY trim(clienteNomeFantasia) ASC";
    }

    public String listaClientesaAtivos()
    {
        return "SELECT * FROM cliente WHERE clienteAtivo = 'S' ORDER BY trim(clienteNomeFantasia) ASC";
    }

    public String listaClientesOrdenados()
    {
        return "SELECT * FROM cliente WHERE clienteAtivo = 'S' ORDER BY clienteNomeFantasia ASC";
    }

    public String clientePorID()
    {
        return (new StringBuilder("SELECT * FROM cliente WHERE clienteID = '")).append(clienteID).append("'").toString();
    }

    public String pesquisaCliente(String keyWord)
    {
        return (new StringBuilder("SELECT * FROM cliente WHERE clienteAtivo = 'S' AND clienteNomeFantasia LIKE '%")).append(keyWord).append("%' ORDER BY clienteID DESC").toString();
    }

    public String verificaCnpj()
    {
        return (new StringBuilder("SELECT clienteCnpj FROM cliente WHERE clienteCnpj = '")).append(cnpj).append("'").toString();
    }

    public String verificaCnpjAlterar()
    {
        return (new StringBuilder("SELECT clienteCnpj FROM cliente WHERE clienteCnpj = '")).append(cnpj).append("' AND clienteID <> '").append(clienteID).append("'").toString();
    }

    public String salvarCliente()
    {
        String salvaCli = "INSERT INTO cliente (tipoPessoa, clienteNomeFantasia, clienteRazaoSocial, clienteCnpj, clienteInscEstadual, ";
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("clienteInscMunicipal, clienteEndereco, clienteNumero, clienteBairro, clienteCep, clienteCidade, clienteUf, ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("clienteComplemento, clienteContato, clienteTelefone, clienteFax, clienteRadio, clienteCelular, operadoraCelular, ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("clienteEmail, clienteSite, clienteUsuario, limiteCredito) VALUES ('").append(tipoPessoa).append("', '").append(nomeFantasia).append("', '").append(razaoSocial).append("', ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("'").append(cnpj).append("', '").append(inscEstadual).append("', '").append(inscMunicipal).append("', '").append(endereco.logradouro).append("', '").append(endereco.numero).append("', ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("'").append(endereco.bairro).append("', '").append(endereco.cep).append("', '").append(endereco.cidade).append("', '").append(endereco.uf).append("', '").append(endereco.complemento).append("', ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("'").append(contato).append("', '").append(telefone).append("', '").append(fax).append("', '").append(radio).append("', '").append(celular).append("', ").toString();
        salvaCli = (new StringBuilder(String.valueOf(salvaCli))).append("'").append(operadoraCelular).append("', '").append(email).append("', '").append(site).append("', '").append(usuario).append("', '").append(limiteCredito).append("')").toString();
        return salvaCli;
    }

    public String alteraCliente()
    {
        String editaCli = "UPDATE  cliente SET  ";
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("tipoPessoa = '").append(tipoPessoa).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteNomeFantasia =  '").append(nomeFantasia).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteRazaoSocial =  '").append(razaoSocial).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteCnpj =  '").append(cnpj).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteInscEstadual =  '").append(inscEstadual).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteInscMunicipal =  '").append(inscMunicipal).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteEndereco =  '").append(endereco.logradouro).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteNumero =  '").append(endereco.numero).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteBairro =  '").append(endereco.bairro).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteCep =  '").append(endereco.cep).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteCidade =  '").append(endereco.cidade).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteUf =  '").append(endereco.uf).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteComplemento =  '").append(endereco.complemento).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteContato =  '").append(contato).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteTelefone =  '").append(telefone).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteFax =  '").append(fax).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteRadio =  '").append(radio).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteCelular =  '").append(celular).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("operadoraCelular =  '").append(operadoraCelular).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteEmail =  '").append(email).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteSite =  '").append(site).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("clienteUsuario =  '").append(usuario.nome).append("', ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("limiteCredito =  '").append(limiteCredito).append("' ").toString();
        editaCli = (new StringBuilder(String.valueOf(editaCli))).append("WHERE  clienteID = '").append(clienteID).append("'").toString();
        return editaCli;
    }

    public String excluirCliente()
    {
        return (new StringBuilder("DELETE FROM cliente WHERE clienteID = '")).append(clienteID).append("'").toString();
    }

    public String statusCliente(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE cliente SET clienteAtivo = 'N' WHERE clienteID = '")).append(clienteID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE cliente SET clienteAtivo = 'S' WHERE clienteID = '")).append(clienteID).append("'").toString();
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Cliente Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Cliente Alterado com Sucesso!";

        case 3: // '\003'
            return "Cliente Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um cliente cadastrado com esse CPF / CNPJ.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um cliente cadastrado com esse CPF / CNPJ.";
        }
        return "";
    }

    public int clienteID;
    public String tipoPessoa;
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
    public String limiteCredito;
}
