// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Datas.java

package formatar;

import java.util.Calendar;

public class Datas
{

    public Datas()
    {
        hoje = Calendar.getInstance();
    }

    public String diaAtual()
    {
        int d = hoje.get(5);
        String dia = String.valueOf(d);
        if(dia.length() < 2)
            dia = (new StringBuilder("0")).append(dia).toString();
        return dia;
    }

    public String mesAtual()
    {
        int m = hoje.get(2);
        String mes = String.valueOf(1 + m);
        if(mes.length() < 2)
            mes = (new StringBuilder("0")).append(mes).toString();
        return mes;
    }

    public String anoAtual()
    {
        int a = hoje.get(1);
        String ano = String.valueOf(a);
        return ano;
    }

    public String dataAtual()
    {
        String dia = diaAtual();
        String mes = mesAtual();
        String ano = anoAtual();
        String dataHoje = (new StringBuilder(String.valueOf(dia))).append("/").append(mes).append("/").append(ano).toString();
        return dataHoje;
    }

    public String converteParaData(String dataSimples)
    {
        String a[] = new String[3];
        a = dataSimples.split("/");
        String dataFormatada = (new StringBuilder(String.valueOf(a[2]))).append("-").append(a[1]).append("-").append(a[0]).toString();
        return dataFormatada;
    }

    public String converteDeData(String dataSimples)
    {
        String a[] = new String[3];
        a = dataSimples.split("-");
        String dataFormatada = (new StringBuilder(String.valueOf(a[2]))).append("/").append(a[1]).append("/").append(a[0]).toString();
        return dataFormatada;
    }

    public String trataData(String dataSimples)
    {
        String a[] = new String[3];
        a = dataSimples.split("/");
        String dia = a[0];
        String mes = a[1];
        String ano = a[2];
        int mes1 = Integer.parseInt(mes);
        int ano1 = Integer.parseInt(ano);
        if(mes1 > 12 && mes1 <= 24)
        {
            mes = String.valueOf(mes1 - 12);
            ano = String.valueOf(ano1 + 1);
        } else
        if(mes1 > 24 && mes1 <= 36)
        {
            mes = String.valueOf(mes1 - 24);
            ano = String.valueOf(ano1 + 2);
        } else
        if(mes1 > 36 && mes1 <= 48)
        {
            mes = String.valueOf(mes1 - 36);
            ano = String.valueOf(ano1 + 3);
        } else
        if(mes1 > 48 && mes1 <= 60)
        {
            mes = String.valueOf(mes1 - 48);
            ano = String.valueOf(ano1 + 4);
        } else
        if(mes1 > 60 && mes1 <= 72)
        {
            mes = String.valueOf(mes1 - 60);
            ano = String.valueOf(ano1 + 5);
        } else
        if(mes1 > 72 && mes1 <= 84)
        {
            mes = String.valueOf(mes1 - 72);
            ano = String.valueOf(ano1 + 6);
        }
        if(mes.length() < 2)
            mes = (new StringBuilder("0")).append(mes).toString();
        String dataFormatada = (new StringBuilder(String.valueOf(ano))).append("-").append(mes).append("-").append(dia).toString();
        return dataFormatada;
    }

    public String retornaData(int mes)
    {
        switch(mes)
        {
        case 1: // '\001'
            return "JANEIRO";

        case 2: // '\002'
            return "FEVEREIRO";

        case 3: // '\003'
            return "MAR\307O";

        case 4: // '\004'
            return "ABRIL";

        case 5: // '\005'
            return "MAIO";

        case 6: // '\006'
            return "JUNHO";

        case 7: // '\007'
            return "JULHO";

        case 8: // '\b'
            return "AGOSTO";

        case 9: // '\t'
            return "SETEMBRO";

        case 10: // '\n'
            return "OUTUBRO";

        case 11: // '\013'
            return "NOVEMBRO";

        case 12: // '\f'
            return "DEZEMBRO";
        }
        return "";
    }

    public String verificaSeExiste(int dia, int mes)
    {
        if(dia >= 28 && mes == 2)
            return (new StringBuilder("28-")).append(mes).toString();
        if(dia >= 30 && mes == 4 || dia >= 30 && mes == 6 || dia >= 30 && mes == 9 || dia >= 30 && mes == 11)
            return (new StringBuilder("30-")).append(mes).toString();
        if(dia >= 28 && mes == 14)
            return (new StringBuilder("28-")).append(mes).toString();
        if(dia >= 30 && mes == 16 || dia >= 30 && mes == 18 || dia >= 30 && mes == 21 || dia >= 30 && mes == 23)
            return (new StringBuilder("30-")).append(mes).toString();
        if(dia >= 28 && mes == 26)
            return (new StringBuilder("28-")).append(mes).toString();
        if(dia >= 30 && mes == 28 || dia >= 30 && mes == 30 || dia >= 30 && mes == 33 || dia >= 30 && mes == 35)
            return (new StringBuilder("30-")).append(mes).toString();
        if(dia >= 28 && mes == 38)
            return (new StringBuilder("28-")).append(mes).toString();
        if(dia >= 30 && mes == 40 || dia >= 30 && mes == 42 || dia >= 30 && mes == 45 || dia >= 30 && mes == 47)
            return (new StringBuilder("30-")).append(mes).toString();
        if(dia >= 28 && mes == 50)
            return (new StringBuilder("28-")).append(mes).toString();
        if(dia >= 30 && mes == 52 || dia >= 30 && mes == 54 || dia >= 30 && mes == 37 || dia >= 30 && mes == 59)
            return (new StringBuilder("30-")).append(mes).toString();
        if(dia >= 28 && mes == 62)
            return (new StringBuilder("28-")).append(mes).toString();
        if(dia >= 30 && mes == 64 || dia >= 30 && mes == 66 || dia >= 30 && mes == 69 || dia >= 30 && mes == 71)
            return (new StringBuilder("30-")).append(mes).toString();
        else
            return (new StringBuilder(String.valueOf(dia))).append("-").append(mes).toString();
    }

    public String verificaDataVencimento(String dataSimples)
    {
        String a[] = new String[3];
        a = dataSimples.split("-");
        int dia = Integer.parseInt(diaAtual());
        int mes = Integer.parseInt(mesAtual());
        int ano = Integer.parseInt(anoAtual());
        int diaP = Integer.parseInt(a[2]);
        int mesP = Integer.parseInt(a[1]);
        int anoP = Integer.parseInt(a[0]);
        if(anoP == ano && mesP == mes && diaP == dia)
            return "igual";
        if(anoP <= ano && mesP <= mes && diaP < dia)
            return "menor";
        if(anoP <= ano && mesP < mes)
            return "menor";
        else
            return "maior";
    }

    public String calculaIntervalo(int ano, int mes, int dia, int dias)
    {
        hoje.set(ano, mes - 1, dia);
        hoje.add(5, dias);
        int d = hoje.get(5);
        int m = hoje.get(2);
        int a = hoje.get(1);
        String data = (new StringBuilder(String.valueOf(String.valueOf(a)))).append("-").append(String.valueOf(m + 1)).append("-").append(String.valueOf(d)).toString();
        return data;
    }

    public String subtrairIntervalo(String dataSimples, int dias)
    {
        String a[] = new String[3];
        a = dataSimples.split("-");
        int dia = Integer.parseInt(a[2]);
        int mes = Integer.parseInt(a[1]);
        int ano = Integer.parseInt(a[0]);
        hoje.set(ano, mes - 1, dia);
        hoje.add(5, dias);
        int d = hoje.get(5);
        int m = hoje.get(2);
        int aa = hoje.get(1);
        String data = (new StringBuilder(String.valueOf(String.valueOf(aa)))).append("-").append(String.valueOf(m + 1)).append("-").append(String.valueOf(d)).toString();
        return data;
    }

    Calendar hoje;
}
