// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Mensagens.java

package acesso;


public class Mensagens
{

    public Mensagens()
    {
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Antes de Fazer uma Venda Por favor Abra o Caixa!";

        case 2: // '\002'
            return "Voc\352 n\343o tem autoriza\347\343o para acessar essa P\341gina";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }
}
