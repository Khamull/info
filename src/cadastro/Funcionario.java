// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Funcionario.java

package cadastro;


// Referenced classes of package cadastro:
//            Endereco, Empresa

public class Funcionario
{

    public Funcionario()
    {
        endereco = new Endereco();
        empresa = new Empresa();
    }

    public String listaFuncionario()
    {
        return "SELECT * FROM funcionario ORDER BY funcionarioNome ASC";
    }

    public String listaFuncionarioAtivos()
    {
        return "SELECT * FROM funcionario WHERE funcionarioAtivo = 'S' ORDER BY funcionarioNome ASC";
    }

    public String pesquisaFuncionario(String keyWord)
    {
        return (new StringBuilder("SELECT * FROM funcionario WHERE funcionarioAtivo = 'S' AND funcionarioNome LIKE '%")).append(keyWord).append("%' ORDER BY funcionarioID DESC").toString();
    }

    public String listaFuncionariosOrdenados()
    {
        String dadosFunc = "SELECT cargo.cargoID, cargo.cargoTitulo, funcionario.* FROM funcionario ";
        dadosFunc = (new StringBuilder(String.valueOf(dadosFunc))).append("INNER JOIN cargo ON cargo.cargoID = funcionario.cargoID ").toString();
        dadosFunc = (new StringBuilder(String.valueOf(dadosFunc))).append("WHERE funcionario.funcionarioAtivo = 'S' ORDER BY funcionario.funcionarioNome ASC").toString();
        return dadosFunc;
    }

    public String funcionarioPorId()
    {
        String dadosFunc = "SELECT cargo.cargoID, cargo.cargoTitulo, funcionario.* FROM funcionario ";
        dadosFunc = (new StringBuilder(String.valueOf(dadosFunc))).append("INNER JOIN cargo ON cargo.cargoID = funcionario.cargoID ").toString();
        dadosFunc = (new StringBuilder(String.valueOf(dadosFunc))).append("WHERE funcionario.funcionarioID = '").append(funcionarioID).append("'").toString();
        return dadosFunc;
    }

    public String salvarFuncionario()
    {
        String salvaFuncionario = "INSERT INTO funcionario ";
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("(funcionarioNome, cargoID, funcionarioNascimento, funcionarioRg, ").toString();
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("funcionarioCpf, funcionarioEndereco, funcionarioNumero, funcionarioBairro, ").toString();
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("funcionarioCep, funcionarioCidade, funcionarioUf, funcionarioComplemento, ").toString();
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("funcionarioTelefone, funcionarioCelular, operadoraCelular, funcionarioEmail, ").toString();
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("funcionarioUsuario, empresaID) VALUES ").toString();
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("('").append(nome).append("', '").append(cargo).append("', '").append(nascimento).append("', '").append(rg).append("', '").append(cpf).append("', '").append(endereco.logradouro).append("', ").toString();
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("'").append(endereco.numero).append("', '").append(endereco.bairro).append("', '").append(endereco.cep).append("', ").toString();
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("'").append(endereco.cidade).append("', '").append(endereco.uf).append("', '").append(endereco.complemento).append("', ").toString();
        salvaFuncionario = (new StringBuilder(String.valueOf(salvaFuncionario))).append("'").append(telefone).append("', '").append(celular).append("', '").append(operadoraCelular).append("', '").append(email).append("', '").append(funcionarioUsuario).append("', '").append(empresa.empresaID).append("')").toString();
        return salvaFuncionario;
    }

    public String alterarFuncionario()
    {
        String alteraFunc = (new StringBuilder("UPDATE funcionario SET cargoID = '")).append(cargo).append("', funcionarioNome = '").append(nome).append("', funcionarioNascimento = '").append(nascimento).append("', ").toString();
        alteraFunc = (new StringBuilder(String.valueOf(alteraFunc))).append("funcionarioRg = '").append(rg).append("', funcionarioCpf = '").append(cpf).append("', funcionarioEndereco = '").append(endereco.logradouro).append("', ").toString();
        alteraFunc = (new StringBuilder(String.valueOf(alteraFunc))).append("funcionarioNumero = '").append(endereco.numero).append("', funcionarioBairro = '").append(endereco.bairro).append("', funcionarioCep = '").append(endereco.cep).append("', ").toString();
        alteraFunc = (new StringBuilder(String.valueOf(alteraFunc))).append("funcionarioCidade = '").append(endereco.cidade).append("', funcionarioUf = '").append(endereco.uf).append("', funcionarioComplemento = '").append(endereco.complemento).append("', ").toString();
        alteraFunc = (new StringBuilder(String.valueOf(alteraFunc))).append("funcionarioTelefone = '").append(telefone).append("', funcionarioCelular = '").append(celular).append("', operadoraCelular = '").append(operadoraCelular).append("', ").toString();
        alteraFunc = (new StringBuilder(String.valueOf(alteraFunc))).append("funcionarioEmail = '").append(email).append("' WHERE funcionarioID = '").append(funcionarioID).append("'").toString();
        return alteraFunc;
    }

    public String excluirFuncionario()
    {
        return (new StringBuilder("DELETE FROM funcionario WHERE funcionarioID = '")).append(funcionarioID).append("'").toString();
    }

    public String verificaCpf()
    {
        return (new StringBuilder("SELECT * FROM funcionario WHERE funcionarioCpf = '")).append(cpf).append("'").toString();
    }

    public String verificaCpfAlterar()
    {
        return (new StringBuilder("SELECT * FROM funcionario WHERE funcionarioCpf = '")).append(cpf).append("' AND funcionarioID <> '").append(funcionarioID).append("'").toString();
    }

    public String statusFuncionario(int numeroAcao)
    {
        if(numeroAcao == 1)
            return (new StringBuilder("UPDATE funcionario SET funcionarioAtivo = 'N' WHERE funcionarioID = '")).append(funcionarioID).append("'").toString();
        if(numeroAcao == 2)
            return (new StringBuilder("UPDATE funcionario SET funcionarioAtivo = 'S' WHERE funcionarioID = '")).append(funcionarioID).append("'").toString();
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Funcionario Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Funcionario Alterado com Sucesso!";

        case 3: // '\003'
            return "Funcionario Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um funcionario cadastrado com esse CPF.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um funcionario cadastrado com esse CPF.";
        }
        return "";
    }

    public int funcionarioID;
    public String cargo;
    public String nome;
    public String nascimento;
    public String rg;
    public String cpf;
    public Endereco endereco;
    public String telefone;
    public String celular;
    public String operadoraCelular;
    public String email;
    public String funcionarioUsuario;
    public Empresa empresa;
}
