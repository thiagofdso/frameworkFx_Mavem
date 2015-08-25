package com.utilidades;

import static com.utilidades.DateUtils.asLocalDate;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Casa
 */
public class FuncaoEstatica {

    public static List<String> split(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tok = new StringTokenizer(str);
        while (tok.hasMoreTokens()) {
            String token = tok.nextToken().trim();
            if (token.length() > 0) {
                tokens.add(token);
            }
        }
        return tokens;
    }

    /**
     * Função que retorna a idade atual
     *
     * @param dataNascimento data de nascimento
     * @return idade do atual
     * @IllegalArgumentException retorna 0
     */

    public static Integer getIdade(Date dataNascimento) {
        int idade;
        try {
            idade = Period.between(asLocalDate(dataNascimento), LocalDate.now()).getYears();
        } catch (IllegalArgumentException ex) {
            idade = 0;
        }
        return idade;
    }

    public static String md5(String senha) {
        String sen;
        sen = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash;
            hash = new BigInteger(1, md.digest(senha.getBytes()));
            sen = hash.toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }

        return sen;
    }
    
    public static String getDNSName() {
        String hostname = "Unknown";

        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }


    /**
     * Função que retorna a idade atual
     *
     * @param contexto
     * @param matricula
     * @param dataNascimento data de nascimento
     * @param dataAtual data a ser subitraida
     * @return idade do atual
     * @IllegalArgumentException retorna 0
     */
    public static Integer getIdade(Date dataNascimento, Date dataAtual) {
        int idade;
        try {
            idade = Period.between(asLocalDate(dataNascimento), asLocalDate(dataAtual)).getYears();
        } catch (IllegalArgumentException ex) {
            idade = 0;
        }
        return idade;
    }
    
    
}
