package br.com.propeest.armariosifsp.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    public static String md5(String senha) throws NoSuchAlgorithmException {

        MessageDigest messagedig = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, messagedig.digest(senha.getBytes()));
        return hash.toString(16);
    }
}